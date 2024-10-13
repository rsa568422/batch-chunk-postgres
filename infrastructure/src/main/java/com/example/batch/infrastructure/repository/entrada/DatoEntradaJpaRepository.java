package com.example.batch.infrastructure.repository.entrada;

import com.example.batch.infrastructure.entity.entrada.DatoEntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional("entradaTransactionManager")
public interface DatoEntradaJpaRepository extends JpaRepository<DatoEntradaEntity, UUID> {
}
