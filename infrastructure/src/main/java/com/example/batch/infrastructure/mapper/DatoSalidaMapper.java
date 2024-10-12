package com.example.batch.infrastructure.mapper;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.infrastructure.entity.salida.DatoSalidaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DatoSalidaMapper {

    @Mapping(target = "id", source = "uuid")
    DatoSalida toModel(DatoSalidaEntity salida);

    List<DatoSalida> toModels(List<DatoSalidaEntity> salidas);

    @InheritInverseConfiguration
    DatoSalidaEntity toEntity(DatoSalida salida);

    List<DatoSalidaEntity> toEntities(List<DatoSalida> salidas);
}
