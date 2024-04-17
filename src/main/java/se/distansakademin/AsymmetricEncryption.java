package se.distansakademin;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class AsymmetricEncryption {

    public static void main(String[] args) throws Exception {

        var secret = "Attackera ingen, vi är fredliga varelser!";

        var pair = getKeyPair();

        var encrypted = encryptText(secret, pair.getPublic());

        System.out.println(encrypted);

        var result = decryptText(encrypted, pair.getPrivate());

        System.out.println(result);
    }

    private static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        var keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        var keyPair = keyGen.generateKeyPair();
        return keyPair;
    }

    private static String encryptText(String secret, PublicKey publicKey) throws Exception{
        var cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        var encryptedBytes = cipher.doFinal(secret.getBytes());
        var encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        return encryptedText;
    }

    private static String decryptText(String encryptedText, PrivateKey privateKey) throws Exception{
        var cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        var encryptedBytes = Base64.getDecoder().decode(encryptedText);
        var decryptedBytes = cipher.doFinal(encryptedBytes);
        var decryptedText = new String(decryptedBytes);

        return decryptedText;
    }
}
