package se.distansakademin;

import java.util.Scanner;

public class BruteForcer {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var encryptedMessage = "«¾¾«\u00ADµ¯¼«j¬«½¯¸j¸¹¼¼j¹·j¶¹¸®¹¸jµ¶¹\u00ADµ«¸j¾¹¶À";

        for (int i = 0; i < 500; i++) {
            var decryptedMessage = SymmetricEncryption.decryptMessage(encryptedMessage, i);
            System.out.println(i + ": " + decryptedMessage);
            scanner.nextLine();
        }
    }
}
