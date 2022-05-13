package com.RequestService.Request.Service.QuantumEntropy;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RequestReferenceHash {


    public static String createMD5Hash(final String input)
        throws NoSuchAlgorithmException{

        String hashtext= null;

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        hashtext = convertToHex(messageDigest);

        return hashtext;
    }

    private static  String convertToHex(final byte[] messageDigest){
        BigInteger bigint = new BigInteger(1, messageDigest);

        String hashText = bigint.toString(16);
        while (hashText.length() < 32 ){
            hashText = "0".concat(hashText);
        }
        return hashText;
    }
}
