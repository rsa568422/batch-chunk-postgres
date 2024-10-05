package com.example.batch.application.chunk;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.model.DatoSalida;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<DatoEntrada, DatoSalida> {

    @Override
    public DatoSalida process(DatoEntrada entrada) {
        return DatoSalida.builder()
                .total(entrada.getPrice().multiply(entrada.getAmount()))
                .build();
    }
}
