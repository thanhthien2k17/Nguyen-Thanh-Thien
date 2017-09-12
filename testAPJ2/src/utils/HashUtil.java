/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author vtson
 */
public class HashUtil {

    public String hashmd5(String pass) {
        byte[] hash;
        String strTemp = "";
        try {
            //MD5 co keysize la: 16
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(pass.getBytes("UTF8"));
            strTemp = Base64.getEncoder().encodeToString(hash);
        } catch (java.security.NoSuchAlgorithmException | java.io.UnsupportedEncodingException ex) {
            return strTemp;
        }
        return strTemp;
    }

    public static String encryptBlowfish(String to_encrypt, String strkey) {
        try {
            SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(to_encrypt.getBytes("UTF8")));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }

    public static String decryptBlowfish(String to_decrypt, String strkey) {
        try {
            SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(to_decrypt));
            return new String(decrypted);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }
}
