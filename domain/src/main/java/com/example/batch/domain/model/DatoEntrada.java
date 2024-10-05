package com.example.batch.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DatoEntrada {

    private String id;

    private BigDecimal price;

    private BigDecimal amount;
}
