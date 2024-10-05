package com.example.batch.infrastructure.mapper;

import com.example.batch.infrastructure.Data;
import com.example.batch.infrastructure.configuration.MapperTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = {MapperTestConfig.class})
class DatoEntradaMapperTest {

    @Autowired
    private DatoEntradaMapper mapper;

    @Test
    void toModel() {
        // when
        var actual = mapper.toModel(Data.ENTRADA_ENTITY_1);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ENTRADA_1.getId(), actual.getId()),
                () -> assertEquals(Data.ENTRADA_1.getPrice(), actual.getPrice()),
                () -> assertEquals(Data.ENTRADA_1.getAmount(), actual.getAmount())
        );
    }

    @Test
    void toModelNull() {
        assertNull(mapper.toModel(null));
    }

    @Test
    void toModels() {
        // when
        var actual = mapper.toModels(Data.DATO_ENTRADA_ENTITIES);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertFalse(actual.isEmpty()),
                () -> assertEquals(3, actual.size()),
                () -> {
                    var entrada = actual.get(0);
                    assertAll(
                            () -> assertNotNull(entrada),
                            () -> assertEquals(Data.ENTRADA_1.getId(), entrada.getId()),
                            () -> assertEquals(Data.ENTRADA_1.getPrice(), entrada.getPrice()),
                            () -> assertEquals(Data.ENTRADA_1.getAmount(), entrada.getAmount())
                    );
                },
                () -> {
                    var entrada = actual.get(1);
                    assertAll(
                            () -> assertNotNull(entrada),
                            () -> assertEquals(Data.ENTRADA_2.getId(), entrada.getId()),
                            () -> assertEquals(Data.ENTRADA_2.getPrice(), entrada.getPrice()),
                            () -> assertEquals(Data.ENTRADA_2.getAmount(), entrada.getAmount())
                    );
                },
                () -> {
                    var entrada = actual.get(2);
                    assertAll(
                            () -> assertNotNull(entrada),
                            () -> assertEquals(Data.ENTRADA_3.getId(), entrada.getId()),
                            () -> assertEquals(Data.ENTRADA_3.getPrice(), entrada.getPrice()),
                            () -> assertEquals(Data.ENTRADA_3.getAmount(), entrada.getAmount())
                    );
                }
        );
    }

    @Test
    void toModelsNull() {
        assertNull(mapper.toModels(null));
    }
}