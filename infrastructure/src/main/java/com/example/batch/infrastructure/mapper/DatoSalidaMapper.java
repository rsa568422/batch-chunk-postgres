package com.example.batch.infrastructure.mapper;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.infrastructure.entity.DatoSalidaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DatoSalidaMapper {

    @Mapping(target = "uuid", source = "id")
    DatoSalidaEntity toEntity(DatoSalida salida);

    List<DatoSalidaEntity> toEntities(List<DatoSalida> salidas);
}
