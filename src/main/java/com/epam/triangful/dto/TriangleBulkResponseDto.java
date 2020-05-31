package com.epam.triangful.dto;

public class TriangleBulkResponseDto {
    private CalculationResultsListDto results;
    private statisticsDto statistics;

    public TriangleBulkResponseDto() {
        results = new CalculationResultsListDto();
        statistics = new statisticsDto();
    }

    public void setResults(CalculationResultsListDto _resultsList) {
        results = _resultsList;
    }

    public CalculationResultsListDto getResults() {
        return results;
    }

    public statisticsDto getStats() {
        return statistics;
    }

    public void setStats(statisticsDto stats) {
        this.statistics = stats;
    }
}
