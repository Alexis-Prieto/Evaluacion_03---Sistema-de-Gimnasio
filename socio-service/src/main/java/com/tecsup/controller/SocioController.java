package com.tecsup.controller;

import com.tecsup.dto.SocioRequest;
import com.tecsup.dto.SocioResponse;
import com.tecsup.service.SocioService;
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
@RequestMapping("/api/socios")
public class SocioController {
    private final SocioService service;

    public SocioController(SocioService service) {
        this.service = service;
    }

    @GetMapping
    public List<SocioResponse> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public SocioResponse findById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<SocioResponse> create(@Valid @RequestBody SocioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public SocioResponse update(@PathVariable Long id, @Valid @RequestBody SocioRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
