package com.example.batch.application.configuration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataSourceConfigurationTest {

    private final DataSourceConfiguration dataSourceConfiguration = new DataSourceConfiguration();

    @Test
    void batchDataSource() {
        // when
        var actual = dataSourceConfiguration.batchDataSource();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(DataSource.class, actual)
        );
    }

    @Test
    void batchTransactionManager() {
        // given
        var dataSource = Mockito.mock(DataSource.class);

        // when
        var actual = dataSourceConfiguration.batchTransactionManager(dataSource);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(PlatformTransactionManager.class, actual)
        );
    }
}