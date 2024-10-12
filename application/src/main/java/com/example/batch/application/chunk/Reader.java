package com.example.batch.application.chunk;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.service.DatoEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@RequiredArgsConstructor
public class Reader implements ItemReader<DatoEntrada> {

    private final DatoEntradaService service;

    private Iterator<DatoEntrada> entradas;

    @BeforeStep
    protected void findAll() {
        entradas = service.findAll().iterator();
    }

    @Override
    public DatoEntrada read() {
        return entradas.hasNext() ? entradas.next() : null;
    }
}
