package com.example.batch.application.chunk;

import com.example.batch.application.Data;
import com.example.batch.application.service.DatoEntradaBatchService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ReaderTest {

    @Test
    void read() {
        // given
        var service = Mockito.mock(DatoEntradaBatchService.class);
        when(service.findAll()).thenReturn(Data.DATOS_ENTRADA);
        var reader = new Reader(service);

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
    void readNull() {
        // given
        var service = Mockito.mock(DatoEntradaBatchService.class);
        when(service.findAll()).thenReturn(List.of());
        var reader = new Reader(service);

        // when
        var actual = reader.read();

        // then
        assertAll(
                () -> assertNull(actual)
        );

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }
}