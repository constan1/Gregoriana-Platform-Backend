package com.RequestService.Request.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class RequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestServiceApplication.class, args);
	}

}
