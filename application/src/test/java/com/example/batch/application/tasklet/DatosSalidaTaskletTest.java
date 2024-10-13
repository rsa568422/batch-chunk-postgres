package com.example.batch.application.tasklet;

import com.example.batch.application.Data;
import com.example.batch.domain.service.DatoSalidaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatosSalidaTaskletTest {

    @InjectMocks
    private DatosSalidaTasklet datosSalidaTasklet;

    @Mock
    private DatoSalidaService datoSalidaService;

    @Test
    void execute() {
        // given
        var stepContribution = Mockito.mock(StepContribution.class);
        var chunkContext = Mockito.mock(ChunkContext.class);

        when(datoSalidaService.findAll()).thenReturn(Data.DATOS_SALIDA);

        // when
        var actual = datosSalidaTasklet.execute(stepContribution, chunkContext);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(RepeatStatus.FINISHED, actual)
        );

        verify(datoSalidaService, times(1)).findAll();
        verifyNoMoreInteractions(datoSalidaService);
    }
}