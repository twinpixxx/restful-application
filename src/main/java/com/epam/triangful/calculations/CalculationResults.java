package com.epam.triangful.calculations;

public class CalculationResults {
    private long perimeter;
    private double area;


    public CalculationResults() {};

    public CalculationResults(int _perimeter, double _area) {
        this.perimeter = _perimeter;
        this.area = _area;
    }

    public void copyResults(CalculationResults _results) {
        perimeter = _results.perimeter;
        area = _results.area;
    }

    public void setArea(double _area) {
        this.area = _area;
    }

    public void setPerimeter(long _perimeter) {
        this.perimeter = _perimeter;
    }

    public long getPerimeter() { return this.perimeter; }
    public double getArea() { return this.area; }
}
