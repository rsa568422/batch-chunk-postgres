package com.example.batch.domain.service;

import com.example.batch.domain.Data;
import com.example.batch.domain.repository.DatoEntradaRepository;
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
class DatoEntradaServiceTest {

    @InjectMocks
    private TestDatoEntradaService datoEntradaService;

    @Mock
    private DatoEntradaRepository datoEntradaRepository;

    @Test
    void findAll() {
        // given
        var entradas = List.of(Data.ENTRADA);

        when(datoEntradaRepository.findAll()).thenReturn(entradas);

        // when
        var actual = datoEntradaService.findAll();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(entradas, actual)
        );

        verify(datoEntradaRepository, times(1)).findAll();
        verifyNoMoreInteractions(datoEntradaRepository);
    }

    @Test
    void saveAll() {
        // given
        var entradas = List.of(Data.ENTRADA);

        // when
        assertDoesNotThrow(() -> datoEntradaService.saveAll(entradas));

        // then
        verify(datoEntradaRepository, times(1)).saveAll(entradas);
        verifyNoMoreInteractions(datoEntradaRepository);
    }

    private static class TestDatoEntradaService extends DatoEntradaService {
        public TestDatoEntradaService(DatoEntradaRepository repository) {
            super(repository);
        }
    }
}