package com.AddressService.AddressService.AES;

import com.AddressService.AddressService.config.vaultConfiguration;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;

public class PBK2 {


    private static final String password = vaultConfiguration.getPassword();

    public static String encrypt (String message) throws Exception{

        byte[] ivBytes;


        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), bytes,65556,256);
        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(),"AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);

        AlgorithmParameters params = cipher.getParameters();
        ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();

        byte[] encryptedTextBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));


        byte[] buffer = new byte[bytes.length + ivBytes.length + encryptedTextBytes.length];

        System.arraycopy(bytes, 0, buffer, 0, bytes.length);
        System.arraycopy(ivBytes,0,buffer,bytes.length,ivBytes.length);
        System.arraycopy(encryptedTextBytes,0,buffer,bytes.length + ivBytes.length, encryptedTextBytes.length);


        return new Base64().encodeToString(buffer);

    }

    public static String decrypt (String encryptedText) throws Exception{

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        ByteBuffer buffer = ByteBuffer.wrap(new Base64().decode(encryptedText));

        byte[] saltBytes = new byte[20];
        buffer.get(saltBytes,0,saltBytes.length);
        byte[] ivBytes1 = new byte[cipher.getBlockSize()];
        buffer.get(ivBytes1, 0,ivBytes1.length);
        byte[] encryptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes1.length];

        buffer.get(encryptedTextBytes);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),saltBytes, 65556, 256);

        SecretKey secretKey = factory.generateSecret(spec);
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        cipher.init(Cipher.DECRYPT_MODE, secret,new IvParameterSpec(ivBytes1));


        byte[] decryptedTextBytes = null;

        try {

            decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
        }catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        assert decryptedTextBytes != null;
        return new String(decryptedTextBytes);
    }

}
