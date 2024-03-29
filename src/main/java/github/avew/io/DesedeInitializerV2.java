package github.avew.io;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesedeInitializerV2 {


    public static String encrypt(String secret, String plainText) throws InvalidKeyException, NoSuchAlgorithmException, DecoderException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = secret.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
        /* Initialization Vector of 8 bytes set to zero. */
        IvParameterSpec iv = new IvParameterSpec(new byte[]{12, 34, 56, 78, 90, 87, 65, 43});
        SecretKey key = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
        Cipher encrypter = Cipher.getInstance(transformation);
        encrypter.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] input = plainText.getBytes();
        byte[] encrypted = encrypter.doFinal(input);
        return new String(Hex.encodeHex(encrypted));
    }

    public static File encryptFile(String secret, File inputFile, File outputFile) throws InvalidKeyException, NoSuchAlgorithmException, DecoderException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = secret.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
        /* Initialization Vector of 8 bytes set to zero. */
        IvParameterSpec iv = new IvParameterSpec(new byte[]{12, 34, 56, 78, 90, 87, 65, 43});
        SecretKey key = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
        Cipher encrypter = Cipher.getInstance(transformation);
        encrypter.init(Cipher.ENCRYPT_MODE, key, iv);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes = new byte[4096];

            for (int n = inputStream.read(inputBytes); n > 0; n = inputStream.read(inputBytes)) {
                byte[] outputBytes = encrypter.update(inputBytes, 0, n);
                String output = new String(Hex.encodeHex(outputBytes));
                outputStream.write(output.getBytes());
            }

            byte[] outputBytes = encrypter.doFinal();
            String output = new String(Hex.encodeHex(outputBytes));
            outputStream.write(output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile;
    }

    public static String decrypt(String secret, String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, DecoderException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = secret.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
        /* Initialization Vector of 8 bytes set to zero. */
        IvParameterSpec iv = new IvParameterSpec(new byte[]{12, 34, 56, 78, 90, 87, 65, 43});
        SecretKey key = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
        Cipher decrypter = Cipher.getInstance(transformation);
        decrypter.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decrypted = decrypter.doFinal(Hex.decodeHex(cipherText.toCharArray()));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    public static File decryptFile(String secret, File inputFile, File outputFile) throws InvalidKeyException, NoSuchAlgorithmException, DecoderException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = secret.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
        /* Initialization Vector of 8 bytes set to zero. */
        IvParameterSpec iv = new IvParameterSpec(new byte[]{12, 34, 56, 78, 90, 87, 65, 43});
        SecretKey key = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
        Cipher decrypter = Cipher.getInstance(transformation);
        decrypter.init(Cipher.DECRYPT_MODE, key, iv);

        String content = "";

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            /*byte[] inputBytes = new byte[4096];

            for (int n = inputStream.read(inputBytes); n > 0; n = inputStream.read(inputBytes)) {
                byte[] outputBytes = decrypter.update(inputBytes, 0, n);
                String output = new String(Hex.encodeHex(outputBytes));
                outputStream.write(output.getBytes());
            }*/

            try {
                content = new String(Files.readAllBytes(Paths.get(inputFile.getAbsolutePath())));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String decrypted = decrypt(secret, content);

            byte[] inputBytes = new byte[4096];

            for (int n = inputStream.read(inputBytes); n > 0; n = inputStream.read(inputBytes)) {
                outputStream.write(decrypted.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile;
    }
}
