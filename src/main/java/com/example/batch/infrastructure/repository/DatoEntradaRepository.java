package com.example.batch.infrastructure.repository;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatoEntradaRepository extends JpaRepository<DatoEntradaEntity, UUID> {
}
