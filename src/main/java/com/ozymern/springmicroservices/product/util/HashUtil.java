package com.ozymern.springmicroservices.product.util;

import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashUtil {


    public static String  generateHash(String originalString){
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        byte[] hash = digest.digest(
            originalString.getBytes(StandardCharsets.UTF_8));
         String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }
}
