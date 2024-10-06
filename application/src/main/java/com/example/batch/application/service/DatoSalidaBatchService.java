package com.example.batch.application.service;

import com.example.batch.domain.repository.DatoSalidaRepository;
import com.example.batch.domain.service.DatoSalidaService;
import org.springframework.stereotype.Service;

@Service
public class DatoSalidaBatchService extends DatoSalidaService {

    public DatoSalidaBatchService(DatoSalidaRepository repository) {
        super(repository);
    }
}
