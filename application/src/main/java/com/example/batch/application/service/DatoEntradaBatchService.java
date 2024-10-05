package com.example.batch.application.service;

import com.example.batch.domain.repository.DatoEntradaRepository;
import com.example.batch.domain.service.DatoEntradaService;
import org.springframework.stereotype.Service;

@Service
public class DatoEntradaBatchService extends DatoEntradaService {

    public DatoEntradaBatchService(DatoEntradaRepository repository) {
        super(repository);
    }
}
