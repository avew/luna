package com.pajakku.eppt;

import com.google.gson.Gson;
import com.pajakku.eppt.model.Bupot;
import com.pajakku.eppt.model.Key;
import com.pajakku.eppt.model.Pasal;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

public class CipherInitializerTest {

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Bupot bp21Tf = Bupot.builder()
                .nama("BP_21_TF")
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        //pph 23
        Bupot bp23 = Bupot.builder()
                .nama("BP_23")
                .build();

        Bupot bp26 = Bupot.builder()
                .nama("BP_26")
                .build();

        Pasal pph23 = Pasal.builder()
                .name("PPH23")
                .bupot(Arrays.asList(bp23, bp26))
                .build();
        //end pph 23

        //pph 4a2
        Bupot bp4a2 = Bupot.builder()
                .nama("BP_4A2")
                .build();


        Pasal pph4a2 = Pasal.builder()
                .name("PPH4A2")
                .bupot(Collections.singletonList(bp4a2))
                .build();


        //pph 22
        Bupot bp22 = Bupot.builder()
                .nama("BP_22")
                .build();


        Pasal pph22 = Pasal.builder()
                .name("PPH22")
                .bupot(Collections.singletonList(bp22))
                .build();

        Key key = Key.builder()
                .id(UUID.randomUUID().toString())
                .npwp("666794755439000")
                .name("PT.Intan Telor")
                .sn("4bd1f39b-028e-4336-8fa2-df8923f1d283")
                .expiredAt("2018-12-30")
                .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22))
                .build();


        String toJson = new Gson().toJson(key);
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, toJson);
        System.out.println(encrypt);

    }

    @Test
    public void testDecrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        LunaInitializer initializer = new LunaInitializer();
        Cipher cipherDecrypt = initializer.prepareAndInitCipher(Cipher.DECRYPT_MODE);
        String decrypt = initializer.decrypt(cipherDecrypt, "oZCkG0ufoEdxkzR7jD+6vQ==");
        System.out.println(decrypt);

        Cipher cipherEncrypt = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipherEncrypt, "014466585062000");
        System.out.println(encrypt);
//        Key key = new Gson().fromJson(decrypt, Key.class);
//        System.out.println(key.getNpwp());
    }

    @Test
    public void testEncryptString() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, "2e4a7947-4015-4571-8c45-861703ae624f");
        System.out.println(encrypt);
    }


}