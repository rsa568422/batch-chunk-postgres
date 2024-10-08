package com.example.batch.infrastructure.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatoSalidaEntityTest {

    @Test
    void noArgsConstructor() {
        // given
        var uuid = UUID.fromString("cda33687-2f86-4da5-828c-aa7f95a098e3");
        var total = BigDecimal.valueOf(360);

        // when
        var actual = new DatoSalidaEntity();
        actual.setUuid(uuid);
        actual.setTotal(total);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getUuid()),
                () -> assertEquals(total, actual.getTotal())
        );
    }

    @Test
    void allArgsConstructor() {
        // given
        var uuid = UUID.fromString("cda33687-2f86-4da5-828c-aa7f95a098e3");
        var total = BigDecimal.valueOf(360);

        // when
        var actual = new DatoSalidaEntity(uuid, total);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getUuid()),
                () -> assertEquals(total, actual.getTotal())
        );
    }
}