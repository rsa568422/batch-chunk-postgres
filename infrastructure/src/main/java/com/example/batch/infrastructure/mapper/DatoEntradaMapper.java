package com.example.batch.infrastructure.mapper;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.infrastructure.entity.entrada.DatoEntradaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DatoEntradaMapper {

    @Mapping(target = "id", source = "uuid")
    DatoEntrada toModel(DatoEntradaEntity entrada);

    List<DatoEntrada> toModels(List<DatoEntradaEntity> entradas);
}
