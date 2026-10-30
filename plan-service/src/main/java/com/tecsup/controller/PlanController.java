package com.tecsup.controller;

import com.tecsup.dto.PlanRequest;
import com.tecsup.dto.PlanResponse;
import com.tecsup.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanController {
    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlanResponse> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public PlanResponse findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<PlanResponse> create(@Valid @RequestBody PlanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public PlanResponse update(@PathVariable Long id, @Valid @RequestBody PlanRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
