package com.example.batch.application.configuration;

public final class Constants {

    private Constants() { }

    public static final String HIBERNATE_HBM_2_DDL_AUTO = "hibernate.hbm2ddl.auto";

    public static final String UPDATE = "update";

    public static final String HIBERNATE_DIALECT = "hibernate.dialect";

    public static final String POSTGRES_SQL_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";

    public static final String BATCH_JOB = "batchJob";

    public static final String BATCH_STEP = "batchStep";

    public static final String BASE_PACKAGE = "com.example.batch";

    public static final String SPRING_DATASOURCE = "spring.datasource";

    public static final String BATCH_TRANSACTION_MANAGER = "batchTransactionManager";

    public static final String ENTRADA = "entrada";

    public static final String ENTRADA_DATASOURCE = "entrada.datasource";

    public static final String ENTRADA_DATA_SOURCE = "entradaDataSource";

    public static final String ENTRADA_ENTITY_MANAGER_FACTORY = "entradaEntityManagerFactory";

    public static final String ENTRADA_TRANSACTION_MANAGER = "entradaTransactionManager";

    public static final String ENTRADA_ENTITY_PACKAGE = "com.example.batch.infrastructure.entity.entrada";

    public static final String ENTRADA_REPOSITORY_PACKAGE = "com.example.batch.infrastructure.repository.entrada";

    public static final String SALIDA = "salida";

    public static final String SALIDA_DATASOURCE = "salida.datasource";

    public static final String SALIDA_DATA_SOURCE = "salidaDataSource";

    public static final String SALIDA_ENTITY_MANAGER_FACTORY = "salidaEntityManagerFactory";

    public static final String SALIDA_TRANSACTION_MANAGER = "salidaTransactionManager";

    public static final String SALIDA_ENTITY_PACKAGE = "com.example.batch.infrastructure.entity.salida";

    public static final String SALIDA_REPOSITORY_PACKAGE = "com.example.batch.infrastructure.repository.salida";
}
