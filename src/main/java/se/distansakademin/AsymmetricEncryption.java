package se.distansakademin;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class AsymmetricEncryption {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        var pair = getKeyPair();
        System.out.println(pair.getPrivate().toString());
        System.out.println("---");
        System.out.println(pair.getPublic().toString());

    }

    private static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        var keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        var keyPair = keyGen.generateKeyPair();
        return keyPair;
    }
}
