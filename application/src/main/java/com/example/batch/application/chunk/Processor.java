package com.example.batch.application.chunk;

import com.example.batch.application.configuration.ParameterReader;
import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.model.DatoSalida;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Processor implements ItemProcessor<DatoEntrada, DatoSalida> {

    private final ParameterReader parameterReader;

    @Override
    public DatoSalida process(DatoEntrada entrada) {
        var total = entrada.getPrice().multiply(entrada.getAmount());
        return DatoSalida.builder()
                .total(total.add(total.multiply(parameterReader.getIva())))
                .build();
    }
}
