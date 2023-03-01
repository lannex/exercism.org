#!/bin/bash

rm -rf kotlin/**/build kotlin/**/.gradle

rm -rf rust/**/target rust/**/Cargo.lock

rm -rf .pytest_cache python/**/__pycache__

rm -rf typescript/**/node_modules typescript/**/yarn.lock
