package com.example.batch.domain.model;

import com.example.batch.domain.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatoSalidaTest {

    @Test
    void lombok() {
        var actual = DatoSalida.builder().build();
        actual.setId(Data.SALIDA.getId());
        actual.setTotal(Data.SALIDA.getTotal());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.SALIDA, actual),
                () -> assertEquals(Data.SALIDA.getId(), actual.getId()),
                () -> assertEquals(Data.SALIDA.getTotal(), actual.getTotal()),
                () -> assertEquals(Data.SALIDA.hashCode(), actual.hashCode()),
                () -> assertEquals(Data.SALIDA.toString(), actual.toString()),
                () -> {
                    var newActual = DatoSalida.builder().build();
                    actual.setId(Data.SALIDA.getId());
                    actual.setTotal(BigDecimal.TEN);
                    assertNotEquals(Data.SALIDA, newActual);
                }
        );
    }
}