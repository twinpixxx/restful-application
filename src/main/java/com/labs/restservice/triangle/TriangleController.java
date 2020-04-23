package com.labs.restservice.triangle;

import com.labs.restservice.calculations.CalculationResults;
import com.labs.restservice.calculations.CalculationService;
import com.labs.restservice.exception.ApiException.ApiRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {
    CalculationService calculator = new CalculationService();

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
            throw  new ApiRequestException("Triangle side(s) should be positive");
        }
        Triangle triangle =  new Triangle(firstSide, secondSide, thirdSide);
        CalculationResults results = new CalculationResults();
        results.setPerimeter(calculator.getPerimeter(triangle));
        results.setArea(calculator.getArea(triangle));
        return  results;
    }
}