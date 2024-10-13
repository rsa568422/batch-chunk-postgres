package com.example.batch.domain.repository;

import com.example.batch.domain.model.DatoEntrada;

import java.util.List;

public interface DatoEntradaRepository {

    List<DatoEntrada> findAll();

    void saveAll(List<DatoEntrada> entradas);
}
