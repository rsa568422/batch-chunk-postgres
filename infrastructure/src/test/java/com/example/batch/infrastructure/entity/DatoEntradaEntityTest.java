package com.example.batch.infrastructure.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatoEntradaEntityTest {

    @Test
    void noArgsConstructor() {
        // given
        var uuid = UUID.fromString("2086c21a-84ab-4073-bae9-54ceeaca57ae");
        var price = BigDecimal.valueOf(3);
        var amount = BigDecimal.valueOf(120);

        // when
        var actual = new DatoEntradaEntity();
        actual.setUuid(uuid);
        actual.setPrice(price);
        actual.setAmount(amount);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getUuid()),
                () -> assertEquals(price, actual.getPrice()),
                () -> assertEquals(amount, actual.getAmount())
        );
    }

    @Test
    void allArgsConstructor() {
        // given
        var uuid = UUID.fromString("2086c21a-84ab-4073-bae9-54ceeaca57ae");
        var price = BigDecimal.valueOf(3);
        var amount = BigDecimal.valueOf(120);

        // when
        var actual = new DatoEntradaEntity(uuid, price, amount);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getUuid()),
                () -> assertEquals(price, actual.getPrice()),
                () -> assertEquals(amount, actual.getAmount())
        );
    }
}