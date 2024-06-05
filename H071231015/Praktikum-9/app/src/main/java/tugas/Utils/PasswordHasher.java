package tugas.Utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ""; 
    }
}


// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;

// class Encryptor {

//     public static String encryptString(String input) throws NoSuchAlgorithmException {
//         // MessageDigest works with MD2, MD5, SHA-1, SHA-224, SHA-256,
//         // SHA-384, and SHA-512
//         MessageDigest md = MessageDigest.getInstance("MD5");

//         byte[] messageDigest = md.digest(input.getBytes());

//         BigInteger bigInt = new BigInteger(1, messageDigest);

//         return bigInt.toString(16);
//     }

//     public static void main(String[] args) throws NoSuchAlgorithmException {
//         Encryptor encryptor = new Encryptor();

//         String password = "monkey123";

//         System.out.println(encryptor.encryptString(password));
//     }
// }