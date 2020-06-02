package com.epam.triangful.persistence;

import com.epam.triangful.cache.Cache;
import com.epam.triangful.cache.TriangleCacheService;
import com.epam.triangful.dto.CalculationResultsDto;
import com.epam.triangful.dto.TriangleDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CacheRepository extends MongoRepository<Cache, String> {

    List<Cache> findByTriangle(TriangleDto triangle);

}
