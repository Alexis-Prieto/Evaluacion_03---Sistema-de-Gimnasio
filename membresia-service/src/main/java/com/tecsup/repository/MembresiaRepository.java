package com.tecsup.repository;

import com.tecsup.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
    List<Membresia> findByIdSocio(Long idSocio);
}
