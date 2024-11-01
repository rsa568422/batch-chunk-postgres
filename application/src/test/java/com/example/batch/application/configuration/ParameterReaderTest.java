package com.example.batch.application.configuration;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterReaderTest {

    @Test
    void getIva() {
        // given
        var parameterReader = new ParameterReader();
        parameterReader.param = "0.16";

        // when
        var actual = parameterReader.getIva();

        // Verificar el resultado
        assertEquals(BigDecimal.valueOf(0.16), actual);
    }
}