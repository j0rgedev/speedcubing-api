package com.george.speedcubingapi.cfop.repository;

import com.george.speedcubingapi.cfop.entity.F2lModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public interface F2lRepository extends MongoRepository<F2lModel, String>, CustomF2lRepository {

    Optional<List<F2lModel>> findAllByAlgorithmSubsetIgnoreCase(String subset);
    F2lModel findByAlgorithmName(String name);

}
