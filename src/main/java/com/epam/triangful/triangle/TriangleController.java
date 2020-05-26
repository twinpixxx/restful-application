package com.epam.triangful.triangle;

import com.epam.triangful.dto.CalculationResultsDto;
import com.epam.triangful.calculations.CalculationService;
import com.epam.triangful.concurrency.ServiceAccessManager;
import com.epam.triangful.dto.CalculationResultsListDto;
import com.epam.triangful.dto.TriangleBulkResponseDto;
import com.epam.triangful.dto.TriangleListDto;
import com.epam.triangful.exception.ApiException.ApiRequestException;
import com.epam.triangful.cache.TriangleCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TriangleController {
    @Autowired
    private CalculationService calculator;

    @Autowired
    private TriangleCacheService cache;

    @Autowired
    private ServiceAccessManager accessManager;

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
        Triangle triangle =  new Triangle(firstSide, secondSide, thirdSide);
        CalculationResultsDto results = new CalculationResultsDto();
        return cache.getCache().entrySet()
                .stream()
                .parallel()
                .filter(pair -> triangle.equals(pair.getKey()))
                .map(pair -> {
                    log.info("Getting info from cache");
                    return pair.getValue();
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
    public TriangleBulkResponseDto bulkTriangleCalculation(@RequestBody TriangleListDto triangles) {
        CalculationResultsListDto resultsList = new CalculationResultsListDto();
        CalculationResultsDto results = new CalculationResultsDto();
        TriangleBulkResponseDto response = new TriangleBulkResponseDto();

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
        return response;
    }
}