package com.example.batch.infrastructure.entity;

import com.example.batch.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatoSalidaEntityTest {

    @Test
    void lombok() {
        var actual = new DatoSalidaEntity();
        actual.setUuid(UUID.fromString("cda33687-2f86-4da5-828c-aa7f95a098e3"));
        actual.setTotal(BigDecimal.valueOf(360));

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.SALIDA_ENTITY_1.getUuid(), actual.getUuid()),
                () -> assertEquals(Data.SALIDA_ENTITY_1.getTotal(), actual.getTotal())
        );
    }
}