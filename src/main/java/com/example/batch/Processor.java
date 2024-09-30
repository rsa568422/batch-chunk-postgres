package com.example.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<DatoEntrada, DatoSalida> {

    @Override
    public DatoSalida process(DatoEntrada entrada) {
        return new DatoSalida(null, entrada.getPrice().multiply(entrada.getAmount()));
    }
}
