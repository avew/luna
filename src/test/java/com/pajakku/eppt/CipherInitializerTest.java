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

public class CipherInitializerTest {


    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Bupot bp21Tf = Bupot.builder()
                .nama("BP_21_TF")
                .count(1000)
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .count(1000)
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .count(1000)
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .count(1000)
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .count(1000)
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        //pph 23
        Bupot bp23 = Bupot.builder()
                .nama("BP_23")
                .count(1000)
                .build();

        Bupot bp26 = Bupot.builder()
                .nama("BP_26")
                .count(1000)
                .build();

        Pasal pph23 = Pasal.builder()
                .name("PPH23")
                .bupot(Arrays.asList(bp23, bp26))
                .build();
        //end pph 23

        //pph 23
        Bupot bp4a2 = Bupot.builder()
                .nama("BP_4A2")
                .count(1000)
                .build();


        Pasal pph4a2 = Pasal.builder()
                .name("PPH4A2")
                .bupot(Collections.singletonList(bp4a2))
                .build();

        Key key = Key.builder()
                .npwp("010016293527011")
                .name("PT.Mitra Pajakku")
                .sn("6d381308-43ee-40dd-9b65-c177f829ce28")
                .expiredAt("2018-07-01")
                .pasal(Arrays.asList(pph21, pph23, pph4a2))
                .build();

        String toJson = new Gson().toJson(key);
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, toJson);
        System.out.println(encrypt);

    }


}