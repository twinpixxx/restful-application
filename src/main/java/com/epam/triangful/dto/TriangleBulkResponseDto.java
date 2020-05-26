package com.epam.triangful.dto;

public class TriangleBulkResponseDto {
    private CalculationResultsListDto results;

    public TriangleBulkResponseDto() {
        results = new CalculationResultsListDto();
    }

    public void setResults(CalculationResultsListDto _resultsList) {
        results = _resultsList;
    }

    public CalculationResultsListDto getResults() {
        return results;
    }
}
