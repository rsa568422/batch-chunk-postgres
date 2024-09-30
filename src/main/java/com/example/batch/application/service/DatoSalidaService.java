package com.example.batch.application.service;

import com.example.batch.infrastructure.entity.DatoSalidaEntity;
import com.example.batch.infrastructure.repository.DatoSalidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatoSalidaService {

    private final DatoSalidaRepository repository;

    public void save(List<? extends DatoSalidaEntity> items) {
        repository.saveAll(items);
    }
}
