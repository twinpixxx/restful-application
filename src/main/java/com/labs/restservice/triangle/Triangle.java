package com.labs.restservice.triangle;

import com.labs.restservice.exception.ApiException.ApiRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle {
    private long firstSide, secondSide, thirdSide;
    private static final Logger log = LoggerFactory.getLogger(TriangleController.class);


    public Triangle(long firstSide, long secondSide, long thirdSide) {
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
}
