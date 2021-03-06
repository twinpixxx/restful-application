package com.epam.triangful.dto;

import com.epam.triangful.exception.ApiException.ApiRequestException;
import com.epam.triangful.triangle.TriangleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class TriangleDto {
    private long firstSide, secondSide, thirdSide;
    private static final Logger log = LoggerFactory.getLogger(TriangleController.class);


    public TriangleDto(long firstSide, long secondSide, long thirdSide) {
        if (((firstSide + secondSide) > thirdSide) &&
                ((firstSide + thirdSide) > secondSide) &&
                ((secondSide + thirdSide) > firstSide)) {
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
            log.info("Triangle object successfully created");
        } else {
            throw new ApiRequestException("Triangle cannot be created due to wrong side length.");
        }
    }

    public TriangleDto() {}

    public long getFirstSide () {
        log.info("Getting the first size of triangle");
        return this.firstSide;
    }
    public long getSecondSide () {
        log.info("Getting the second size of triangle");
        return this.secondSide;
    }
    public long getThirdSide () {
        log.info("Getting the third size of triangle");
        return this.thirdSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleDto triangle = (TriangleDto) o;
        return firstSide == triangle.firstSide &&
                secondSide == triangle.secondSide &&
                thirdSide == triangle.thirdSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }
}
