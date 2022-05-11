package com.GregorianaUserService.User.Service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vault")
public class vaultConfiguration {

    private static String keyValue;

    public void setKeyValue(String keyValue) {
        vaultConfiguration.keyValue = keyValue;
    }

    public static  String getKeyValue() {
        return keyValue;
    }
}
