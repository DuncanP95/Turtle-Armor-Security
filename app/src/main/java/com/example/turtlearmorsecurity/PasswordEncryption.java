package com.example.turtlearmorsecurity;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class PasswordEncryption {

    private static final String AES_ALGORITHM = "AES";
    private static final String AES_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String SECRET_KEY = "your_secret_key_here";

    public static String encrypt(String password) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[]
                    encryptedBytes = cipher.doFinal(password.getBytes());
            return
                    Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e)
        {

            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedPassword) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[]
                    decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
            return new
                    String(decryptedBytes);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}