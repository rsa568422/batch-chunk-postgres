#!/bin/bash

REPORT_DIR="target/pit-reports"
echo "Buscando informes en: $REPORT_DIR"

if [ ! -d "$REPORT_DIR" ]; then
    echo "No se encontró el directorio de informes de PIT: $REPORT_DIR"
    exit 1
fi

INDEX_HTML="$REPORT_DIR/index.html"
if [ ! -f "$INDEX_HTML" ]; then
    echo "No se encontró el archivo index.html en $REPORT_DIR"
    echo "Contenido del directorio $REPORT_DIR:"
    ls -R "$REPORT_DIR"
    exit 1
fi

# Extraer estadísticas del informe
MUTATIONS_TOTAL=$(grep -oP 'Number of mutations:\s*\K\d+' "$INDEX_HTML" || echo "N/A")
MUTATIONS_KILLED=$(grep -oP 'Mutations killed:\s*\K\d+' "$INDEX_HTML" || echo "N/A")
MUTATIONS_SURVIVED=$(grep -oP 'Mutations survived:\s*\K\d+' "$INDEX_HTML" || echo "N/A")
LINE_COVERAGE=$(grep -oP 'Line Coverage:\s*\K[\d.]+%' "$INDEX_HTML" || echo "N/A")
MUTATION_COVERAGE=$(grep -oP 'Mutation Coverage:\s*\K[\d.]+%' "$INDEX_HTML" || echo "N/A")

echo "Resumen de PIT Mutation Testing (Java 17):"
echo "--------------------------------"
echo "Cobertura de líneas: $LINE_COVERAGE"
echo "Cobertura de mutaciones: $MUTATION_COVERAGE"
echo "Total de mutaciones: $MUTATIONS_TOTAL"
echo "Mutaciones eliminadas: $MUTATIONS_KILLED"
echo "Mutaciones sobrevividas: $MUTATIONS_SURVIVED"
echo ""
echo "El informe detallado de PIT está disponible en: $GITHUB_SERVER_URL/$GITHUB_REPOSITORY/actions/runs/$GITHUB_RUN_ID"