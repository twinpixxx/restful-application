package com.epam.triangful.dto;

public class CalculationResultsDto {
    private long perimeter;
    private double area;


    public CalculationResultsDto() {};

    public CalculationResultsDto(int _perimeter, double _area) {
        this.perimeter = _perimeter;
        this.area = _area;
    }

    public void copyResults(CalculationResultsDto _results) {
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
