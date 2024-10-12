package com.example.batch.infrastructure.repository.salida;

import com.example.batch.infrastructure.entity.salida.DatoSalidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional("salidaTransactionManager")
public interface DatoSalidaJpaRepository extends JpaRepository<DatoSalidaEntity, UUID> {
}
