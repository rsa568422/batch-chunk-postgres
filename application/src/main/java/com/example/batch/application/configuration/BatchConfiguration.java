package com.example.batch.application.configuration;

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

@Configuration
@RequiredArgsConstructor
@ComponentScan(BASE_PACKAGE)
public class BatchConfiguration {

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder(BATCH_JOB, jobRepository)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     @Qualifier(BATCH_TRANSACTION_MANAGER) PlatformTransactionManager transactionManager,
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
}
