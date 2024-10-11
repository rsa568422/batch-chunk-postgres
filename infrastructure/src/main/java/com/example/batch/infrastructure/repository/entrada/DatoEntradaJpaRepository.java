package com.example.batch.infrastructure.repository.entrada;

import com.example.batch.infrastructure.entity.entrada.DatoEntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatoEntradaJpaRepository extends JpaRepository<DatoEntradaEntity, UUID> {
}
