package com.example.batch.application.service;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import com.example.batch.infrastructure.repository.DatoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatoEntradaService {

    private final DatoEntradaRepository repository;

    public List<DatoEntradaEntity> findAll() {
        return repository.findAll();
    }
}
