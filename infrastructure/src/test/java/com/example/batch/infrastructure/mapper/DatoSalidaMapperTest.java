package com.example.batch.infrastructure.mapper;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.infrastructure.Data;
import com.example.batch.infrastructure.configuration.MapperTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = {MapperTestConfig.class})
class DatoSalidaMapperTest {

    @Autowired
    private DatoSalidaMapper mapper;

    @Test
    void toEntity() {
        // when
        var actual = mapper.toEntity(Data.SALIDA_1);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.SALIDA_ENTITY_1.getUuid(), actual.getUuid()),
                () -> assertEquals(Data.SALIDA_ENTITY_1.getTotal(), actual.getTotal())
        );
    }

    @Test
    void toEntityNullUUID() {
        // given
        var salida = DatoSalida.builder()
                .total(BigDecimal.valueOf(360))
                .build();

        // when
        var actual = mapper.toEntity(salida);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertNull(actual.getUuid()),
                () -> assertEquals(Data.SALIDA_ENTITY_1.getTotal(), actual.getTotal())
        );
    }

    @Test
    void toEntityNull() {
        assertNull(mapper.toEntity(null));
    }

    @Test
    void toEntities() {
        // when
        var actual = mapper.toEntities(Data.DATOS_SALIDA);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertFalse(actual.isEmpty()),
                () -> assertEquals(3, actual.size()),
                () -> {
                    var salida = actual.get(0);
                    assertAll(
                            () -> assertNotNull(salida),
                            () -> assertEquals(Data.SALIDA_ENTITY_1.getUuid(), salida.getUuid()),
                            () -> assertEquals(Data.SALIDA_ENTITY_1.getTotal(), salida.getTotal())
                    );
                },
                () -> {
                    var salida = actual.get(1);
                    assertAll(
                            () -> assertNotNull(salida),
                            () -> assertEquals(Data.SALIDA_ENTITY_2.getUuid(), salida.getUuid()),
                            () -> assertEquals(Data.SALIDA_ENTITY_2.getTotal(), salida.getTotal())
                    );
                },
                () -> {
                    var salida = actual.get(2);
                    assertAll(
                            () -> assertNotNull(salida),
                            () -> assertEquals(Data.SALIDA_ENTITY_3.getUuid(), salida.getUuid()),
                            () -> assertEquals(Data.SALIDA_ENTITY_3.getTotal(), salida.getTotal())
                    );
                }
        );
    }

    @Test
    void toEntitiesNull() {
        assertNull(mapper.toEntities(null));
    }
}