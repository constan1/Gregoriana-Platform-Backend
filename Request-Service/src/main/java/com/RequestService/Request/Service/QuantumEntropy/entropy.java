package com.RequestService.Request.Service.QuantumEntropy;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class entropy {

    private static String trackingNumber;

    public static String getEntropy_(){

        trackingNumber = new SecureRandom().ints(0,36)
                .mapToObj(i -> Integer.toString(i,36))
                .map(String::toUpperCase).distinct().limit(16).collect(Collectors.joining())
                .replaceAll("([A-Z0-9]{4})", "$1-").substring(0,19);

        return trackingNumber;

    }
}
