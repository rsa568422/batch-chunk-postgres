#!/bin/bash

TOTAL_LINES=0
COVERED_LINES=0

for MODULE in domain infrastructure application; do
    REPORT_DIR="./$MODULE/target/pit-reports"
    LATEST_REPORT=$(ls -t $REPORT_DIR 2>/dev/null | head -n1)
    REPORT_PATH="$REPORT_DIR/$LATEST_REPORT/index.html"

    if [ ! -f "$REPORT_PATH" ]; then
        continue
    fi

    COVERAGE_LEGEND=$(grep -oP '<div class="coverage_legend">(\d+)/(\d+)</div>' "$REPORT_PATH" | head -n 1)
    COVERED_LINES_MODULE=$(echo "$COVERAGE_LEGEND" | grep -oP '(\d+)/' | sed 's/\///')
    TOTAL_LINES_MODULE=$(echo "$COVERAGE_LEGEND" | grep -oP '/(\d+)' | sed 's/\///')

    if [ -n "$COVERED_LINES_MODULE" ] && [ -n "$TOTAL_LINES_MODULE" ]; then
        TOTAL_LINES=$((TOTAL_LINES + TOTAL_LINES_MODULE))
        COVERED_LINES=$((COVERED_LINES + COVERED_LINES_MODULE))
    fi
done

if [ $TOTAL_LINES -gt 0 ]; then
    COVERAGE=$(echo "scale=2; $COVERED_LINES * 100 / $TOTAL_LINES" | bc)
    echo "Cobertura de líneas total: $COVERAGE%"
    if (( $(echo "$COVERAGE < 80" | bc -l) )); then
        echo "$COVERAGE% < 80%"
        exit 1
    fi
else
    echo "No se encontraron líneas para calcular la cobertura"
    exit 1
fi