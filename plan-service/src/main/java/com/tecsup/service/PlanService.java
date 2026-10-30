package com.tecsup.service;

import com.tecsup.dto.PlanRequest;
import com.tecsup.dto.PlanResponse;
import com.tecsup.entity.Plan;
import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.repository.PlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanService {
    private final PlanRepository repository;

    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<PlanResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public PlanResponse findById(Long id) {
        return toResponse(findEntity(id));
    }

    public PlanResponse create(PlanRequest request) {
        Plan plan = new Plan();
        apply(plan, request);
        return toResponse(repository.save(plan));
    }

    public PlanResponse update(Long id, PlanRequest request) {
        Plan plan = findEntity(id);
        apply(plan, request);
        return toResponse(repository.save(plan));
    }

    public void delete(Long id) {
        repository.delete(findEntity(id));
    }

    private Plan findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el plan con id " + id));
    }

    private void apply(Plan plan, PlanRequest request) {
        plan.setNombre(request.nombre());
        plan.setPrecio(request.precio());
        plan.setDuracionMeses(request.duracionMeses());
        plan.setEstado(request.estado() == null || request.estado().isBlank() ? "A" : request.estado());
    }

    private PlanResponse toResponse(Plan plan) {
        return new PlanResponse(plan.getIdPlan(), plan.getNombre(), plan.getPrecio(),
                plan.getDuracionMeses(), plan.getEstado());
    }
}
