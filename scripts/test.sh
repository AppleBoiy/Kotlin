#!/usr/bin/env bash
gradle test
EXIT_CODE=$?

if [ $EXIT_CODE -ne 0 ]; then
  exit 1
else
  exit 0
fi
