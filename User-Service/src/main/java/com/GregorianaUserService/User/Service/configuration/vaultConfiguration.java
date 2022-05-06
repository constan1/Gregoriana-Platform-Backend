package com.GregorianaUserService.User.Service.configuration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.vault.config.EnvironmentVaultConfiguration;


@ConfigurationProperties(prefix = "vault")
public class vaultConfiguration {

    private static String keyValue;

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public static  String getKeyValue() {
        return keyValue;
    }
}
