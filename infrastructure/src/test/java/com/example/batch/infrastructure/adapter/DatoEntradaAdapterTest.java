package com.example.batch.infrastructure.adapter;

import com.example.batch.infrastructure.Data;
import com.example.batch.infrastructure.mapper.DatoEntradaMapper;
import com.example.batch.infrastructure.repository.entrada.DatoEntradaJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatoEntradaAdapterTest {

    @InjectMocks
    private DatoEntradaAdapter adapter;

    @Mock
    private DatoEntradaJpaRepository jpaRepository;

    @Mock
    private DatoEntradaMapper mapper;

    @Test
    void findAll() {
        // given
        when(jpaRepository.findAll()).thenReturn(Data.DATO_ENTRADA_ENTITIES);
        when(mapper.toModels(Data.DATO_ENTRADA_ENTITIES)).thenReturn(Data.DATOS_ENTRADA);

        // when
        var actual = adapter.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(Data.DATOS_ENTRADA, actual)
        );

        verify(jpaRepository, times(1)).findAll();
        verify(mapper, times(1)).toModels(Data.DATO_ENTRADA_ENTITIES);
        verifyNoMoreInteractions(jpaRepository, mapper);
    }

    @Test
    void saveAll() {
        // given
        when(mapper.toEntities(Data.DATOS_ENTRADA)).thenReturn(Data.DATO_ENTRADA_ENTITIES);

        // when
        assertDoesNotThrow(() -> adapter.saveAll(Data.DATOS_ENTRADA));

        // then
        verify(mapper, times(1)).toEntities(Data.DATOS_ENTRADA);
        verify(jpaRepository, times(1)).saveAll(Data.DATO_ENTRADA_ENTITIES);
        verifyNoMoreInteractions(jpaRepository, mapper);
    }
}