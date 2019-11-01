package com.glodon.easyshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;

/**
 * @Author: fanwd
 * @Description: 网关
 * @Date: Create in 23:59 2019/10/11
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @Autowired
//    private TokenRelayGatewayFilterFactory filterFactory;
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("resource", r -> r.path("/resource")
//                        .filters(f -> f.filter(filterFactory.apply()))
//                        .uri("http://localhost:9000"))
//                .build();
//    }
}
