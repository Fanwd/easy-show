package com.glodon.easyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
