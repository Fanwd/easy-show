package com.glodon.easyshow.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fanwd
 * @Description:
 * @Date: Create in 21:06 2019/10/13
 */
@Configuration
public class DynamicRouteConfig {

    public RouteLocator dynamicServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route-service", predicateSpec -> {
                    return predicateSpec.path("/api")
                            .uri("");
                }).build();

    }

}
