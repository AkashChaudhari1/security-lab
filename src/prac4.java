import javax.crypto.*;
class prac4{
    public KeyGenerator keygenerator;
    public SecretKey myKey;
    Cipher c;
    public prac4() throws Exception{
        // Key generation
        keygenerator = KeyGenerator.getInstance("AES");
        myKey = keygenerator.generateKey();
        // Creating the cipher
        c = Cipher.getInstance("AES/ECB/PKCS5Padding");
    }
    public byte[] performEncryption(String s) throws Exception{
        // Initialize the cipher for encryption
        c.init(Cipher.ENCRYPT_MODE, myKey);
        //data to be encrypted
        byte[] text = s.getBytes();
        // Encrypt the data
        byte[] textEncrypted = c.doFinal(text);
        return(textEncrypted);
    }
    public String PerformDecryption(byte[] s)throws Exception{
        // Initialize the same cipher for decrypting data
        c.init(Cipher.DECRYPT_MODE, myKey);
        // Decrypt the data
        byte[] textDecrypted = c.doFinal(s);
        return(new String(textDecrypted));
    }
    public static void main(String[] argv) throws Exception{
        prac4 obj = new prac4();
        byte[] str=obj.performEncryption("This data in encrypted using Java AES ECB");
        System.out.println("Encrypted String : "+str);
        System.out.println("Decrypted String : " + obj.PerformDecryption(str));
    }
}