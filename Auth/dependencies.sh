#!/usr/bin/env bash

set -e

docker network create sinlog || true
docker-compose -f docker-compose.data.yml up -d --build