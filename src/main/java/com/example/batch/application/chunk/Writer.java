package com.example.batch.application.chunk;

import com.example.batch.infrastructure.entity.DatoSalidaEntity;
import com.example.batch.application.service.DatoSalidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Writer implements ItemWriter<DatoSalidaEntity> {

    private final DatoSalidaService service;

    @Override
    public void write(Chunk<? extends DatoSalidaEntity> chunk) {
        var items = chunk.getItems();
        service.save(items);
    }
}
