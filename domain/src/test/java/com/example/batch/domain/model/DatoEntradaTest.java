package com.example.batch.domain.model;

import com.example.batch.domain.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DatoEntradaTest {

    @Test
    void lombok() {
        var actual = DatoEntrada.builder().build();
        actual.setId(Data.ENTRADA.getId());
        actual.setPrice(Data.ENTRADA.getPrice());
        actual.setAmount(Data.ENTRADA.getAmount());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ENTRADA, actual),
                () -> assertEquals(Data.ENTRADA.getId(), actual.getId()),
                () -> assertEquals(Data.ENTRADA.getPrice(), actual.getPrice()),
                () -> assertEquals(Data.ENTRADA.getAmount(), actual.getAmount()),
                () -> assertEquals(Data.ENTRADA.hashCode(), actual.hashCode()),
                () -> assertEquals(Data.ENTRADA.toString(), actual.toString()),
                () -> {
                    var newActual = DatoEntrada.builder().build();
                    actual.setId(Data.ENTRADA.getId());
                    actual.setPrice(BigDecimal.TEN);
                    actual.setAmount(Data.ENTRADA.getAmount());
                    assertNotEquals(Data.ENTRADA, newActual);
                }
        );
    }
}