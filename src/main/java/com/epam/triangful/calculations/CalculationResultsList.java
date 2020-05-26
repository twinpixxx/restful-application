package com.epam.triangful.calculations;

import java.util.ArrayList;

public class CalculationResultsList {

    private ArrayList<CalculationResults> resultsList;

    public CalculationResultsList() {
        resultsList = new ArrayList<>();
    }

    public void add(double _area, long _perimeter) {
        CalculationResults results = new CalculationResults();
        results.setArea(_area);
        results.setPerimeter(_perimeter);

        resultsList.add(results);
    }
    public void addFromResults(CalculationResults _results) {
        resultsList.add(_results);
    }

    public ArrayList<CalculationResults> getResultsList() {
        return resultsList;
    }
}
