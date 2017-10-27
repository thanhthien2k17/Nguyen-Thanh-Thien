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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author phong
 */
public class HashUtils {
    public String md5(String pass) {
        byte[] hash;
        String temp = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(pass.getBytes("UTF8"));
            temp = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException ex) {
            return temp;
        } catch (UnsupportedEncodingException ex) {
            return temp;
        }
        return temp;    
    }
    
    public String encryptBlowfish(String to_encrypt, String strkey) {
        try {
            SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
            Cipher cipher =Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(to_encrypt.getBytes("UTF8")));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String decryptBlowfish(String to_decrypt, String strkey) {
        try {
            SecretKeySpec key = new SecretKeySpec(strkey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(to_decrypt));
            return new String(decrypted);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(HashUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
