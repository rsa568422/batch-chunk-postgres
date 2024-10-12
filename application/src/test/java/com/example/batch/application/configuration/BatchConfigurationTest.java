package com.example.batch.application.configuration;

import com.example.batch.application.tasklet.DatosEntradaTasklet;
import com.example.batch.application.tasklet.DatosSalidaTasklet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.transaction.PlatformTransactionManager;

import static com.example.batch.application.configuration.Constants.BATCH_JOB;
import static com.example.batch.application.configuration.Constants.BATCH_STEP;
import static com.example.batch.application.configuration.Constants.RESULTS_STEP;
import static com.example.batch.application.configuration.Constants.SAMPLE_DATA_STEP;
import static com.example.batch.application.configuration.Constants.UNCHECKED;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class BatchConfigurationTest {

    @InjectMocks
    private BatchConfiguration batchConfiguration;

    @Mock
    private JobRepository jobRepository;

    @Test
    void job() {
        // given
        var sampleDataStep = Mockito.mock(Step.class);
        var batchStep = Mockito.mock(Step.class);
        var resultsStep = Mockito.mock(Step.class);

        // when
        var actual = batchConfiguration.job(sampleDataStep, batchStep, resultsStep);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(Job.class, actual),
                () -> assertEquals(BATCH_JOB, actual.getName())
        );
    }

    @Test
    void sampleDataStep() {
        // given
        var transactionManager = Mockito.mock(PlatformTransactionManager.class);
        var datosEntradaTasklet = Mockito.mock(DatosEntradaTasklet.class);

        // when
        var actual = batchConfiguration.sampleDataStep(transactionManager, datosEntradaTasklet);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(Step.class, actual),
                () -> assertEquals(SAMPLE_DATA_STEP, actual.getName())
        );
    }

    @Test
    @SuppressWarnings(UNCHECKED)
    void batchStep() {
        // given
        var transactionManager = Mockito.mock(PlatformTransactionManager.class);
        var reader = Mockito.mock(ItemReader.class);
        var processor = Mockito.mock(ItemProcessor.class);
        var writer = Mockito.mock(ItemWriter.class);

        // when
        var actual = batchConfiguration.batchStep(transactionManager, reader, processor, writer);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(Step.class, actual),
                () -> assertEquals(BATCH_STEP, actual.getName())
        );
    }

    @Test
    void resultsStep() {
        // given
        var transactionManager = Mockito.mock(PlatformTransactionManager.class);
        var datosSalidaTasklet = Mockito.mock(DatosSalidaTasklet.class);

        // when
        var actual = batchConfiguration.resultsStep(transactionManager, datosSalidaTasklet);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(Step.class, actual),
                () -> assertEquals(RESULTS_STEP, actual.getName())
        );
    }
}