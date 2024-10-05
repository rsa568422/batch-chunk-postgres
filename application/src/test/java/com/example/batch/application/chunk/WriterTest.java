package com.example.batch.application.chunk;

import com.example.batch.application.Data;
import com.example.batch.application.service.DatoSalidaBatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.item.Chunk;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WriterTest {

    @InjectMocks
    private Writer writer;

    @Mock
    private DatoSalidaBatchService service;

    @Test
    void write() {
        // given
        var chunk = Chunk.of(Data.SALIDA_1, Data.SALIDA_2, Data.SALIDA_3);

        // when
        assertDoesNotThrow(() -> writer.write(chunk));

        // then
        verify(service, times(1)).saveAll(chunk.getItems());
    }
}