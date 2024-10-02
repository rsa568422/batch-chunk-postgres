package com.example.batch.application.service;

import com.example.batch.Data;
import com.example.batch.infrastructure.repository.DatoSalidaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DatoSalidaServiceTest {

    @InjectMocks
    private DatoSalidaService service;

    @Mock
    private DatoSalidaRepository repository;

    @Test
    void save() {
        // when
        assertDoesNotThrow(() -> service.save(Data.DATO_SALIDA_ENTITIES));

        // then
        verify(repository, times(1)).saveAll(Data.DATO_SALIDA_ENTITIES);
    }
}