package com.example.batch.infrastructure.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

import static com.example.batch.infrastructure.configuration.Constants.HIBERNATE_DIALECT;
import static com.example.batch.infrastructure.configuration.Constants.HIBERNATE_HBM_2_DDL_AUTO;
import static com.example.batch.infrastructure.configuration.Constants.POSTGRES_SQL_DIALECT;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_DATASOURCE;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_DATA_SOURCE;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_ENTITY_MANAGER_FACTORY;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_ENTITY_PACKAGE;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_REPOSITORY_PACKAGE;
import static com.example.batch.infrastructure.configuration.Constants.SALIDA_TRANSACTION_MANAGER;
import static com.example.batch.infrastructure.configuration.Constants.UPDATE;

@Configuration
@EnableJpaRepositories(
        basePackages = SALIDA_REPOSITORY_PACKAGE,
        entityManagerFactoryRef = SALIDA_ENTITY_MANAGER_FACTORY,
        transactionManagerRef = SALIDA_TRANSACTION_MANAGER
)
public class SalidaJpaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = SALIDA_DATASOURCE)
    public DataSource salidaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean salidaEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier(SALIDA_DATA_SOURCE) DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages(SALIDA_ENTITY_PACKAGE)
                .persistenceUnit(SALIDA)
                .properties(Map.of(HIBERNATE_HBM_2_DDL_AUTO, UPDATE, HIBERNATE_DIALECT, POSTGRES_SQL_DIALECT))
                .build();
    }

    @Bean
    public PlatformTransactionManager salidaTransactionManager(
            @Qualifier(SALIDA_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}