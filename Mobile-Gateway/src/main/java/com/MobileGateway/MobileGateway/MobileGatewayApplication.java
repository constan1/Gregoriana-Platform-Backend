package com.MobileGateway.MobileGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileGatewayApplication.class, args);
	}

}
