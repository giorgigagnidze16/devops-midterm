#!/usr/bin/env bash
cd /mnt/c/Users/giorg/Desktop/devops-midterm
URL="http://localhost:8080/actuator/health"
LOG="./logs/healthcheck.log"

if curl -s $URL | grep -q '"UP"'; then
  echo "$(date): HEALTHY" >> $LOG
else
  echo "$(date): UNHEALTHY – rolling back" >> $LOG
  bash rollback.sh
  bash start_app.sh
fi
