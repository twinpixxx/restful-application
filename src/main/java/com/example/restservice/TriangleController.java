package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
public class TriangleController {


    @GetMapping("/triangle")
    public Triangle greeting(@RequestParam(value = "a") int firstSide
                                , @RequestParam(value = "b") int secondSide
                                , @RequestParam(value = "c") int thirdSide, Model model) {
        model.addAttribute("firstSide", firstSide);
        model.addAttribute("secondSide", secondSide);
        model.addAttribute("thirdSide", thirdSide);
        return new Triangle(firstSide, secondSide, thirdSide);
    }
}