package com.george.speedcubingapi.cfop.repository;

import com.george.speedcubingapi.cfop.entity.F2lModel;

import java.util.List;

public interface F2lRepository {
    List<F2lModel> findAll();
    List<String> findAllSubsets();
    List<F2lModel.AlgorithmCase> findAllCasesBySubset(String subset);
    F2lModel findByName(String name);
}
