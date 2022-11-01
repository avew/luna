package com.pajakku.eppt;

import com.google.gson.Gson;
import com.pajakku.eppt.model.Bupot;
import com.pajakku.eppt.model.Key;
import com.pajakku.eppt.model.MinioCredential;
import com.pajakku.eppt.model.Pasal;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.*;

public class CipherInitializerTest {
    @Test
    public void testEncryptNonDirect() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        Map<String, Object> map = new HashMap<>();
        map.put("name", "PT.ANGIN RIBUT");
        map.put("email", "anginribut@info.com");
        map.put("membershipStartDate", "2022-01-23");
        map.put("membershipEndDate", "2023-06-23");
        map.put("uniqueId", "KPfmMMosmZPaaLVlLgoEyycRRqtaQjgqPKJmVbhw");
        map.put("clientId", "3d442eb24ed54489a6b92d9fdc599fd2");
        map.put("clientSecret", "675f50bddce645c28a1a2300ac03de62");
        map.put("accessId", "m5zxKHtLFxQ5P179q8fiqehdD8JqceGjw78vX3Mh");
        map.put("accessSecret", "W0b4onjRnh1YGx16L3q3t8oIZRphECDVMZuZsMNX");


        LunaInitializer initializer = new LunaInitializer();
        Cipher cipherEncrypt = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipherEncrypt, new Gson().toJson(map));
        System.out.println(encrypt);


    }
}