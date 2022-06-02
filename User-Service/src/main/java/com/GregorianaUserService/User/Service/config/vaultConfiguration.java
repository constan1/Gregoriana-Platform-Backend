package com.GregorianaUserService.User.Service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "encryp")
public class vaultConfiguration {

    private static String ePassword;

    public void setKeyValue(String keyValue) {
        vaultConfiguration.ePassword = keyValue;
    }

    public static  String getKeyValue() {
        return ePassword;
    }
}
