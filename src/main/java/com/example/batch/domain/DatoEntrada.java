package com.example.batch.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record DatoEntrada(UUID uuid, BigDecimal price, BigDecimal amount) { }
