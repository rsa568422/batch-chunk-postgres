package com.example.batch.application.chunk;

import com.example.batch.application.Data;
import com.example.batch.application.service.DatoEntradaBatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReaderTest {

    @InjectMocks
    private Reader reader;

    @Mock
    private DatoEntradaBatchService service;

    @Test
    void read() {
        // given
        when(service.findAll()).thenReturn(Data.DATOS_ENTRADA);

        reader.findAll();

        // when
        var actual = reader.read();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ENTRADA_1, actual)
        );

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }

    @Test
    void readEmpty() {
        // given
        when(service.findAll()).thenReturn(List.of());

        reader.findAll();

        // when
        var actual = reader.read();

        // then
        assertNull(actual);

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }
}