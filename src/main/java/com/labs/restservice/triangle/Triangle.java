package com.labs.restservice.triangle;

public class Triangle {
    private int firstSide, secondSide, thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
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
    public int getFirstSide () { return this.firstSide; }
    public int getSecondSide () { return this.secondSide; }
    public int getThirdSide () { return this.thirdSide; }
}
