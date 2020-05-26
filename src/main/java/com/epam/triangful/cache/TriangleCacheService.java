package com.epam.triangful.cache;

import com.epam.triangful.calculations.CalculationResults;
import com.epam.triangful.triangle.Triangle;
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

    public void add(Triangle _params, double _area, long _perimeter) {
        log.info("Adding new values to cache");
        CalculationResults results = new CalculationResults();
        results.setArea(_area);
        results.setPerimeter(_perimeter);
        triangleCalculationCache.put(_params, results);
    }

    public boolean contains(Triangle _params) {
        log.info("Check if contains in cache");
        return triangleCalculationCache.containsKey(_params);
    }

    public CalculationResults getResults(Triangle _params) {
        log.info("Getting results from cache");
        return triangleCalculationCache.get(_params);
    }

    public int getCacheSize() {
		log.info("Getting size of cache");
		return triangleCalculationCache.size();
	}

	public void clearCache() {
        log.info("Clearing cache");
        triangleCalculationCache.clear();
    }

    public ConcurrentHashMap<Triangle, CalculationResults> getCache() {
        return triangleCalculationCache;
    }
}
