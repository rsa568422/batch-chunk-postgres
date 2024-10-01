#!/bin/bash

REPORT_DIR="target/pit-reports"
LATEST_REPORT=$(ls -t $REPORT_DIR | head -n1)

if [ ! -d "$REPORT_DIR/$LATEST_REPORT" ]; then
    echo "No se encontró el informe de PIT. Asegúrate de haber ejecutado las pruebas de mutación."
    exit 1
fi

# Extraer estadísticas del informe
MUTATIONS_TOTAL=$(grep -oP 'Number of mutations:\s*\K\d+' "$REPORT_DIR/$LATEST_REPORT/index.html")
MUTATIONS_KILLED=$(grep -oP 'Mutations killed:\s*\K\d+' "$REPORT_DIR/$LATEST_REPORT/index.html")
MUTATIONS_SURVIVED=$(grep -oP 'Mutations survived:\s*\K\d+' "$REPORT_DIR/$LATEST_REPORT/index.html")
LINE_COVERAGE=$(grep -oP 'Line Coverage:\s*\K[\d.]+%' "$REPORT_DIR/$LATEST_REPORT/index.html")
MUTATION_COVERAGE=$(grep -oP 'Mutation Coverage:\s*\K[\d.]+%' "$REPORT_DIR/$LATEST_REPORT/index.html")

echo "Resumen de PIT Mutation Testing (Java 17):"
echo "--------------------------------"
echo "Cobertura de líneas: $LINE_COVERAGE"
echo "Cobertura de mutaciones: $MUTATION_COVERAGE"
echo "Total de mutaciones: $MUTATIONS_TOTAL"
echo "Mutaciones eliminadas: $MUTATIONS_KILLED"
echo "Mutaciones sobrevividas: $MUTATIONS_SURVIVED"
echo ""
echo "El informe detallado de PIT está disponible en: $GITHUB_SERVER_URL/$GITHUB_REPOSITORY/actions/runs/$GITHUB_RUN_ID"

# Verificar umbral de cobertura
MUTATION_COVERAGE_NUM=$(echo $MUTATION_COVERAGE | sed 's/%//')
if (( $(echo "$MUTATION_COVERAGE_NUM < 80" | bc -l) )); then
    echo "La cobertura de mutaciones es menor al 80%. Cobertura actual: $MUTATION_COVERAGE"
    exit 1
fi

exit 0