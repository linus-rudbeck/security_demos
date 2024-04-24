package se.distansakademin.week2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;


// Klartext: password
// Hash: 5f4dcc3b5aa765d61d8327deb882cf99
// Salt: 3926016725
// Pass+Salt: password:3926016725
// Hash+Salt: 9817d9f418f02fe97a4d5a3367e30c2e:3926016725
// md5(password:3926016725) == 9817d9f418f02fe97a4d5a3367e30c2e

// Klartext: pass
// Hash+Salt: 0c5ba88a1b8a2b5dc6568d981789065f:9579809359
// Test: pass
// md5(pass:9579809359): 0c5ba88a1b8a2b5dc6568d981789065f

public class PasswordDemos {

    // 12345 % 10 => 5
    // 25 % 10 => 5
    // 15 % 10 => 5

    // 12345 => 1+2+3+4+5 => 15
    // 15 => 1+5 => 6
    // 25 => 2+5 => 7

    private static Scanner scanner;
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        scanner = new Scanner(System.in);

        // Login or Register? (?) l r

        System.out.println("(l)ogin / (r)egister?");
        var selection = scanner.nextLine();

        if (selection.equalsIgnoreCase("l")){
            login();
        }
        else if(selection.equalsIgnoreCase("r")){
            register();
        }
    }

    private static void login() throws SQLException {
        // Get username
        System.out.print("Enter username: ");
        var username = scanner.nextLine();

        // Get password
        System.out.print("Enter pass: ");
        var password = scanner.nextLine();

        var userService = new UserService();
        var user = userService.getUserByUsername(username);

        System.out.println(user.getHash());
    }

    private static void register() throws NoSuchAlgorithmException, SQLException {
        // Get username
        System.out.print("Enter username: ");
        var username = scanner.nextLine();

        // Get password
        System.out.print("Enter pass: ");
        var password = scanner.nextLine();
        var salt = generateSalt();
        var passAndSalt = password + ":" + salt;
        var hashedPassAndSalt = hashMd5(passAndSalt) + ":" + salt;

        var user = new User(username, hashedPassAndSalt);
        var userService = new UserService();
        userService.insertUser(user);
    }

    private static String hashMd5(String input) throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("MD5");
        var passwordBytes = input.getBytes();
        md.update(passwordBytes); // 5EB63BBBE01EEED093CB22BB8F5ACDC3
        var md5Bytes = md.digest();

        var sb = new StringBuilder();
        for(var b : md5Bytes){
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    private static String generateSalt(){
        Random random = new Random();
        StringBuilder number = new StringBuilder();

        // Ensure the first digit is non-zero
        number.append(random.nextInt(9) + 1);

        // Generate the remaining 9 digits, which can include zero
        for (int i = 1; i < 10; i++) {
            number.append(random.nextInt(10));
        }

        return number.toString();
    }


}
