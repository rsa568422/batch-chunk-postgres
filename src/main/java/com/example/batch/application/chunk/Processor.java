package com.example.batch.application.chunk;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import com.example.batch.infrastructure.entity.DatoSalidaEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<DatoEntradaEntity, DatoSalidaEntity> {

    @Override
    public DatoSalidaEntity process(DatoEntradaEntity entrada) {
        return new DatoSalidaEntity(null, entrada.getPrice().multiply(entrada.getAmount()));
    }
}
