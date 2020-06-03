package com.epam.triangful.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("bulk-results")
public class TriangleBulkResponseDto {

    @Id
    private String id;

    @Field("Results")
    private CalculationResultsListDto results;

    @Field("Statistics")
    private StatisticsDto statistics;

    public TriangleBulkResponseDto() {
        results = new CalculationResultsListDto();
        statistics = new StatisticsDto();
    }

    public void setResults(CalculationResultsListDto _resultsList) {
        results = _resultsList;
    }

    public CalculationResultsListDto getResults() {
        return results;
    }

    public StatisticsDto getStats() {
        return statistics;
    }

    public void setStats(StatisticsDto stats) {
        this.statistics = stats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
