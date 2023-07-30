package com.zayver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

   /* @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/test/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/api/test/(?<segment>.*)", "/$\\{segment}"))
                        .uri("lb://test-service"))
                .route(p -> p
                        .path("/model1/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/model1/(?<segment>.*)", "/$\\{segment}"))
                        .uri("lb://model1-service")
                )
                .build();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }
}
