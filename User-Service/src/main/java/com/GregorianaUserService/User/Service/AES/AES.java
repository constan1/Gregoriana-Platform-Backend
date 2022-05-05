package com.GregorianaUserService.User.Service.AES;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AES {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue= "7566355151371252".getBytes();

    public static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue,ALGORITHM);
    }

    public static String encrypt(String valueToEnc, Key key) throws Exception{

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
        byte[] encryptedByteValue = new Base64().encode(encValue);

        return new String(encryptedByteValue);
    }

    public static String decrypt(String encryptedValue, Key key) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());

        byte[] enctVal = cipher.doFinal(decodedBytes);

        return new String(enctVal);
    }

}
