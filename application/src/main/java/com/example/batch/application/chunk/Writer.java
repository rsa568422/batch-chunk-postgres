package com.example.batch.application.chunk;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.application.service.DatoSalidaBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Writer implements ItemWriter<DatoSalida> {

    private final DatoSalidaBatchService service;

    @Override
    @SuppressWarnings("unchecked")
    public void write(Chunk<? extends DatoSalida> chunk) {
        var items = (List<DatoSalida>) chunk.getItems();
        service.saveAll(items);
    }
}
