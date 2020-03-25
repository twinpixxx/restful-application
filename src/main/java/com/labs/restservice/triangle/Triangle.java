package com.labs.restservice.triangle;

public class Triangle {
    private int firstSide, secondSide, thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }
    public int getFirstSide () { return this.firstSide; }
    public int getSecondSide () { return this.secondSide; }
    public int getThirdSide () { return this.thirdSide; }
}
