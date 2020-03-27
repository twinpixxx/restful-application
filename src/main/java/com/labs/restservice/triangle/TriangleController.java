package com.labs.restservice.triangle;

import com.labs.restservice.calculations.CalculationResults;
import com.labs.restservice.calculations.CalculationService;
import com.labs.restservice.exception.ApiException.ApiRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {


    @GetMapping("/triangle")
    public CalculationResults TriangleCalculation(@RequestParam(value = "a") int firstSide
                                , @RequestParam(value = "b") int secondSide
                                , @RequestParam(value = "c") int thirdSide) {
        if ((firstSide <=  0) ||
                (secondSide <= 0) ||
                (thirdSide <= 0)) {
            throw  new ApiRequestException("Triangle side(s) should be positive");
        }
        Triangle triangle =  new Triangle(firstSide, secondSide, thirdSide);
        CalculationResults results = new CalculationResults();
        CalculationService calculator = new CalculationService(triangle);
        results.setPerimeter(calculator.getPerimeter());
        results.setArea(calculator.getArea());
        return  results;
    }
}