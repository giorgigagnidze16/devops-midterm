#!/usr/bin/env bash
cd /mnt/c/Users/giorg/Desktop/devops-midterm
# kill old
pkill -f 'java -jar production/app.jar' || true
# start new
nohup java -jar production/app.jar > logs/app.log 2>&1 &
echo "$(date): app started from $(readlink production)" >> logs/deploy.log
