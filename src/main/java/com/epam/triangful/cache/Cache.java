package com.epam.triangful.cache;

import com.epam.triangful.dto.CalculationResultsDto;
import com.epam.triangful.dto.TriangleDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document
public class Cache {

    @Id
    private String id;

    @Field("Triangle")
    private TriangleDto triangle;

    @Field("Result")
    private CalculationResultsDto results;


    public Cache() {
        triangle = new TriangleDto();
        results = new CalculationResultsDto();
    }

     public Cache(TriangleDto triangle, CalculationResultsDto results, String id) {
        this.triangle = triangle;
        this.results = results;
        this.id = id;
    }

    public TriangleDto getTriangle() {
        return triangle;
    }

    public void setTriangle(TriangleDto triangle) {
        this.triangle = triangle;
    }

    public CalculationResultsDto getResults() {
        return results;
    }

    public void setResults(CalculationResultsDto results) {
        this.results = results;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
