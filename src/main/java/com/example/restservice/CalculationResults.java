package com.example.restservice;

public class CalculationResults {
    private int perimeter;
    private double area;


    public CalculationResults() {};

    public CalculationResults(int _perimeter, double _area) {
        this.perimeter = _perimeter;
        this.area = _area;
    }


    public void setArea(double _area) {
        this.area = _area;
    }

    public void setPerimeter(int _perimeter) {
        this.perimeter = _perimeter;
    }

    public int getPerimeter() { return this.perimeter; }
    public double getArea() { return this.area; }
}
