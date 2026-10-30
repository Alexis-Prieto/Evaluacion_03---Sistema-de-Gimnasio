package com.tecsup.service;

import com.tecsup.dto.SocioRequest;
import com.tecsup.dto.SocioResponse;
import com.tecsup.entity.Socio;
import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.repository.SocioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SocioService {
    private final SocioRepository repository;

    public SocioService(SocioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<SocioResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public SocioResponse findById(Long id) {
        return toResponse(findEntity(id));
    }

    public SocioResponse create(SocioRequest request) {
        Socio socio = new Socio();
        apply(socio, request);
        return toResponse(repository.save(socio));
    }

    public SocioResponse update(Long id, SocioRequest request) {
        Socio socio = findEntity(id);
        apply(socio, request);
        return toResponse(repository.save(socio));
    }

    public void delete(Long id) {
        repository.delete(findEntity(id));
    }

    private Socio findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el socio con id " + id));
    }

    private void apply(Socio socio, SocioRequest request) {
        socio.setDni(request.dni());
        socio.setNombres(request.nombres());
        socio.setApellidos(request.apellidos());
        socio.setTelefono(request.telefono());
        socio.setCorreo(request.correo());
        socio.setEstado(request.estado() == null || request.estado().isBlank() ? "A" : request.estado());
    }

    private SocioResponse toResponse(Socio socio) {
        return new SocioResponse(socio.getIdSocio(), socio.getDni(), socio.getNombres(), socio.getApellidos(),
                socio.getTelefono(), socio.getCorreo(), socio.getEstado());
    }
}
