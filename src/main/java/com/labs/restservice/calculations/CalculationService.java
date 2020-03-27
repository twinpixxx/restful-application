package com.labs.restservice.calculations;

import com.labs.restservice.exception.InternalException.InternalArithmeticException;
import com.labs.restservice.triangle.Triangle;

public class CalculationService {
    private long firstSide, secondSide, thirdSide;

    public CalculationService() {};

    public CalculationService(Triangle _triangle) {
        this.firstSide = _triangle.getFirstSide();
        this.secondSide = _triangle.getSecondSide();
        this.thirdSide = _triangle.getThirdSide();
    }

    public double getArea() {
        final long halfPerimeter = (this.getPerimeter()/2);
        return java.lang.Math.sqrt(halfPerimeter*(halfPerimeter-this.firstSide)*(halfPerimeter-this.secondSide)*
                (halfPerimeter-this.secondSide));
    }
    public long getPerimeter() {
        long perimeter = firstSide + secondSide + thirdSide;
        if (perimeter < Integer.MAX_VALUE) {
            return perimeter;
        } else {
            throw new InternalArithmeticException("Integer Overflow", 500);
        }
    }
}
