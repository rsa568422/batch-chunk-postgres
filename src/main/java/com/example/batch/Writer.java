package com.example.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Writer implements ItemWriter<DatoSalida> {

    private final DatoSalidaService service;

    @Override
    public void write(Chunk<? extends DatoSalida> chunk) {
        var items = chunk.getItems();
        service.save(items);
    }
}
