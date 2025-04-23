#!/usr/bin/env bash
cd /mnt/c/Users/giorg/Desktop/devops-midterm
# reverse link
if [ "$(readlink production)" = "green" ]; then
  ln -sfn blue production
  echo "$(date): rolled back → BLUE"  >> logs/deploy.log
else
  ln -sfn green production
  echo "$(date): rolled back → GREEN" >> logs/deploy.log
fi
