package com.example.batch.infrastructure;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.model.DatoSalida;
import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import com.example.batch.infrastructure.entity.DatoSalidaEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Data {

    public static final DatoEntrada ENTRADA_1 = DatoEntrada.builder()
            .id("2086c21a-84ab-4073-bae9-54ceeaca57ae")
            .price(BigDecimal.valueOf(3))
            .amount(BigDecimal.valueOf(120))
            .build();

    public static final DatoEntrada ENTRADA_2 = DatoEntrada.builder()
            .id("c938e32d-ea27-41e2-951d-6744a84ccb31")
            .price(BigDecimal.valueOf(5))
            .amount(BigDecimal.valueOf(30))
            .build();

    public static final DatoEntrada ENTRADA_3 = DatoEntrada.builder()
            .id("16d16c53-0529-4ef0-91be-28b89c6cc947")
            .price(BigDecimal.valueOf(1))
            .amount(BigDecimal.valueOf(200))
            .build();

    public static final List<DatoEntrada> DATOS_ENTRADA = List.of(ENTRADA_1, ENTRADA_2, ENTRADA_3);

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

    public static final DatoSalida SALIDA_1 = DatoSalida.builder()
            .id("cda33687-2f86-4da5-828c-aa7f95a098e3")
            .total(BigDecimal.valueOf(360))
            .build();

    public static final DatoSalida SALIDA_2 = DatoSalida.builder()
            .id("cf541dc1-7878-4da4-8d49-d53a2d0ccc1e")
            .total(BigDecimal.valueOf(150))
            .build();

    public static final DatoSalida SALIDA_3 = DatoSalida.builder()
            .id("9c75bdf7-f9ff-4a79-8c7e-1a5f62401971")
            .total(BigDecimal.valueOf(200))
            .build();

    public static final List<DatoSalida> DATOS_SALIDA = List.of(SALIDA_1, SALIDA_2, SALIDA_3);

    public static final DatoSalidaEntity SALIDA_ENTITY_1 = new DatoSalidaEntity(
            UUID.fromString("cda33687-2f86-4da5-828c-aa7f95a098e3"),
            BigDecimal.valueOf(360)
    );

    public static final DatoSalidaEntity SALIDA_ENTITY_2 = new DatoSalidaEntity(
            UUID.fromString("cf541dc1-7878-4da4-8d49-d53a2d0ccc1e"),
            BigDecimal.valueOf(150)
    );

    public static final DatoSalidaEntity SALIDA_ENTITY_3 = new DatoSalidaEntity(
            UUID.fromString("9c75bdf7-f9ff-4a79-8c7e-1a5f62401971"),
            BigDecimal.valueOf(200)
    );

    public static final List<DatoSalidaEntity> DATO_SALIDA_ENTITIES =
            List.of(SALIDA_ENTITY_1, SALIDA_ENTITY_2, SALIDA_ENTITY_3);
}
