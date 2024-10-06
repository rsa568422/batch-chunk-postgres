#!/bin/bash

set -e  # Detiene la ejecución si hay algún error

TOTAL_MUTATIONS=0
KILLED_MUTATIONS=0

for MODULE in domain infrastructure application; do
    PIT_REPORT=$(find ./$MODULE/target/pit-reports -name "index.html" | sort -r | head -n 1)

    if [ -f "$PIT_REPORT" ]; then
        MUTATION_SCORE=$(sed -n '/<h3>Project Summary<\/h3>/,/<\/tbody>/p' "$PIT_REPORT" |
                         grep -oP '<td>\K\d+(?=% <div class="coverage_bar">)' |
                         sed -n '3p')

        MUTATIONS=$(sed -n '/<h3>Project Summary<\/h3>/,/<\/tbody>/p' "$PIT_REPORT" |
                    grep -oP '<div class="coverage_legend">\K\d+/\d+(?=</div>)' |
                    sed -n '3p')

        KILLED=$(echo $MUTATIONS | cut -d'/' -f1)
        TOTAL=$(echo $MUTATIONS | cut -d'/' -f2)

        echo "$MODULE - Porcentaje de mutantes eliminados: $MUTATION_SCORE%"

        TOTAL_MUTATIONS=$((TOTAL_MUTATIONS + TOTAL))
        KILLED_MUTATIONS=$((KILLED_MUTATIONS + KILLED))
    else
        echo "No se encontró el informe de PIT para $MODULE"
    fi
done

if [ $TOTAL_MUTATIONS -gt 0 ]; then
    TOTAL_PERCENTAGE=$(echo "scale=2; $KILLED_MUTATIONS * 100 / $TOTAL_MUTATIONS" | bc)
    echo "Porcentaje total de mutantes eliminados: $TOTAL_PERCENTAGE%"

    if (( $(echo "$TOTAL_PERCENTAGE < 50" | bc -l) )); then
        echo "El porcentaje de mutantes eliminados es menor al 50%."
        exit 1
    fi
else
    echo "No se encontraron mutaciones para calcular el porcentaje total"
    exit 1
fi