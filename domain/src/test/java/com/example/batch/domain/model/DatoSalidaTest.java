package com.example.batch.domain.model;

import com.example.batch.domain.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatoSalidaTest {

    @Test
    void lombok() {
        // given
        var uuid = "cda33687-2f86-4da5-828c-aa7f95a098e3";
        var total = BigDecimal.valueOf(360);
        var hashCode = 839205166;
        var toString = "DatoSalida(id=cda33687-2f86-4da5-828c-aa7f95a098e3, total=360)";

        // when
        var actual = DatoSalida.builder().build();
        actual.setId(uuid);
        actual.setTotal(total);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getId()),
                () -> assertEquals(total, actual.getTotal()),
                () -> assertEquals(Data.SALIDA, actual),
                () -> assertTrue(actual.equals(actual)),
                () -> assertFalse(actual.equals(null)),
                () -> assertFalse(actual.equals(BigDecimal.TEN)),
                () -> assertEquals(hashCode, actual.hashCode()),
                () -> assertEquals(toString, actual.toString()),
                () -> {
                    var newActual = DatoSalida.builder().id(uuid).total(BigDecimal.TEN).build();
                    assertNotEquals(Data.SALIDA, newActual);
                }
        );
    }
}