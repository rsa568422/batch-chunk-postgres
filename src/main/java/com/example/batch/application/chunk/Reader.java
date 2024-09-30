package com.example.batch.application.chunk;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import com.example.batch.application.service.DatoEntradaService;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Reader implements ItemReader<DatoEntradaEntity> {

    private final Iterator<DatoEntradaEntity> entradas;

    public Reader(DatoEntradaService service) {
        entradas = service.findAll().iterator();
    }

    @Override
    public DatoEntradaEntity read() {
        return entradas.hasNext() ? entradas.next() : null;
    }
}
