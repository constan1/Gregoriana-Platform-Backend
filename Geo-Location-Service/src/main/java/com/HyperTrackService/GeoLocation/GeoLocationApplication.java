package com.HyperTrackService.GeoLocation;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableFeignClients
@RestController
@RequiredArgsConstructor
public class GeoLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoLocationApplication.class, args);
	}


}
