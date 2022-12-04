package com.HyperTrackService.GeoLocation.config;


import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;


public class FeignClientConfig {


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("-O_VuCQrT653Q694az28oaBv-6A","qP8key6iMoW0_B--mmQp0Z7-Atd_s7Qfra0IxaQWkQti3Im6NwvO4A");
    }


}
