output "ecs_cluster_id" {
  value = aws_ecs_cluster.app_cluster.id
}

output "ecs_service_name" {
  value = aws_ecs_service.app_service.name
}

output "alb_dns_name" {
  value = aws_lb.app_alb.dns_name
}
