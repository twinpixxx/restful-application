package com.epam.triangful.statistics;

import com.epam.triangful.dto.CalculationResultsDto;
import com.epam.triangful.dto.statisticsDto;
import com.epam.triangful.triangle.Triangle;

import java.util.ArrayList;

public class statisticsService {
    long totalAmount;
    long totalAmountOfIncorrect;
    double maxArea;
    double minArea;
    long maxPerimeter;
    long minPerimeter;
    double mostPopularArea;
    long mostPopularPerimeter;
    statisticsDto stats;

    public statisticsService() {
        stats = new statisticsDto();
    }

    public void increaseTotalAmount() {
        totalAmount++;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public statisticsDto getStats() {
        return stats;
    }

    public void setStats() {
        stats.setTotalAmount(totalAmount);
        stats.setMaxArea(maxArea);
        stats.setMaxPerimeter(maxPerimeter);
        stats.setMinArea(minArea);
        stats.setMinPerimeter(minPerimeter);
        stats.setMostPopularArea(mostPopularArea);
        stats.setMostPopularPerimeter(mostPopularPerimeter);
    }

    public void calcTotalAmount(ArrayList<Triangle> triangles) {
        triangles.stream()
                .parallel()
                .forEach(triangle -> {
                    increaseTotalAmount();
                });
    }

    void findMaxAndMinArea(ArrayList<CalculationResultsDto> results) {
        double maxValue = results.get(0).getArea();
        double minValue = results.get(0).getArea();
        for(int i=1;i < results.size();i++){
            if(results.get(i).getArea() > maxValue){
                maxValue = results.get(i).getArea();
            }
            if(results.get(i).getArea() < minValue){
                    minValue = results.get(i).getArea();
                }

        }
        maxArea = maxValue;
        minArea = minValue;
    }

    void findMaxAndMinPerimeter(ArrayList<CalculationResultsDto> results) {
        long maxValue = results.get(0).getPerimeter();
        long minValue = results.get(0).getPerimeter();
        for(int i=1;i < results.size();i++){
            if(results.get(i).getPerimeter() > maxValue){
                maxValue = results.get(i).getPerimeter();
            }
            if(results.get(i).getPerimeter() < minValue){
                    minValue = results.get(i).getPerimeter();
            }

        }
        maxPerimeter = maxValue;
        minPerimeter = minValue;
    }

    void findMostPopularValue(ArrayList<CalculationResultsDto> results) {
        double previousArea = results.get(0).getArea();
        double popularArea = results.get(0).getArea();
        long previousPerimeter = results.get(0).getPerimeter();
        long popularPerimeter = results.get(0).getPerimeter();
        int countArea = 1;
        int maxCountArea = 1;
        int countPerimeter = 1;
        int maxCountPerimeter = 1;

        for (int i = 1; i < results.size(); i++) {
            if (results.get(i).getArea() == previousArea)
                countArea++;
            else {
                if (countArea > maxCountArea) {
                    popularArea = results.get(i-1).getArea();
                    maxCountArea = countArea;
                }
                previousArea = results.get(i).getArea();
                countArea = 1;
            }
            if (results.get(i).getPerimeter() == previousPerimeter)
                countPerimeter++;
            else {
                if (countPerimeter > maxCountPerimeter) {
                    popularPerimeter = results.get(i-1).getPerimeter();
                    maxCountPerimeter = countPerimeter;
                }
                previousPerimeter = results.get(i).getPerimeter();
                countPerimeter = 1;
            }
        }

        mostPopularArea = countArea > maxCountArea ? results.get(results.size()-1).getArea() : popularArea;
        mostPopularPerimeter = countPerimeter > maxCountPerimeter ? results.get(results.size()-1).getPerimeter() : popularPerimeter;
    }

    public void makeStats(ArrayList<Triangle> triangles, ArrayList<CalculationResultsDto> results) {
        calcTotalAmount(triangles);
        findMaxAndMinArea(results);
        findMaxAndMinPerimeter(results);
        findMostPopularValue(results);
        setStats();
    }
}
