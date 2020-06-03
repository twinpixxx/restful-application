package com.epam.triangful.dto;

public class StatisticsDto {
    long totalAmount;
    long totalAmountOfIncorrect;
    double maxArea;
    double minArea;
    long maxPerimeter;
    long minPerimeter;
    double mostPopularArea;
    long mostPopularPerimeter;

    public StatisticsDto() {}

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getTotalAmountOfIncorrect() {
        return totalAmountOfIncorrect;
    }

    public void setTotalAmountOfIncorrect(long totalAmountOfIncorrect) {
        this.totalAmountOfIncorrect = totalAmountOfIncorrect;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public long getMaxPerimeter() {
        return maxPerimeter;
    }

    public void setMaxPerimeter(long maxPerimeter) {
        this.maxPerimeter = maxPerimeter;
    }

    public long getMinPerimeter() {
        return minPerimeter;
    }

    public void setMinPerimeter(long minPerimeter) {
        this.minPerimeter = minPerimeter;
    }

    public double getMostPopularArea() {
        return mostPopularArea;
    }

    public void setMostPopularArea(double mostPopularArea) {
        this.mostPopularArea = mostPopularArea;
    }

    public long getMostPopularPerimeter() {
        return mostPopularPerimeter;
    }

    public void setMostPopularPerimeter(long mostPopularPerimeter) {
        this.mostPopularPerimeter = mostPopularPerimeter;
    }
}
