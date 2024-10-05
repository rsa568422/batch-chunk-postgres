package com.example.batch.domain.service;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.domain.repository.DatoSalidaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DatoSalidaService {

    private final DatoSalidaRepository repository;

    public void saveAll(List<DatoSalida> salidas) {
        repository.saveAll(salidas);
    }
}
