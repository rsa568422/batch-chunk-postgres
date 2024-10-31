package com.example.batch.application.configuration;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@StepScope
public class ParameterReader {

    @Value("#{jobParameters['param']}")
    private String param;

    public BigDecimal getIva() {
        return NumberUtils.createBigDecimal(param);
    }
}
