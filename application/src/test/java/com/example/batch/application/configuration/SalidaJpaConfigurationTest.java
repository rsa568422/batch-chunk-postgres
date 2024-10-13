package com.example.batch.application.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

import java.util.Map;

import static com.example.batch.application.configuration.Constants.HIBERNATE_DIALECT;
import static com.example.batch.application.configuration.Constants.HIBERNATE_HBM_2_DDL_AUTO;
import static com.example.batch.application.configuration.Constants.POSTGRES_SQL_DIALECT;
import static com.example.batch.application.configuration.Constants.SALIDA;
import static com.example.batch.application.configuration.Constants.SALIDA_ENTITY_PACKAGE;
import static com.example.batch.application.configuration.Constants.UPDATE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class SalidaJpaConfigurationTest {

    private final SalidaJpaConfiguration salidaJpaConfiguration = new SalidaJpaConfiguration();

    @Test
    void salidaEntityManagerFactory() {
        // given
        var entityManagerFactoryBuilder = Mockito.mock(EntityManagerFactoryBuilder.class);
        var builder = Mockito.mock(EntityManagerFactoryBuilder.Builder.class);
        var dataSource = Mockito.mock(DataSource.class);
        var properties = Map.of(HIBERNATE_HBM_2_DDL_AUTO, UPDATE, HIBERNATE_DIALECT, POSTGRES_SQL_DIALECT);
        var expected = Mockito.mock(LocalContainerEntityManagerFactoryBean.class);

        when(entityManagerFactoryBuilder.dataSource(dataSource)).thenReturn(builder);
        when(builder.packages(SALIDA_ENTITY_PACKAGE)).thenReturn(builder);
        when(builder.persistenceUnit(SALIDA)).thenReturn(builder);
        when(builder.properties(properties)).thenReturn(builder);
        when(builder.build()).thenReturn(expected);

        // when
        var actual = salidaJpaConfiguration.salidaEntityManagerFactory(entityManagerFactoryBuilder, dataSource);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertSame(expected, actual)
        );

        verify(entityManagerFactoryBuilder, times(1)).dataSource(dataSource);
        verify(builder, times(1)).packages(SALIDA_ENTITY_PACKAGE);
        verify(builder, times(1)).persistenceUnit(SALIDA);
        verify(builder, times(1)).properties(properties);
        verify(builder, times(1)).build();
        verifyNoMoreInteractions(entityManagerFactoryBuilder, builder);
    }

    @Test
    void salidaTransactionManager() {
        // given
        var entityManagerFactory = Mockito.mock(EntityManagerFactory.class);

        // when
        var actual = salidaJpaConfiguration.salidaTransactionManager(entityManagerFactory);

        // then
        assertNotNull(actual);
    }
}