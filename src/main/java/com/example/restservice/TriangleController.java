package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {


    @GetMapping("/triangle")
    public Triangle greeting(@RequestParam(value = "a") int firstSide
                                , @RequestParam(value = "b") int secondSide
                                , @RequestParam(value = "c") int thirdSide) {
        return new Triangle(firstSide, secondSide, thirdSide);
    }
}