package com.george.speedcubingapi.cfop.service;

import com.george.speedcubingapi.cfop.entity.F2lModel;
import static com.george.speedcubingapi.cfop.entity.F2lModel.F2lAlgorithmCase;
import com.george.speedcubingapi.cfop.repository.F2lRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class F2lService {

    private final F2lRepository f2lRepository;

    @Autowired
    public F2lService(F2lRepository f2lRepository) {
        this.f2lRepository = f2lRepository;
    }

    public List<F2lModel> getAll() {
        return f2lRepository.findAll();
    }

    public List<String> getAllSubsets() {
        return f2lRepository.findAllSubsets();
    }

    public F2lModel getByName(String name) {
        return f2lRepository.findByName(name.toUpperCase());
    }

    public List<F2lAlgorithmCase> getAllCasesBySubset(String subset) {
        if (!isSubsetValid(subset)) throw new RuntimeException("Invalid subset");

        return f2lRepository.findAllCasesBySubset(subset);
    }

    /**
     * Checks if a given subset is valid.
     *
     * @param subset the subset to check for validity
     * @return true if the subset is found in the list of all subsets; false otherwise
     */
    private boolean isSubsetValid(String subset) {
        List<String> subsets = f2lRepository.findAllSubsets();
        return subsets.contains(subset);
    }
}
