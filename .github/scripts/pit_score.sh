#!/bin/bash

set -x  # Habilita el modo de depuración

for MODULE in domain infrastructure application; do
    echo "Procesando módulo: $MODULE"
    PIT_REPORT=$(find ./$MODULE/target/pit-reports -name "index.html" | sort -r | head -n 1)
    echo "Informe encontrado: $PIT_REPORT"

    if [ -f "$PIT_REPORT" ]; then
        echo "Buscando 'Mutation Coverage':"
        grep "Mutation Coverage" "$PIT_REPORT"

        echo "Intentando extraer el porcentaje de Mutation Coverage:"
        MUTATION_SCORE=$(sed -n '/<h3>Project Summary<\/h3>/,/<\/tbody>/p' "$PIT_REPORT" |
                         grep -oP '<td>(\d+)%.*?Mutation Coverage' |
                         grep -oP '\d+' |
                         head -n1)

        echo "MUTATION_SCORE extraído: $MUTATION_SCORE"

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