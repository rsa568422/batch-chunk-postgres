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

import static com.example.batch.application.configuration.Constants.ENTRADA;
import static com.example.batch.application.configuration.Constants.ENTRADA_DATA_SOURCE;
import static com.example.batch.application.configuration.Constants.ENTRADA_ENTITY_MANAGER_FACTORY;
import static com.example.batch.application.configuration.Constants.ENTRADA_ENTITY_PACKAGE;
import static com.example.batch.application.configuration.Constants.ENTRADA_REPOSITORY_PACKAGE;
import static com.example.batch.application.configuration.Constants.ENTRADA_TRANSACTION_MANAGER;

@Configuration
@EnableJpaRepositories(
        basePackages = ENTRADA_REPOSITORY_PACKAGE,
        entityManagerFactoryRef = ENTRADA_ENTITY_MANAGER_FACTORY,
        transactionManagerRef = ENTRADA_TRANSACTION_MANAGER
)
public class EntradaJpaConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entradaEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier(ENTRADA_DATA_SOURCE) DataSource dataSource) {
        return builder.dataSource(dataSource).packages(ENTRADA_ENTITY_PACKAGE).persistenceUnit(ENTRADA).build();
    }

    @Bean
    public PlatformTransactionManager entradaTransactionManager(@Qualifier(ENTRADA_ENTITY_MANAGER_FACTORY)
                                                                    EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
