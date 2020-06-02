package com.epam.triangful.cache;

import com.epam.triangful.dto.CalculationResultsDto;
import com.epam.triangful.persistence.CacheRepository;
import com.epam.triangful.dto.TriangleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service("TriangleCacheService")
public class TriangleCacheService {

    @Autowired
    private CacheRepository repository;

    private static final Logger log = LoggerFactory.getLogger(TriangleCacheService.class);
    private List<Cache> cacheList;

    public TriangleCacheService() {
         cacheList = new ArrayList<>();
    }

    public void add(TriangleDto _params, CalculationResultsDto _results) {
        log.info("Adding new values to cache");
        Cache tempCache = new Cache(_params, _results, UUID.randomUUID().toString());
        cacheList.add(tempCache);
        repository.insert(tempCache);
    }

    public void add(TriangleDto _params, double _area, long _perimeter) {
        log.info("Adding new values to cache");
        CalculationResultsDto results = new CalculationResultsDto();
        results.setArea(_area);
        results.setPerimeter(_perimeter);
        Cache tempCache = new Cache(_params, results, UUID.randomUUID().toString());
        cacheList.add(tempCache);
        repository.insert(tempCache);

    }

    public boolean contains(TriangleDto _params) {
        log.info("Check if contains in cache");
        return repository.findByTriangle(_params).size() != 0;
    }

    public CalculationResultsDto getResults(TriangleDto _params) {
        log.info("Getting results from cache");
        return repository.findByTriangle(_params).get(0).getResults();
    }

    public int getCacheSize() {
		log.info("Getting size of cache");
		return cacheList.size();
	}

	public void clearCache() {
        log.info("Clearing cache");
        cacheList.clear();
    }
    public List<Cache> getCacheList() {
        return repository.findAll();
    }
}
