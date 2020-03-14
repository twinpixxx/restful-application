package com.example.restservice;

public class Triangle {
    private int firstSide, secondSide, thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public Triangle() {
        this.firstSide = 10;
        this.secondSide = 12;
        this.thirdSide = 13;
    }

    public int getTrianglePerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    public double getTriangleArea() {
        final int halfPerimeter = (this.getTrianglePerimeter()/2);
        return java.lang.Math.sqrt(halfPerimeter*(halfPerimeter-this.firstSide)*(halfPerimeter-this.secondSide)*
                (halfPerimeter-this.secondSide));
    }
}
