package com.GregorianaUserService.User.Service;

import com.GregorianaUserService.User.Service.configuration.vaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableConfigurationProperties(vaultConfiguration.class)
@EnableCaching
//@EnableEurekaClient
public class UserServiceApplication{


	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

}
