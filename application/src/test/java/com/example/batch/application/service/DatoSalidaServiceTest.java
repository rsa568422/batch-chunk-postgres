package com.example.batch.application.service;

import com.example.batch.application.Data;
import com.example.batch.domain.repository.DatoSalidaRepository;
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
    private DatoSalidaBatchService service;

    @Mock
    private DatoSalidaRepository repository;

    @Test
    void save() {
        // when
        assertDoesNotThrow(() -> service.saveAll(Data.DATOS_SALIDA));

        // then
        verify(repository, times(1)).saveAll(Data.DATOS_SALIDA);
    }
}