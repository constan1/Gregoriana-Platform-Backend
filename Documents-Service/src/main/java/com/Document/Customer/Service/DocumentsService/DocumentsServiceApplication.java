package com.Document.Customer.Service.DocumentsService;

import com.Document.Customer.Service.DocumentsService.config.vaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableConfigurationProperties(vaultConfiguration.class)
@EnableEurekaClient
public class DocumentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentsServiceApplication.class, args);
	}

}
