package com.example.batch.application;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Data {


    public static final DatoEntradaEntity ENTRADA_ENTITY_1 = new DatoEntradaEntity(
            UUID.fromString("2086c21a-84ab-4073-bae9-54ceeaca57ae"),
            BigDecimal.valueOf(3),
            BigDecimal.valueOf(120)
    );

    public static final DatoEntradaEntity ENTRADA_ENTITY_2 = new DatoEntradaEntity(
            UUID.fromString("c938e32d-ea27-41e2-951d-6744a84ccb31"),
            BigDecimal.valueOf(5),
            BigDecimal.valueOf(30)
    );

    public static final DatoEntradaEntity ENTRADA_ENTITY_3 = new DatoEntradaEntity(
            UUID.fromString("16d16c53-0529-4ef0-91be-28b89c6cc947"),
            BigDecimal.valueOf(1),
            BigDecimal.valueOf(200)
    );

    public static final List<DatoEntradaEntity> DATO_ENTRADA_ENTITIES =
            List.of(ENTRADA_ENTITY_1, ENTRADA_ENTITY_2, ENTRADA_ENTITY_3);
}
