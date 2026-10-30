package com.tecsup.service;

import com.tecsup.dto.MembresiaRequest;
import com.tecsup.dto.MembresiaResponse;
import com.tecsup.entity.Membresia;
import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.repository.MembresiaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MembresiaService {
    private final MembresiaRepository repository;

    public MembresiaService(MembresiaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<MembresiaResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public MembresiaResponse findById(Long id) {
        return toResponse(findEntity(id));
    }

    @Transactional(readOnly = true)
    public List<MembresiaResponse> findBySocio(Long idSocio) {
        return repository.findByIdSocio(idSocio).stream().map(this::toResponse).toList();
    }

    public MembresiaResponse create(MembresiaRequest request) {
        Membresia membresia = new Membresia();
        apply(membresia, request);
        return toResponse(repository.save(membresia));
    }

    public MembresiaResponse update(Long id, MembresiaRequest request) {
        Membresia membresia = findEntity(id);
        apply(membresia, request);
        return toResponse(repository.save(membresia));
    }

    public void delete(Long id) {
        repository.delete(findEntity(id));
    }

    private Membresia findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la membresía con id " + id));
    }

    private void apply(Membresia membresia, MembresiaRequest request) {
        membresia.setIdSocio(request.idSocio());
        membresia.setIdPlan(request.idPlan());
        membresia.setFechaInicio(request.fechaInicio());
        membresia.setFechaFin(request.fechaFin());
        membresia.setEstado(request.estado() == null || request.estado().isBlank() ? "A" : request.estado());
    }

    private MembresiaResponse toResponse(Membresia membresia) {
        return new MembresiaResponse(membresia.getIdMembresia(), membresia.getIdSocio(), membresia.getIdPlan(),
                membresia.getFechaInicio(), membresia.getFechaFin(), membresia.getEstado());
    }
}
