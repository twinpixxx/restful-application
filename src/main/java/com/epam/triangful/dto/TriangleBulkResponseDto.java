package com.epam.triangful.dto;

public class TriangleBulkResponseDto {
    private CalculationResultsList results;

    public TriangleBulkResponseDto() {
        results = new CalculationResultsList();
    }

    public void setResults(CalculationResultsList _resultsList) {
        results = _resultsList;
    }

    public CalculationResultsList getResults() {
        return results;
    }
}
