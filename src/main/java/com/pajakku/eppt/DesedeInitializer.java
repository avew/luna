package com.pajakku.eppt;

import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesedeInitializer {


    public static String encrypt(String plainText) throws InvalidKeyException, NoSuchAlgorithmException, DecoderException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = "XsCTcq3LNFfNsAEj2anL4000".getBytes();
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

    public static File encryptFile(File inputFile, File outputFile) throws InvalidKeyException, NoSuchAlgorithmException, DecoderException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = "XsCTcq3LNFfNsAEj2anL4000".getBytes();
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

    public static String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, DecoderException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String algorithm = "DESede";
        String transformation = "DESede/CBC/PKCS5Padding";
        byte[] keyValue = "XsCTcq3LNFfNsAEj2anL4000".getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
        /* Initialization Vector of 8 bytes set to zero. */
        IvParameterSpec iv = new IvParameterSpec(new byte[]{12, 34, 56, 78, 90, 87, 65, 43});
        SecretKey key = SecretKeyFactory.getInstance(algorithm).generateSecret(keySpec);
        Cipher decrypter = Cipher.getInstance(transformation);
        decrypter.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decrypted = decrypter.doFinal(Hex.decodeHex(cipherText.toCharArray()));
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}
