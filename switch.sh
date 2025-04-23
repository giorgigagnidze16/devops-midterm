#!/usr/bin/env bash
ROOT="/mnt/c/Users/giorg/Desktop/devops-midterm"
LOG="$ROOT/logs/deploy.log"

cd "$ROOT"

# 1) Remove any existing production directory or link
rm -rf production

# 2) Decide which color is standby
if [ "$(readlink blue)" ] && [ ! -e green/app.jar ]; then
  STANDBY=blue
  NEXT=BLUE
else
  STANDBY=green
  NEXT=GREEN
fi

# 3) Copy the new JAR into standby (optional—if Terraform didn’t already)
cp target/*.jar "$ROOT/$STANDBY/app.jar"

# 4) Create the symlink
ln -s "$STANDBY" production

# 5) Log it
echo "$(date): deployed to $STANDBY & switched → $NEXT" >> "$LOG"
