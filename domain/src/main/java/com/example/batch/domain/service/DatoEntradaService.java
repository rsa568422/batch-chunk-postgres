package com.example.batch.domain.service;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.repository.DatoEntradaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class DatoEntradaService {

    private final DatoEntradaRepository repository;

    public List<DatoEntrada> findAll() {
        return repository.findAll();
    }

    public void saveAll(List<DatoEntrada> entradas) {
        repository.saveAll(entradas);
    }
}
