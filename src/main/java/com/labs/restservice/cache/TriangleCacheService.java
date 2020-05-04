package com.labs.restservice.cache;

import com.labs.restservice.calculations.CalculationResults;
import com.labs.restservice.triangle.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service("TriangleCacheService")
public class TriangleCacheService {
    private static final Logger log = LoggerFactory.getLogger(TriangleCacheService.class);
    private ConcurrentHashMap<Triangle, CalculationResults> triangleCalculationCache;

    public TriangleCacheService() {
        triangleCalculationCache = new ConcurrentHashMap<>();
    }

    public void add(Triangle _params, CalculationResults _results) {
        log.info("Adding new values to cache");
        triangleCalculationCache.put(_params, _results);
    }

    public boolean contains(Triangle _params) {
        log.info("Check if contains in cache");
        return triangleCalculationCache.containsKey(_params);
    }

    public CalculationResults getResults(Triangle _params) {
        log.info("Getting results from cache");
        return triangleCalculationCache.get(_params);
    }
}
