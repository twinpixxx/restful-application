package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {


    @GetMapping("/triangle")
    public CalculationResults TriangleCalculation(@RequestParam(value = "a") int firstSide
                                , @RequestParam(value = "b") int secondSide
                                , @RequestParam(value = "c") int thirdSide) {
        Triangle triangle =  new Triangle(firstSide, secondSide, thirdSide);
        CalculationResults results = new CalculationResults();
        CalculationService calculator = new CalculationService(triangle);
        results.setPerimeter(calculator.getPerimeter());
        results.setArea(calculator.getArea());
        return  results;
    }
}