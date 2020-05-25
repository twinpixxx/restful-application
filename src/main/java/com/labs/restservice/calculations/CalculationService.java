package com.labs.restservice.calculations;

import com.labs.restservice.exception.InternalException.InternalArithmeticException;
import com.labs.restservice.triangle.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import static java.lang.Math.sqrt;

@Service("CalculationService")
public class CalculationService {
    private static final Logger log = LoggerFactory.getLogger(CalculationService.class);



    public CalculationService() {}

    public double getArea(Triangle _triangle) {
        final double halfPerimeter = (getPerimeter(_triangle)/2);
        final double area = sqrt(halfPerimeter *
                (halfPerimeter - _triangle.getFirstSide()) *
                (halfPerimeter - _triangle.getSecondSide()) *
                (halfPerimeter - _triangle.getThirdSide()));
        log.info(String.format("Getting the area of triangle" +
                                "Triangle Area = %s", area));
        return area;
    }

    public long getPerimeter(Triangle _triangle) {
        final long perimeter =
                _triangle.getFirstSide() + _triangle.getSecondSide() + _triangle.getThirdSide();
        log.info(String.format("Getting the perimeter of triangle" +
                                "Triangle Perimeter = %s", perimeter));
        if (perimeter < Integer.MAX_VALUE) {
            return perimeter;
        } else {
            throw new InternalArithmeticException("Integer Overflow", 500);
        }
    }
}
