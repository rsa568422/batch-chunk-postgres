#!/bin/bash

for MODULE in domain infrastructure application; do
    PIT_REPORT=$(find ./$MODULE/target/pit-reports -name "index.html" | sort -r | head -n 1)
    if [ -f "$PIT_REPORT" ]; then
        MUTATION_SCORE=$(grep -oP '<td>(\d+(?:\.\d+)?)%</td>' "$PIT_REPORT" | head -n 2 | tail -n 1 | grep -oP '\d+(?:\.\d+)?')
        if [ -n "$MUTATION_SCORE" ]; then
            echo "$MODULE - Porcentaje de mutantes eliminados: $MUTATION_SCORE%"
        else
            echo "No se pudo extraer el porcentaje de mutantes eliminados para $MODULE"
            echo "Contenido relevante del informe:"
            sed -n '/<h3>Project Summary<\/h3>/,/<\/tbody>/p' "$PIT_REPORT"
        fi
    else
        echo "No se encontró el informe de PIT para $MODULE"
        ls -R ./$MODULE/target/pit-reports
    fi
done