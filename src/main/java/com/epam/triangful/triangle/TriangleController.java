package com.epam.triangful.triangle;

import com.epam.triangful.calculations.CalculationResults;
import com.epam.triangful.calculations.CalculationService;
import com.epam.triangful.concurrency.ServiceAccessManager;
import com.epam.triangful.exception.ApiException.ApiRequestException;
import com.epam.triangful.cache.TriangleCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public CalculationResults TriangleCalculation(@RequestParam(value = "a") int firstSide
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
        CalculationResults results = new CalculationResults();
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
}