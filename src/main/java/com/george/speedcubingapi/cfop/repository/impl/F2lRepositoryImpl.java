package com.george.speedcubingapi.cfop.repository.impl;

import static com.george.speedcubingapi.cfop.entity.F2lModel.F2lAlgorithmCase;

import com.george.speedcubingapi.cfop.entity.F2lModel;
import com.george.speedcubingapi.cfop.repository.F2lRepository;
import com.george.speedcubingapi.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class F2lRepositoryImpl implements F2lRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public F2lRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Returns a list of all F2lModel objects from the database.
     *
     * @return A List of F2lModel objects.
     */
    @Override
    public List<F2lModel> findAll() {
        return mongoTemplate.findAll(F2lModel.class);
    }

    /**
     * Gets the distinct algorithm subsets from the CFOP F2L collection in MongoDB.
     *
     * @return A list of Strings representing the distinct algorithm subsets
     */
    @Override
    public List<String> findAllSubsets() {
        // Mongo query: db.getCollection('cfop_f2l').distinct('algorithmSubset')
        return mongoTemplate.query(F2lModel.class)
                .distinct("algorithmSubset")
                .as(String.class)
                .all();
    }

    /**
     * Gets all algorithm cases from the CFOP F2L collection in MongoDB that belong to a specific algorithm subset.
     *
     * @param subset The algorithm subset for which to retrieve the cases
     * @return A list of F2lModel.AlgorithmCase objects representing the algorithm cases that belong to the specified subset
     */
    @Override
    public List<F2lAlgorithmCase> findAllCasesBySubset(String subset) {
        // Mongo query: db.getCollection('cfop_f2l').find({algorithmSubset: ${subset}})
        Criteria criteria = Criteria.where("algorithmSubset").is(subset);
        return mongoTemplate.query(F2lAlgorithmCase.class)
                .matching(criteria)
                .all();
    }

    /**
     * Retrieves an F2lModel object from the CFOP F2L collection in MongoDB based on the specified name.
     *
     * @param name The name of the F2lModel to retrieve
     * @return The F2lModel object with the specified name
     * @throws RuntimeException if no F2lModel object with the specified name is found
     */
    @Override
    public F2lModel findByName(String name) {
        // Mongo query: db.getCollection('cfop_f2l').findOne({algorithmName: ${name}})
        Criteria criteria = Criteria.where("algorithmName").is(name);
        return mongoTemplate.query(F2lModel.class)
                .matching(criteria)
                .first()
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "No F2L algorithm found with name " + name));
    }
}
