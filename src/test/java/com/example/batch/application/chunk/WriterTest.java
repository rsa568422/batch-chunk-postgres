package com.example.batch.application.chunk;

import com.example.batch.Data;
import com.example.batch.application.service.DatoSalidaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.batch.item.Chunk;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class WriterTest {

    @Test
    void write() {
        // given
        var chunk = Chunk.of(Data.SALIDA_ENTITY_1, Data.SALIDA_ENTITY_2, Data.SALIDA_ENTITY_3);
        var entities = chunk.getItems();
        var service = Mockito.mock(DatoSalidaService.class);
        var writer = new Writer(service);

        // when
        assertDoesNotThrow(() -> writer.write(chunk));

        // then
        verify(service, times(1)).save(entities);
        verifyNoMoreInteractions(service);
    }
}