# <span style="color: green;" >Spring Batch</span>

Este proyecto muestra un ejemplo de proceso spring batch con tres bases de datos, una para las tablas del proceso batch,
otra para los datos de entrada y una última para los datos de salida

___

## <span style="color: green; ">Docker Compose</span>

Antes de ejecutar el proceso se requiere levantar las tres bases de datos requeridas:
```bash
docker-compose up -d
```

Una vez finalizada la ejecución podemos apagar las tres bases de datos:
```bash
docker compose down
```
___

## <span style="color: green; ">Variables de entorno</span>

Variables de entorno requeridas para la ejecución:

| Variable                   | Valor                                    |
|----------------------------|------------------------------------------|
| SPRING_DATASOURCE_USERNAME | root                                     |
| SPRING_DATASOURCE_PASSWORD | root                                     |
| SPRING_DATASOURCE_URL      | jdbc:postgresql://localhost:5432/batch   |
| ENTRADA_DATASOURCE_URL     | jdbc:postgresql://localhost:5433/entrada |
| SALIDA_DATASOURCE_URL      | jdbc:postgresql://localhost:5434/salida  |

___

## <span style="color: green;">Informe PIT</span>

Comando para compilar el proyecto:

```bash
mvn clean install
```

Comando para generar el informe de PIT:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```
