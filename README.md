# DevOps Midterm: Local CI/CD Simulation

## Project Description
This repository demonstrates a fully local DevOps pipeline for a Spring Boot web application. Application is a simple Spring Boot Web application, running at http://localhost:8080/tasks, with a single HTML form which saves "tasks" from users in an Array, tasks are lost if the application crashes or restarts, since it is only stored in-memory. Repository shows how to build, test, style-check, deploy, monitor, 
and rollback—all on local Windows machine (via WSL2)—using:
- **GitHub Actions** for CI  
- **Terraform** & **Ansible** for Infrastructure-as-Code (IaC)  
- **Blue-Green** simulated folder-based deployment  
- **Actuator** health checks with auto-rollback  
- A simple **dashboard** to visualize health status  

## Tools & Technologies
- **Java 21** & **Spring Boot**, JUnit, Spring Boot Starter Test  
- **Maven** (build, tests, Checkstyle)  
- **Git** & **GitHub Actions** (CI pipeline)  
- **Terraform** (artifact “deployment” to Blue/Green folders)  
- **Ansible** (host provisioning: Java/Maven install, folder setup)  
- **Bash** scripts (`switch.sh`, `rollback.sh`, `health_check.sh`, etc.)  
- **WSL2/Ubuntu** on Windows  
- Can add also **cron** / **Windows Task Scheduler** for automated health checks, or use Grafana or some other monitoring tool

## CI/CD & IaC Overview
1. **CI with GitHub Actions**  
   - Triggers on push or PR to `main` & `dev`  
   - Steps: checkout → setup Java → cache Maven → `mvn clean package checkstyle:check` → upload JAR  
2. **IaC Provisioning**  
   - **Ansible**: installs Java/Maven, creates `blue/`, `green/`, `production/`, `logs/` folders  
   - **Terraform**: reads the built JAR and writes it into the standby folder (`green/app.jar` or `blue/app.jar`)  
3. **Blue-Green Deployment**  
   - **`switch.sh`** copies the new JAR into the standby folder, then repoints `production/` (symlink or copy)  
   - **`start_app.sh`** kills old java process and launches `production/app.jar` in background  
4. **Health Checks & Auto-Rollback**  
   - **`health_check.sh`** polls `http://localhost:8080/actuator/health` manually, can be automated with cron jobs
   - Logs results to `logs/healthcheck.log`  
   - If status ≠ `UP`, invokes `rollback.sh` + `start_app.sh` to revert to the previous version  
5. **Dashboard**  
   - Simple HTML+Chart.js page (`dashboard.html`) that reads `logs/healthcheck.log`  
   - Polls every 5 seconds to update chart (UP=1, DOWN=0) and log table

## Diagram Of The WorkFlow
![image](https://github.com/user-attachments/assets/2b6d79cd-5236-403d-86df-5a94dd150346)

## Other  Screenshots   
App
![image](https://github.com/user-attachments/assets/ee4b7622-2f01-44fa-b829-6237f46442d0)
Sample Dummy Dashboard
![image](https://github.com/user-attachments/assets/b92498ad-3af8-404d-bf7f-1784c0785eaf)


