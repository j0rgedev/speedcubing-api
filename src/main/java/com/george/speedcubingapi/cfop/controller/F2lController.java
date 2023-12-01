package com.george.speedcubingapi.cfop.controller;

import com.george.speedcubingapi.cfop.entity.F2lModel;
import com.george.speedcubingapi.cfop.service.F2lService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cfop/f2l")
public class F2lController {

    private final F2lService f2lService;

    @Autowired
    public F2lController(F2lService f2lService) {
        this.f2lService = f2lService;
    }

    @GetMapping
    public ResponseEntity<List<F2lModel>> getAll() {
        return ResponseEntity.ok(f2lService.getAll());
    }

    @GetMapping("/{algorithmName}")
    public ResponseEntity<F2lModel> getByName(
            @PathVariable @NotNull @NotBlank String algorithmName
    ) {
        return ResponseEntity.ok(f2lService.getByName(algorithmName));
    }

    @GetMapping("/subsets")
    public ResponseEntity<List<String>> getAllSubsets() {
        return ResponseEntity.ok(f2lService.getAllSubsets());
    }

    @GetMapping("/subsets/{subset}")
    public ResponseEntity<List<F2lModel>> getAllCasesBySubset(
            @PathVariable @NotNull @NotBlank String subset
    ) {
        return ResponseEntity.ok(f2lService.getAllCasesBySubset(subset));
    }
}
