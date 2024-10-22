package com.example.batch.application.tasklet;

import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.service.DatoEntradaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static com.example.batch.infrastructure.configuration.Constants.ENTRADA_TRANSACTION_MANAGER;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatosEntradaTasklet implements Tasklet {

    private final DatoEntradaService datoEntradaService;

    @Override
    @Transactional(ENTRADA_TRANSACTION_MANAGER)
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        var datos = datoEntradaService.findAll();
        if (datos.isEmpty()) {
            log.info("Sin datos de entrada, se insertan datos de muestra:");
            DATOS_ENTRADA.stream().map(DatoEntrada::toString).forEach(log::info);
            datoEntradaService.saveAll(DATOS_ENTRADA);
        } else {
            log.info("Con los siguientes datos de entrada:");
            datos.stream().map(DatoEntrada::toString).forEach(log::info);
        }
        return RepeatStatus.FINISHED;
    }

    protected static final List<DatoEntrada> DATOS_ENTRADA = List.of(
            DatoEntrada.builder().price(BigDecimal.valueOf(120)).amount(BigDecimal.valueOf(3)).build(),
            DatoEntrada.builder().price(BigDecimal.valueOf(200)).amount(BigDecimal.valueOf(1)).build(),
            DatoEntrada.builder().price(BigDecimal.valueOf(50)).amount(BigDecimal.valueOf(6)).build()
    );
}
