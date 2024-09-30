package com.example.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Reader implements ItemReader<DatoEntrada> {

    private final Iterator<DatoEntrada> entradas;

    public Reader(DatoEntradaService service) {
        entradas = service.findAll().iterator();
    }

    @Override
    public DatoEntrada read() {
        return entradas.hasNext() ? entradas.next() : null;
    }
}
