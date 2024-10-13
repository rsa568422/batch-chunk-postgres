package com.example.batch.infrastructure.adapter;

import com.example.batch.infrastructure.Data;
import com.example.batch.infrastructure.mapper.DatoSalidaMapper;
import com.example.batch.infrastructure.repository.salida.DatoSalidaJpaRepository;
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
class DatoSalidaAdapterTest {

    @InjectMocks
    private DatoSalidaAdapter adapter;

    @Mock
    private DatoSalidaJpaRepository jpaRepository;

    @Mock
    private DatoSalidaMapper mapper;

    @Test
    void findAll() {
        // given
        when(jpaRepository.findAll()).thenReturn(Data.DATO_SALIDA_ENTITIES);
        when(mapper.toModels(Data.DATO_SALIDA_ENTITIES)).thenReturn(Data.DATOS_SALIDA);

        // when
        var actual = adapter.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(Data.DATOS_SALIDA, actual)
        );

        verify(jpaRepository, times(1)).findAll();
        verify(mapper, times(1)).toModels(Data.DATO_SALIDA_ENTITIES);
        verifyNoMoreInteractions(jpaRepository, mapper);
    }

    @Test
    void saveAll() {
        // given
        when(mapper.toEntities(Data.DATOS_SALIDA)).thenReturn(Data.DATO_SALIDA_ENTITIES);

        // when
        assertDoesNotThrow(() -> adapter.saveAll(Data.DATOS_SALIDA));

        // then
        verify(mapper, times(1)).toEntities(Data.DATOS_SALIDA);
        verify(jpaRepository, times(1)).saveAll(Data.DATO_SALIDA_ENTITIES);
        verifyNoMoreInteractions(jpaRepository, mapper);
    }
}