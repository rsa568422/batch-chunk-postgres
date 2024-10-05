package com.example.batch.infrastructure.adapter;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.repository.DatoEntradaRepository;
import com.example.batch.infrastructure.mapper.DatoEntradaMapper;
import com.example.batch.infrastructure.repository.DatoEntradaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatoEntradaAdapter implements DatoEntradaRepository {

    private final DatoEntradaJpaRepository jpaRepository;

    private final DatoEntradaMapper mapper;

    @Override
    public List<DatoEntrada> findAll() {
        return mapper.toModels(jpaRepository.findAll());
    }
}
