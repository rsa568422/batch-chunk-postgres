package com.example.batch.application.chunk;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.application.service.DatoEntradaBatchService;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Reader implements ItemReader<DatoEntrada> {

    private final Iterator<DatoEntrada> entradas;

    public Reader(DatoEntradaBatchService service) {
        entradas = service.findAll().iterator();
    }

    @Override
    public DatoEntrada read() {
        return entradas.hasNext() ? entradas.next() : null;
    }
}
