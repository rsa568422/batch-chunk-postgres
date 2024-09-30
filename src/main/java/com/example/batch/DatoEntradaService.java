package com.example.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatoEntradaService {

    private final DatoEntradaRepository repository;

    public List<DatoEntrada> findAll() {
        return repository.findAll();
    }
}
