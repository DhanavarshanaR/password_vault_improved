import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    // Secret key for AES (must be 16 characters)
    private static final String SECRET_KEY = "MySecretKey12345";

    public static String encrypt(String strToEncrypt) {

        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.getMessage());
        }

        return null;
    }

    public static String decrypt(String strToDecrypt) {

        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedBytes = Base64.getDecoder().decode(strToDecrypt);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes);

        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.getMessage());
        }

        return null;
    }
}
