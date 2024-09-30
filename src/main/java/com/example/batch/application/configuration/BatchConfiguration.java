package com.example.batch.application.configuration;

import com.example.batch.infrastructure.entity.DatoEntradaEntity;
import com.example.batch.infrastructure.entity.DatoSalidaEntity;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfiguration {

    @Bean
    public Job miJob(JobRepository jobRepository, Step miStep) {
        return new JobBuilder("batchJob", jobRepository)
                .start(miStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step miStep(JobRepository jobRepository,
                       PlatformTransactionManager transactionManager,
                       ItemReader<DatoEntradaEntity> reader,
                       ItemProcessor<DatoEntradaEntity, DatoSalidaEntity> processor,
                       ItemWriter<DatoSalidaEntity> writer) {
        return new StepBuilder("batchStep", jobRepository)
                .<DatoEntradaEntity, DatoSalidaEntity>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
