variable "ecr_repo_url" {}
variable "db_endpoint" {}
variable "subnets" {}
variable "ec2_sg_id" {}
variable "vpc_id" {
  description = "The default VPC ID"
  type        = string
}

