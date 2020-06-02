package com.epam.triangful.persistence;

import com.epam.triangful.dto.TriangleBulkResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BulkService")
public class BulkService {

    @Autowired
    private BulkResultsRepository repository;

    private static final Logger log = LoggerFactory.getLogger(BulkService.class);
    private TriangleBulkResponseDto results = new TriangleBulkResponseDto();

    public BulkService(TriangleBulkResponseDto results) {
        this.results = results;
    }
    public BulkService() {}

    public void keep(TriangleBulkResponseDto results) {
        log.info("Save results of bulk operation into database");

        repository.insert(results);
    }

    public TriangleBulkResponseDto getResults(String uuid) {
        log.info("Getting results of bulk operation from database");

        return repository.findById(uuid).get();
    }

}
