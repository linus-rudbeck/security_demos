package se.distansakademin;

public class SymmetricEncryption {

    // abcdefghijklmnopqrstuvwxyz

    // Secret: linus
    // Key: 2
    // Cipher: nkpwu

    // Secret: zelda
    // Key: 2
    // Cipher: bgnfc

    // Secret: yxa
    // Key: 2
    // Cipher: azc


    public static void main(String[] args) {
        var secret = "attackera basen norr om london klockan tolv";
        var key = 100;

        var encrypted = encryptMessage(secret, key);
        System.out.println(encrypted); // azc

        var decryptedSecret = decryptMessage(encrypted, key);
        System.out.println(decryptedSecret);
    }

    public static String encryptMessage(String secret, int key) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < secret.length(); i++) {
            var asciiDecimal = (secret.charAt(i) + key);

            if (asciiDecimal > 122) {
                asciiDecimal -= 26;
            }

            var encryptedChar = (char) asciiDecimal;

            sb.append(encryptedChar);
        }

        return sb.toString();
    }

    public static String decryptMessage(String encrypted, int key) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < encrypted.length(); i++) {
            var asciiDecimal = encrypted.charAt(i) - key;

            if (asciiDecimal < 97) {
                asciiDecimal += 26;
            }

            var decryptedChar = (char) asciiDecimal;

            sb.append(decryptedChar);
        }

        return sb.toString();
    }
}
