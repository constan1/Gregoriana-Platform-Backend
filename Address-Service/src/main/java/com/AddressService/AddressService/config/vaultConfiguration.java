package com.AddressService.AddressService.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "encryp")
public class vaultConfiguration {

    private static String ePassword;

    public void setPassword(String password) {
        vaultConfiguration.ePassword = password;
    }

    public static  String getPassword() {
        return ePassword;
    }


}
