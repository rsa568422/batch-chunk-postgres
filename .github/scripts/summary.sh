#!/bin/bash

TOTAL_LINES=0
COVERED_LINES=0

for MODULE in domain infrastructure application; do
    REPORT_DIR="./$MODULE/target/pit-reports"
    echo "Buscando informes en: $REPORT_DIR"

    LATEST_REPORT=$(ls -t $REPORT_DIR 2>/dev/null | head -n1)
    echo "Último informe encontrado para $MODULE: $LATEST_REPORT"

    if [ -z "$LATEST_REPORT" ]; then
        echo "No se encontró el informe de PIT para $MODULE"
        continue
    fi

    REPORT_PATH="$REPORT_DIR/$LATEST_REPORT/index.html"
    if [ ! -f "$REPORT_PATH" ]; then
        echo "No se encontró el archivo index.html para $MODULE en $REPORT_PATH"
        continue
    fi

    # Extraer estadísticas del informe
    LINE_COVERAGE=$(grep -oP 'Line Coverage.*?(\d+)%' "$REPORT_PATH" | head -n 1 | awk '{print $NF}' | sed 's/%//')
    COVERAGE_LEGEND=$(grep -oP '<div class="coverage_legend">(\d+)/(\d+)</div>' "$REPORT_PATH" | head -n 1)
    COVERED_LINES_MODULE=$(echo "$COVERAGE_LEGEND" | grep -oP '(\d+)/' | sed 's/\///')
    TOTAL_LINES_MODULE=$(echo "$COVERAGE_LEGEND" | grep -oP '/(\d+)' | sed 's/\///')

    if [ -n "$LINE_COVERAGE" ] && [ -n "$TOTAL_LINES_MODULE" ] && [ -n "$COVERED_LINES_MODULE" ]; then
        TOTAL_LINES=$((TOTAL_LINES + TOTAL_LINES_MODULE))
        COVERED_LINES=$((COVERED_LINES + COVERED_LINES_MODULE))
        echo "$MODULE - Líneas totales: $TOTAL_LINES_MODULE, Líneas cubiertas: $COVERED_LINES_MODULE, Cobertura: $LINE_COVERAGE%"
    else
        echo "No se pudo extraer la información de cobertura para $MODULE"
        echo "Contenido del resumen del proyecto:"
        sed -n '/<h3>Project Summary<\/h3>/,/<\/tbody>/p' "$REPORT_PATH"
    fi
done

if [ $TOTAL_LINES -gt 0 ]; then
    COVERAGE=$(echo "scale=2; $COVERED_LINES * 100 / $TOTAL_LINES" | bc)
    echo "Cobertura de líneas total: $COVERAGE%"
    if (( $(echo "$COVERAGE < 80" | bc -l) )); then
        echo "La cobertura de líneas es menor al 80%."
        echo "Por favor, revisa tus pruebas y asegúrate de que cubran al menos el 80% de las líneas de código."
        echo "Cobertura actual: $COVERAGE%"
        echo "Cobertura requerida: 80%"
        exit 1
    fi
else
    echo "No se encontraron líneas para calcular la cobertura"
    exit 1
fi