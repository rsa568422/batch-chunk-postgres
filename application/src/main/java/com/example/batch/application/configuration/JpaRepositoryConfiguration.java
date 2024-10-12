package com.example.batch.application.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

@Configuration
public abstract class JpaRepositoryConfiguration {

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.example.batch.infrastructure.repository.entrada",
            entityManagerFactoryRef = "entradaEntityManagerFactory",
            transactionManagerRef = "entradaTransactionManager"
    )
    public static class EntradaJpaConfig {

        @Bean
        public LocalContainerEntityManagerFactoryBean entradaEntityManagerFactory(
                EntityManagerFactoryBuilder builder,
                @Qualifier("entradaDataSource") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.example.batch.infrastructure.entity.entrada")
                    .persistenceUnit("entrada")
                    .build();
        }

        @Bean
        public PlatformTransactionManager entradaTransactionManager(
                @Qualifier("entradaEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "com.example.batch.infrastructure.repository.salida",
            entityManagerFactoryRef = "salidaEntityManagerFactory",
            transactionManagerRef = "salidaTransactionManager"
    )
    public static class SalidaJpaConfig {

        @Bean
        public LocalContainerEntityManagerFactoryBean salidaEntityManagerFactory(
                EntityManagerFactoryBuilder builder,
                @Qualifier("salidaDataSource") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.example.batch.infrastructure.entity.salida")
                    .persistenceUnit("salida")
                    .build();
        }

        @Bean
        public PlatformTransactionManager salidaTransactionManager(
                @Qualifier("salidaEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
    }
}