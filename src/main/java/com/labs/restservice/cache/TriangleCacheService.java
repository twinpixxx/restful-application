package com.labs.restservice.cache;

import com.labs.restservice.calculations.CalculationResults;
import com.labs.restservice.triangle.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("TriangleCacheService")
public class TriangleCacheService {
    private static final Logger log = LoggerFactory.getLogger(TriangleCacheService.class);
    private HashMap<Triangle, CalculationResults> triangleCalculationCache = new HashMap<>();

    public TriangleCacheService() {}

    public void add(Triangle _params, CalculationResults _results) {
        triangleCalculationCache.put(_params, _results);
    }

    public boolean contains(Triangle _params) {
        return triangleCalculationCache.containsKey(_params);
    }

    public CalculationResults getResults(Triangle _params) {
        return triangleCalculationCache.get(_params);
    }
}
