package com.example.batch.application.configuration;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static com.example.batch.application.configuration.Constants.ENTRADA_DATASOURCE;
import static com.example.batch.application.configuration.Constants.SALIDA_DATASOURCE;
import static com.example.batch.application.configuration.Constants.SPRING_DATASOURCE;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean
    @BatchDataSource
    @ConfigurationProperties(prefix = SPRING_DATASOURCE)
    public DataSource batchDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = ENTRADA_DATASOURCE)
    public DataSource entradaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = SALIDA_DATASOURCE)
    public DataSource salidaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager batchTransactionManager(@BatchDataSource DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
