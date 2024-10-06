package com.example.batch.domain.model;

import com.example.batch.domain.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
                () -> assertEquals(Data.ENTRADA.toString(), actual.toString())
        );
    }
}