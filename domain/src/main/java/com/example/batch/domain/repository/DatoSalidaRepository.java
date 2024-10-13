package com.example.batch.domain.repository;

import com.example.batch.domain.model.DatoSalida;

import java.util.List;

public interface DatoSalidaRepository {

    List<DatoSalida> findAll();

    void saveAll(List<DatoSalida> salidas);
}
