package com.tecsup.controller;

import com.tecsup.dto.MembresiaRequest;
import com.tecsup.dto.MembresiaResponse;
import com.tecsup.service.MembresiaService;
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
@RequestMapping("/api/membresias")
public class MembresiaController {
    private final MembresiaService service;

    public MembresiaController(MembresiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<MembresiaResponse> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public MembresiaResponse findById(@PathVariable Long id) { return service.findById(id); }

    @GetMapping("/socio/{idSocio}")
    public List<MembresiaResponse> findBySocio(@PathVariable Long idSocio) {
        return service.findBySocio(idSocio);
    }

    @PostMapping
    public ResponseEntity<MembresiaResponse> create(@Valid @RequestBody MembresiaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public MembresiaResponse update(@PathVariable Long id, @Valid @RequestBody MembresiaRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
