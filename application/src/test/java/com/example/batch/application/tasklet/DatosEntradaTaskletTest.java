package com.example.batch.application.tasklet;

import com.example.batch.application.Data;
import com.example.batch.domain.service.DatoEntradaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatosEntradaTaskletTest {

    @InjectMocks
    private DatosEntradaTasklet datosEntradaTasklet;

    @Mock
    private DatoEntradaService datoEntradaService;

    @Test
    void executeWithEntradas() {
        // given
        var stepContribution = Mockito.mock(StepContribution.class);
        var chunkContext = Mockito.mock(ChunkContext.class);

        when(datoEntradaService.findAll()).thenReturn(Data.DATOS_ENTRADA);

        // when
        var actual = datosEntradaTasklet.execute(stepContribution, chunkContext);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(RepeatStatus.FINISHED, actual)
        );

        verify(datoEntradaService, times(1)).findAll();
        verifyNoMoreInteractions(datoEntradaService);
    }

    @Test
    void executeWithoutEntradas() {
        // given
        var stepContribution = Mockito.mock(StepContribution.class);
        var chunkContext = Mockito.mock(ChunkContext.class);

        when(datoEntradaService.findAll()).thenReturn(List.of());

        // when
        var actual = datosEntradaTasklet.execute(stepContribution, chunkContext);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(RepeatStatus.FINISHED, actual)
        );

        verify(datoEntradaService, times(1)).findAll();
        verify(datoEntradaService, times(1)).saveAll(DatosEntradaTasklet.DATOS_ENTRADA);
        verifyNoMoreInteractions(datoEntradaService);
    }
}