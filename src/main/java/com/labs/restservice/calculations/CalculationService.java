package com.labs.restservice.calculations;

import com.labs.restservice.exception.InternalException.InternalArithmeticException;
import com.labs.restservice.triangle.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculationService {
    private long firstSide, secondSide, thirdSide;
    private static final Logger log = LoggerFactory.getLogger(CalculationService.class);

    public CalculationService() {};

    public CalculationService(Triangle _triangle) {
        this.firstSide = _triangle.getFirstSide();
        this.secondSide = _triangle.getSecondSide();
        this.thirdSide = _triangle.getThirdSide();
    }

    public double getArea() {
        final long halfPerimeter = (this.getPerimeter()/2);
        final double area = java.lang.Math.sqrt(halfPerimeter*(halfPerimeter-this.firstSide)*(halfPerimeter-this.secondSide)*
                (halfPerimeter-this.secondSide));
        log.info(String.format("Getting the area of triangle" +
                                "Triangle Area = %s", area));
        return area;
    }
    public long getPerimeter() {
        final long perimeter = firstSide + secondSide + thirdSide;
        log.info(String.format("Getting the perimeter of triangle" +
                                "Triangle Perimeter = %s", perimeter));
        if (perimeter < Integer.MAX_VALUE) {
            return perimeter;
        } else {
            throw new InternalArithmeticException("Integer Overflow", 500);
        }
    }
}
