package com.example.batch.domain.service;

import com.example.batch.domain.Data;
import com.example.batch.domain.repository.DatoSalidaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatoSalidaServiceTest {

    @InjectMocks
    private TestDatoSalidaService datoSalidaService;

    @Mock
    private DatoSalidaRepository datoSalidaRepository;

    @Test
    void findAll() {
        // given
        var salidas = List.of(Data.SALIDA);

        when(datoSalidaRepository.findAll()).thenReturn(salidas);

        // when
        var actual = datoSalidaService.findAll();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(salidas, actual)
        );

        verify(datoSalidaRepository, times(1)).findAll();
        verifyNoMoreInteractions(datoSalidaRepository);
    }

    @Test
    void saveAll() {
        // given
        var salidas = List.of(Data.SALIDA);

        // when
        assertDoesNotThrow(() -> datoSalidaService.saveAll(salidas));

        // then
        verify(datoSalidaRepository, times(1)).saveAll(salidas);
        verifyNoMoreInteractions(datoSalidaRepository);
    }

    private static class TestDatoSalidaService extends DatoSalidaService {
        public TestDatoSalidaService(DatoSalidaRepository repository) {
            super(repository);
        }
    }
}