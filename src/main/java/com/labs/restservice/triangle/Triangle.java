package com.labs.restservice.triangle;

import com.labs.restservice.exception.ApiException.ApiRequestException;

public class Triangle {
    private long firstSide, secondSide, thirdSide;

    public Triangle(long firstSide, long secondSide, long thirdSide) {
        if (((firstSide + secondSide) > thirdSide) ||
                ((firstSide + thirdSide) > secondSide) ||
                ((secondSide + thirdSide) > firstSide)) {
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
        } else {
            throw new ApiRequestException("Triangle cannot be created due to wrong side length.");
        }
    }
    public long getFirstSide () { return this.firstSide; }
    public long getSecondSide () { return this.secondSide; }
    public long getThirdSide () { return this.thirdSide; }
}
