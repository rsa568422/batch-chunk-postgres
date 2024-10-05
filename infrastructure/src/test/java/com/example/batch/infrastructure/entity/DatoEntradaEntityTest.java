package com.example.batch.infrastructure.entity;

import com.example.batch.infrastructure.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatoEntradaEntityTest {

    @Test
    void lombok() {
        var actual = new DatoEntradaEntity();
        actual.setUuid(UUID.fromString("2086c21a-84ab-4073-bae9-54ceeaca57ae"));
        actual.setPrice(BigDecimal.valueOf(3));
        actual.setAmount(BigDecimal.valueOf(120));

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ENTRADA_ENTITY_1.getUuid(), actual.getUuid()),
                () -> assertEquals(Data.ENTRADA_ENTITY_1.getPrice(), actual.getPrice()),
                () -> assertEquals(Data.ENTRADA_ENTITY_1.getAmount(), actual.getAmount())
        );
    }
}