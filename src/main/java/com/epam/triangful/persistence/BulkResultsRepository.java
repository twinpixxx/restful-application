package com.epam.triangful.persistence;

import com.epam.triangful.dto.TriangleBulkResponseDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulkResultsRepository extends MongoRepository<TriangleBulkResponseDto, String> {

}
