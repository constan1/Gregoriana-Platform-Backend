//package com.MobileGateway.MobileGateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringCloudConfig {
//
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//        return builder.routes().route(r -> r.path("/v1/user/transporter/**")
//                .filters(f -> f.addRequestParameter())
//                .uri("")
//    }
//}
