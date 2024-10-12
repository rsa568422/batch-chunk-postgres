package com.example.batch.application.configuration;

import com.example.batch.application.tasklet.DatosEntradaTasklet;
import com.example.batch.application.tasklet.DatosSalidaTasklet;
import com.example.batch.domain.model.DatoEntrada;
import com.example.batch.domain.model.DatoSalida;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import static com.example.batch.application.configuration.Constants.BASE_PACKAGE;
import static com.example.batch.application.configuration.Constants.BATCH_JOB;
import static com.example.batch.application.configuration.Constants.BATCH_STEP;
import static com.example.batch.application.configuration.Constants.BATCH_TRANSACTION_MANAGER;
import static com.example.batch.application.configuration.Constants.ENTRADA_TRANSACTION_MANAGER;
import static com.example.batch.application.configuration.Constants.RESULTS_STEP;
import static com.example.batch.application.configuration.Constants.SALIDA_TRANSACTION_MANAGER;
import static com.example.batch.application.configuration.Constants.SAMPLE_DATA_STEP;

@Configuration
@RequiredArgsConstructor
@ComponentScan(BASE_PACKAGE)
public class BatchConfiguration {

    private final JobRepository jobRepository;

    @Bean
    public Job job(@Qualifier(SAMPLE_DATA_STEP) Step sampleDataStep,
                   @Qualifier(BATCH_STEP) Step batchStep,
                   @Qualifier(RESULTS_STEP) Step resultsStep) {
        return new JobBuilder(BATCH_JOB, jobRepository)
                .start(sampleDataStep)
                .next(batchStep)
                .next(resultsStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step sampleDataStep(@Qualifier(ENTRADA_TRANSACTION_MANAGER) PlatformTransactionManager transactionManager,
                               DatosEntradaTasklet datosEntradaTasklet) {
        return new StepBuilder(SAMPLE_DATA_STEP, jobRepository)
                .tasklet(datosEntradaTasklet, transactionManager)
                .build();
    }

    @Bean
    public Step batchStep(@Qualifier(BATCH_TRANSACTION_MANAGER) PlatformTransactionManager transactionManager,
                          ItemReader<DatoEntrada> reader,
                          ItemProcessor<DatoEntrada, DatoSalida> processor,
                          ItemWriter<DatoSalida> writer) {
        return new StepBuilder(BATCH_STEP, jobRepository)
                .<DatoEntrada, DatoSalida>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Step resultsStep(@Qualifier(SALIDA_TRANSACTION_MANAGER) PlatformTransactionManager transactionManager,
                            DatosSalidaTasklet datosSalidaTasklet) {
        return new StepBuilder(RESULTS_STEP, jobRepository)
                .tasklet(datosSalidaTasklet, transactionManager)
                .build();
    }
}