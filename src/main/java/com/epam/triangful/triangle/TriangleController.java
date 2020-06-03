package com.epam.triangful.triangle;


import com.epam.triangful.calculations.CalculationService;
import com.epam.triangful.concurrency.ServiceAccessManager;
import com.epam.triangful.dto.*;
import com.epam.triangful.exception.ApiException.ApiRequestException;
import com.epam.triangful.cache.TriangleCacheService;
import com.epam.triangful.persistence.BulkService;
import com.epam.triangful.statistics.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
public class TriangleController {
    @Autowired
    private CalculationService calculator;

    @Autowired
    private TriangleCacheService cache;

    @Autowired
    private ServiceAccessManager accessManager;

    @Autowired
    private BulkService bulkStore;

    private static final Logger log = LoggerFactory.getLogger(TriangleController.class);

    @GetMapping("/triangle")
    public CalculationResultsDto TriangleCalculation(@RequestParam(value = "a") int firstSide
                                , @RequestParam(value = "b") int secondSide
                                , @RequestParam(value = "c") int thirdSide) {
        log.info(String.format("/triangle controller detected request with params:" +
                "first side = %s, second side = %s, third side = %s", firstSide, secondSide, thirdSide));
        if ((firstSide <=  0) ||
                (secondSide <= 0) ||
                (thirdSide <= 0)) {
            throw new ApiRequestException("Triangle side(s) should be positive");
        }
        accessManager.requestCounter();
        TriangleDto triangle =  new TriangleDto(firstSide, secondSide, thirdSide);
        CalculationResultsDto results = new CalculationResultsDto();
        return cache.getCacheList()
                .stream()
                .parallel()
                .filter(e -> triangle.equals(e.getTriangle()))
                .map(e -> {
                    log.info("Getting info from cache");
                    return e.getResults();
                })
                .findAny()
                .orElseGet(() -> {
                    results.setPerimeter(calculator.getPerimeter(triangle));
                    results.setArea(calculator.getArea(triangle));
                    cache.add(triangle, results);
                    return results;
                });
    }

    @PostMapping("/triangle")
    public String bulkTriangleCalculation(@RequestBody TriangleListDto triangles) {
        CalculationResultsListDto resultsList = new CalculationResultsListDto();
        CalculationResultsDto results = new CalculationResultsDto();
        TriangleBulkResponseDto response = new TriangleBulkResponseDto();
        StatisticsService statsService = new StatisticsService();

        String uuid = UUID.randomUUID().toString();
        CompletableFuture.runAsync(() -> {
            triangles.getTriangles()
                    .stream()
                    .parallel()
                    .forEach(triangle -> {
                        if (cache.contains(triangle)) {
                            log.info("Getting info from cache");
                            resultsList.addFromResults(cache.getResults(triangle));
                        } else {
                            log.info("Calculation");
                            resultsList.add(calculator.getArea(triangle),
                                    calculator.getPerimeter(triangle));
                            results.setArea(calculator.getArea(triangle));
                            results.setPerimeter(calculator.getPerimeter(triangle));
                            log.info("Adding calcs to cache");
                            cache.add(triangle, calculator.getArea(triangle),
                                    calculator.getPerimeter(triangle));
                        }
                    });
            response.setResults(resultsList);
            statsService.makeStats(triangles.getTriangles(), resultsList.getResultsList());
            response.setStats(statsService.getStats());
            response.setId(uuid);
            bulkStore.keep(response);
        });
        return uuid;
    }

    @GetMapping("/triangle/getAll")
    public TriangleBulkResponseDto gettingBulkResults(@RequestParam(value = "uuid") String uuid) {
        log.info(String.format("Getting results of bulk operation by %s id", uuid));
        return bulkStore.getResults(uuid);
    }
}