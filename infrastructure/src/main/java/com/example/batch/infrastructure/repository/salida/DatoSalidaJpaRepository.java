package com.example.batch.infrastructure.repository.salida;

import com.example.batch.infrastructure.entity.salida.DatoSalidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatoSalidaJpaRepository extends JpaRepository<DatoSalidaEntity, UUID> {
}
