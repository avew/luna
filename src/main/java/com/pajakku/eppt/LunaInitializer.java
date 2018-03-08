package com.pajakku.eppt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class LunaInitializer {

    private static final String CIPHER_INSTANCE_NAME = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALGORITHM = "AES";
    private static final String KEY = "7b016e5d87b046f3";

    public Cipher prepareAndInitCipher(int encryptionMode) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_NAME);
        Key secretKey = new SecretKeySpec(KEY.getBytes(), SECRET_KEY_ALGORITHM);
        AlgorithmParameterSpec algorithmParameters = getAlgorithmParameterSpec(cipher);

        callCipherInit(cipher, encryptionMode, secretKey, algorithmParameters);
        return cipher;
    }

    void callCipherInit(Cipher cipher, int encryptionMode, Key secretKey, AlgorithmParameterSpec algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException {
        cipher.init(encryptionMode, secretKey, algorithmParameters);
    }

    int getCipherBlockSize(Cipher cipher) {
        return cipher.getBlockSize();
    }

    private AlgorithmParameterSpec getAlgorithmParameterSpec(Cipher cipher) {
        byte[] iv = new byte[getCipherBlockSize(cipher)];
        return new IvParameterSpec(iv);
    }

    byte[] callCipherDoFinal(Cipher cipher, byte[] bytes) throws IllegalBlockSizeException, BadPaddingException {
        return cipher.doFinal(bytes);
    }

    public String encrypt(Cipher cipher, String value) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bytesToEncrypt = value.getBytes();
        byte[] encryptedBytes = callCipherDoFinal(cipher, bytesToEncrypt);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(Cipher cipher, String dbData) throws IllegalBlockSizeException, BadPaddingException {
        byte[] encryptedBytes = Base64.getDecoder().decode(dbData);
        byte[] decryptedBytes = callCipherDoFinal(cipher, encryptedBytes);
        return new String(decryptedBytes);
    }



}
