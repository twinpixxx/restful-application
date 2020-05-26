package com.epam.triangful.dto;

import java.util.ArrayList;

public class CalculationResultsListDto {

    private ArrayList<CalculationResultsDto> resultsList;

    public CalculationResultsListDto() {
        resultsList = new ArrayList<>();
    }

    public void add(double _area, long _perimeter) {
        CalculationResultsDto results = new CalculationResultsDto();
        results.setArea(_area);
        results.setPerimeter(_perimeter);

        resultsList.add(results);
    }
    public void addFromResults(CalculationResultsDto _results) {
        resultsList.add(_results);
    }

    public ArrayList<CalculationResultsDto> getResultsList() {
        return resultsList;
    }
}
