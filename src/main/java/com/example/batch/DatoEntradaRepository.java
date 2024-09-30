package com.example.batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DatoEntradaRepository extends JpaRepository<DatoEntrada, UUID> {
}
