package com.humc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouterLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_humc", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_humc1", r -> r.path("/guowai").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
