package com.example.batch.application.service;

import com.example.batch.application.Data;
import com.example.batch.domain.repository.DatoEntradaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatoEntradaServiceTest {

    @InjectMocks
    private DatoEntradaBatchService service;

    @Mock
    private DatoEntradaRepository repository;

    @Test
    void findAll() {
        // given
        when(repository.findAll()).thenReturn(Data.DATOS_ENTRADA);

        // when
        var actual = service.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(Data.DATOS_ENTRADA, actual)
        );

        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }
}