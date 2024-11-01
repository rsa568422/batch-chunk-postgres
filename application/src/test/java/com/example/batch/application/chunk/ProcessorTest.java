package com.example.batch.application.chunk;

import com.example.batch.application.Data;
import com.example.batch.application.configuration.ParameterReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProcessorTest {

    @InjectMocks
    private Processor processor;

    @Mock
    private ParameterReader parameterReader;

    @Test
    void process() {
        // given
        when(parameterReader.getIva()).thenReturn(BigDecimal.valueOf(0.10));

        // when
        var actual = processor.process(Data.ENTRADA_1);

        // then
        assertNotNull(actual);
        assertEquals(Data.SALIDA_1.getTotal(), actual.getTotal());
    }
}