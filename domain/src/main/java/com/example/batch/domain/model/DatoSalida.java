package com.example.batch.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DatoSalida {

    private String id;

    private BigDecimal total;
}
