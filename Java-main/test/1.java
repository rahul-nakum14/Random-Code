import java.util.Scanner;
public class VernamCipher {
 public static void main(String[] args) {
 try (Scanner in = new Scanner(System.in)) {
 System.out.print("Enter your PlainText: ");
 String plainText = in.nextLine();
 String key = generateRandomKey(plainText.length());
 System.out.println("Key: " + key);
 String encryptedText = encrypt(plainText, key);
 System.out.println("Encrypted text: " + encryptedText);
 String decryptedText = decrypt(encryptedText, key);
 System.out.println("Decrypted text: " + decryptedText);
 }
 }
 public static String encrypt(String plainText, String key) {
 StringBuilder encryptedText = new StringBuilder();
 for (int i = 0; i < plainText.length(); i++) {
 char plainChar = plainText.charAt(i);
 char keyChar = key.charAt(i);
 char encryptedChar = (char) (plainChar ^ keyChar); // XOR operation
 encryptedText.append(encryptedChar);
 }
 return encryptedText.toString();
 }
 public static String decrypt(String encryptedText, String key) {
 StringBuilder decryptedText = new StringBuilder();
 for (int i = 0; i < encryptedText.length(); i++) {
 char encryptedChar = encryptedText.charAt(i);
 char keyChar = key.charAt(i);
 char decryptedChar = (char) (encryptedChar ^ keyChar); // XOR operation
 decryptedText.append(decryptedChar);
 }
 return decryptedText.toString();
 }
 public static String generateRandomKey(int length) {
 StringBuilder key = new StringBuilder();
 for (int i = 0; i < length; i++) {char randomChar = (char) (Math.random() * 128); // Generate random character (0-127 ASCII)
 key.append(randomChar);
 }
 return key.toString();
 }
}
