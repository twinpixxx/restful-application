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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
