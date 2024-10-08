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

class DatoEntradaTest {

    @Test
    void lombok() {
        // given
        var uuid = "2086c21a-84ab-4073-bae9-54ceeaca57ae";
        var price = BigDecimal.valueOf(3);
        var amount = BigDecimal.valueOf(120);
        var hashCode = -1952303542;
        var toString = "DatoEntrada(id=2086c21a-84ab-4073-bae9-54ceeaca57ae, price=3, amount=120)";

        // when
        var actual = DatoEntrada.builder().build();
        actual.setId(uuid);
        actual.setPrice(price);
        actual.setAmount(amount);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(uuid, actual.getId()),
                () -> assertEquals(price, actual.getPrice()),
                () -> assertEquals(amount, actual.getAmount()),
                () -> assertEquals(Data.ENTRADA, actual),
                () -> assertTrue(actual.equals(actual)),
                () -> assertFalse(actual.equals(null)),
                () -> assertFalse(actual.equals(BigDecimal.TEN)),
                () -> assertEquals(hashCode, actual.hashCode()),
                () -> assertEquals(toString, actual.toString()),
                () -> {
                    var newActual = DatoEntrada.builder().id(uuid).price(BigDecimal.TEN).amount(BigDecimal.ONE).build();
                    assertNotEquals(Data.ENTRADA, newActual);
                }
        );
    }
}