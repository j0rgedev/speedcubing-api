package com.george.speedcubingapi.cfop.repository.impl;

import com.george.speedcubingapi.cfop.entity.F2lModel;
import com.george.speedcubingapi.cfop.repository.CustomF2lRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomF2lRepositoryImpl implements CustomF2lRepository {

    private final MongoTemplate mongoTemplate;

    public CustomF2lRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<String> findAllAlgorithmSubsets() {
        return mongoTemplate.query(F2lModel.class)
                .distinct("algorithmSubset")
                .as(String.class)
                .all();
    }

}
