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

echo "Resumen de PIT Mutation Testing (Java 17):"
echo "--------------------------------"
grep -A 7 "<tbody>" "$INDEX_HTML" | tail -n 4 | sed 's/<[^>]*>//g' | sed 's/^ *//g'
echo ""
echo "Para ver el informe completo, descarga el artefacto 'pit-reports' de esta ejecución del workflow y abre el archivo index.html en tu navegador."