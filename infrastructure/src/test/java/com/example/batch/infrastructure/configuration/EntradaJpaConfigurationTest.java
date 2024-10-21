package com.example.batch.infrastructure.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Map;

import static com.example.batch.infrastructure.configuration.Constants.ENTRADA;
import static com.example.batch.infrastructure.configuration.Constants.ENTRADA_ENTITY_PACKAGE;
import static com.example.batch.infrastructure.configuration.Constants.HIBERNATE_DIALECT;
import static com.example.batch.infrastructure.configuration.Constants.HIBERNATE_HBM_2_DDL_AUTO;
import static com.example.batch.infrastructure.configuration.Constants.POSTGRES_SQL_DIALECT;
import static com.example.batch.infrastructure.configuration.Constants.UPDATE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class EntradaJpaConfigurationTest {

    private final EntradaJpaConfiguration entradaJpaConfiguration = new EntradaJpaConfiguration();

    @Test
    void entradaDataSource() {
        // when
        var actual = entradaJpaConfiguration.entradaDataSource();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertInstanceOf(DataSource.class, actual)
        );
    }

    @Test
    void entradaEntityManagerFactory() {
        // given
        var entityManagerFactoryBuilder = Mockito.mock(EntityManagerFactoryBuilder.class);
        var builder = Mockito.mock(EntityManagerFactoryBuilder.Builder.class);
        var dataSource = Mockito.mock(DataSource.class);
        var properties = Map.of(HIBERNATE_HBM_2_DDL_AUTO, UPDATE, HIBERNATE_DIALECT, POSTGRES_SQL_DIALECT);
        var expected = Mockito.mock(LocalContainerEntityManagerFactoryBean.class);

        when(entityManagerFactoryBuilder.dataSource(dataSource)).thenReturn(builder);
        when(builder.packages(ENTRADA_ENTITY_PACKAGE)).thenReturn(builder);
        when(builder.persistenceUnit(ENTRADA)).thenReturn(builder);
        when(builder.properties(properties)).thenReturn(builder);
        when(builder.build()).thenReturn(expected);

        // when
        var actual = entradaJpaConfiguration.entradaEntityManagerFactory(entityManagerFactoryBuilder, dataSource);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertSame(expected, actual)
        );

        verify(entityManagerFactoryBuilder, times(1)).dataSource(dataSource);
        verify(builder, times(1)).packages(ENTRADA_ENTITY_PACKAGE);
        verify(builder, times(1)).persistenceUnit(ENTRADA);
        verify(builder, times(1)).properties(properties);
        verify(builder, times(1)).build();
        verifyNoMoreInteractions(entityManagerFactoryBuilder, builder);
    }

    @Test
    void entradaTransactionManager() {
        // given
        var entityManagerFactory = Mockito.mock(EntityManagerFactory.class);

        // when
        var actual = entradaJpaConfiguration.entradaTransactionManager(entityManagerFactory);

        // then
        assertNotNull(actual);
    }
}