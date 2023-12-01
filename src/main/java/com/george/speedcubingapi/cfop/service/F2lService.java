package com.george.speedcubingapi.cfop.service;

import com.george.speedcubingapi.cfop.entity.F2lModel;

import com.george.speedcubingapi.cfop.repository.F2lRepository;
import com.george.speedcubingapi.cfop.repository.impl.CustomF2lRepositoryImpl;
import com.george.speedcubingapi.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class F2lService {

    private final F2lRepository f2lRepository;
    private final CustomF2lRepositoryImpl customF2lRepository;

    @Autowired
    public F2lService(F2lRepository f2lRepository, CustomF2lRepositoryImpl customF2lRepository) {
        this.f2lRepository = f2lRepository;
        this.customF2lRepository = customF2lRepository;
    }

    public List<F2lModel> getAll() {
        return f2lRepository.findAll();
    }

    public F2lModel getByName(String name) {
        return f2lRepository.findByAlgorithmName(name);
    }

    public List<String> getAllSubsets() {
        return customF2lRepository.findAllAlgorithmSubsets();
    }

    public List<F2lModel> getAllCasesBySubset(String subset) {
        return f2lRepository.findAllByAlgorithmSubsetIgnoreCase(subset)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Subset not found"));
    }
}
