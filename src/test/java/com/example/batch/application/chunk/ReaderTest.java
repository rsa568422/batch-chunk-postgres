package com.example.batch.application.chunk;

import com.example.batch.Data;
import com.example.batch.application.service.DatoEntradaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ReaderTest {

    @Test
    void read() {
        // given
        var service = Mockito.mock(DatoEntradaService.class);
        when(service.findAll()).thenReturn(Data.DATO_ENTRADA_ENTITIES);
        var reader = new Reader(service);

        // when
        var actual = reader.read();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ENTRADA_ENTITY_1, actual)
        );

        verify(service, times(1)).findAll();
        verifyNoMoreInteractions(service);
    }
}