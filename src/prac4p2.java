import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class prac4p2{
private static final String key = "aesEncryptionKey";
private static final String IV = "encryptionIntVec";
public static String encryption(String value) {
try {
IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
byte[] encrypted = cipher.doFinal(value.getBytes());
return Base64.encodeBase64String(encrypted);
} catch (Exception ex) {
ex.printStackTrace();
}
return null;
}
}