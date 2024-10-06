package com.example.batch.domain;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.model.DatoSalida;

import java.math.BigDecimal;

public class Data {

    public static final DatoEntrada ENTRADA = DatoEntrada.builder()
            .id("2086c21a-84ab-4073-bae9-54ceeaca57ae")
            .price(BigDecimal.valueOf(3))
            .amount(BigDecimal.valueOf(120))
            .build();

    public static final DatoSalida SALIDA = DatoSalida.builder()
            .id("cda33687-2f86-4da5-828c-aa7f95a098e3")
            .total(BigDecimal.valueOf(360))
            .build();
}
