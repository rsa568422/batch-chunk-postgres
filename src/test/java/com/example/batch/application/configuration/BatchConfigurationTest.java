package com.example.batch.application.configuration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.transaction.PlatformTransactionManager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BatchConfigurationTest {

    @Test
    void job() {
        // given
        var jobRepository = Mockito.mock(JobRepository.class);
        var step = Mockito.mock(Step.class);

        // when
        var actual = new BatchConfiguration().job(jobRepository, step);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals("batchJob", actual.getName())
        );
    }

    @Test
    @SuppressWarnings("unchecked")
    void step() {
        // given
        var jobRepository = Mockito.mock(JobRepository.class);
        var transactionManager = Mockito.mock(PlatformTransactionManager.class);
        var reader = Mockito.mock(ItemReader.class);
        var processor = Mockito.mock(ItemProcessor.class);
        var writer = Mockito.mock(ItemWriter.class);

        // when
        var actual = new BatchConfiguration().step(jobRepository, transactionManager, reader, processor, writer);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals("batchStep", actual.getName())
        );
    }
}