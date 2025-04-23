terraform {
  required_providers {
    local = { source = "hashicorp/local" }
  }
}

resource "local_file" "deploy_to_green" {
  content_base64 = filebase64("../../target/devops-midterm-0.0.1.jar")
  filename       = "../../green/app.jar"
}

resource "local_file" "deploy_to_blue" {
  content_base64  = filebase64("../../target/devops-midterm-0.0.1.jar")
  filename        = "../../blue/app.jar"
  file_permission = "0755"
}