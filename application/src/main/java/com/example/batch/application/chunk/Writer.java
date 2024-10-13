package com.example.batch.application.chunk;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.application.service.DatoSalidaBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.batch.application.configuration.Constants.SALIDA_TRANSACTION_MANAGER;
import static com.example.batch.application.configuration.Constants.UNCHECKED;

@Component
@RequiredArgsConstructor
public class Writer implements ItemWriter<DatoSalida> {

    private final DatoSalidaBatchService service;

    @Override
    @SuppressWarnings(UNCHECKED)
    @Transactional(SALIDA_TRANSACTION_MANAGER)
    public void write(Chunk<? extends DatoSalida> chunk) {
        var items = (List<DatoSalida>) chunk.getItems();
        service.saveAll(items);
    }
}
