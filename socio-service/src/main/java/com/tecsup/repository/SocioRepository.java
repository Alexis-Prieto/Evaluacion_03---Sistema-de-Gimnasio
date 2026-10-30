package com.tecsup.repository;

import com.tecsup.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
    boolean existsByDni(String dni);
}
