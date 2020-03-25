package com.labs.restservice.calculations;

import com.labs.restservice.triangle.Triangle;

public class CalculationService {
    private int firstSide, secondSide, thirdSide;

    public CalculationService() {};

    public CalculationService(Triangle _triangle) {
        this.firstSide = _triangle.getFirstSide();
        this.secondSide = _triangle.getSecondSide();
        this.thirdSide = _triangle.getThirdSide();
    }

    public double getArea() {
        final int halfPerimeter = (this.getPerimeter()/2);
        return java.lang.Math.sqrt(halfPerimeter*(halfPerimeter-this.firstSide)*(halfPerimeter-this.secondSide)*
                (halfPerimeter-this.secondSide));
    }
    public int getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }
}
