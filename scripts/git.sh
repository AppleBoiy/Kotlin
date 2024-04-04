#!/usr/bin/env bash

case $1 in
  pull)
    git pull origin master 2>&1 || echo "Pull failed"

    ;;
  *)
    echo "Unknown command"
    ;;
esac
