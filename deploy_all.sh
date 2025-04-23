#!/usr/bin/env bash
cd /mnt/c/Users/giorg/Desktop/devops-midterm

# 1. Provision prerequisites & folders
ansible-playbook deploy/ansible/setup.yml

# 2. Build & style-check
mvn clean package checkstyle:check

# 3. Copy to green via Terraform
cd deploy/terraform && terraform init && terraform apply -auto-approve
cd ..

# 4. Switch, start, and health-monitor
bash switch.sh
bash start_app.sh

# 5. One‐off health check
bash health_check.sh

# 6. Show dashboard
bash dashboard.sh


echo ">>> Deploy_all complete."






