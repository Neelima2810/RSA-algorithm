import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.math.BigInteger; 
import java.util.Random; 
import java.util.Scanner;

public class RSAenc {
    static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) {
        // Input prime numbers
        System.out.print("Enter a Prime number: ");
        BigInteger p = sc.nextBigInteger(); 
        System.out.print("Enter another prime number: ");
        BigInteger q = sc.nextBigInteger(); 
        
        // Calculate n and φ(n)
        BigInteger n = p.multiply(q);
        BigInteger n2 = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 
        
        // Generate e
        BigInteger e = generateE(n2);
        
        // Calculate d
        BigInteger d = e.modInverse(n2); 
        
        // Display keys
        System.out.println("Encryption keys are: " + e + ", " + n); 
        System.out.println("Decryption keys are: " + d + ", " + n);
        
        // Encrypt a message
        System.out.print("Enter a message to encrypt (as an integer): ");
        BigInteger message = sc.nextBigInteger();
        BigInteger encryptedMessage = encrypt(message, e, n);
        System.out.println("Encrypted message: " + encryptedMessage);
        
        // Decrypt the message
        BigInteger decryptedMessage = decrypt(encryptedMessage, d, n);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static BigInteger generateE(BigInteger fiofn) {
        int y, intGCD; 
        BigInteger e;
        BigInteger gcd;
        Random x = new Random();

        do {
            y = x.nextInt(fiofn.intValue() - 1) + 1;  // Ensure y is greater than 0
            e = BigInteger.valueOf(y); 
            gcd = fiofn.gcd(e); 
            intGCD = gcd.intValue();
        } while (intGCD != 1); 
        return e;
    }

    public static BigInteger encrypt(BigInteger message, BigInteger e, BigInteger n) {
        return message.modPow(e, n);
    }

    public static BigInteger decrypt(BigInteger encryptedMessage, BigInteger d, BigInteger n) {
        return encryptedMessage.modPow(d, n);
    }
}
