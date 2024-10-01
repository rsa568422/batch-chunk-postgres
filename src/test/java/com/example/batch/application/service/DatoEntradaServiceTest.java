package com.example.batch.application.service;

import com.example.batch.application.Data;
import com.example.batch.infrastructure.repository.DatoEntradaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatoEntradaServiceTest {

    @InjectMocks
    private DatoEntradaService service;

    @Mock
    private DatoEntradaRepository repository;

    @Test
    void findAll() {
        // given
        when(repository.findAll()).thenReturn(Data.DATO_ENTRADA_ENTITIES);

        // when
        var actual = service.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(Data.DATO_ENTRADA_ENTITIES, actual)
        );
    }
}