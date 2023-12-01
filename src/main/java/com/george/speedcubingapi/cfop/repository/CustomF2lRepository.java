package com.george.speedcubingapi.cfop.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomF2lRepository {
    List<String> findAllAlgorithmSubsets();
}
