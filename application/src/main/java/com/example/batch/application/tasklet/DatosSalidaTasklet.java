package com.example.batch.application.tasklet;

import com.example.batch.domain.model.DatoSalida;
import com.example.batch.domain.service.DatoSalidaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatosSalidaTasklet implements Tasklet {

    private final DatoSalidaService datoSalidaService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        log.info("Resultados obtenidos:");
        datoSalidaService.findAll().stream().map(DatoSalida::toString).forEach(log::info);
        return RepeatStatus.FINISHED;
    }
}
