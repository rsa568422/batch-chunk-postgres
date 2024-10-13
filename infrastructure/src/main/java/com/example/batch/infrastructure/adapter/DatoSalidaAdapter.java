package com.example.batch.infrastructure.adapter;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.domain.repository.DatoSalidaRepository;
import com.example.batch.infrastructure.mapper.DatoSalidaMapper;
import com.example.batch.infrastructure.repository.salida.DatoSalidaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatoSalidaAdapter implements DatoSalidaRepository {

    private final DatoSalidaJpaRepository jpaRepository;

    private final DatoSalidaMapper mapper;

    @Override
    public List<DatoSalida> findAll() {
        return mapper.toModels(jpaRepository.findAll());
    }

    @Override
    public void saveAll(List<DatoSalida> salidas) {
        jpaRepository.saveAll(mapper.toEntities(salidas));
    }
}
