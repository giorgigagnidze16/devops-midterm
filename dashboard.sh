#!/usr/bin/env bash
cd /mnt/c/Users/giorg/Desktop/devops-midterm
echo "🚦 Current environment → $(readlink production)"
echo "🕒 Last health checks:"
tail -n5 logs/healthcheck.log
echo ""
echo "📜 Last deploy actions:"
tail -n5 logs/deploy.log
