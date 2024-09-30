package com.example.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatoSalidaService {

    private final DatoSalidaRepository repository;

    public void save(List<? extends DatoSalida> items) {
        repository.saveAll(items);
    }
}
