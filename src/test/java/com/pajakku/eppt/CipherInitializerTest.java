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
                .count(999999)
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .count(999999)
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .count(999999)
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .count(999999)
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .count(5)
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        //pph 23
        Bupot bp23 = Bupot.builder()
                .nama("BP_23")
                .count(999999)
                .build();

        Bupot bp26 = Bupot.builder()
                .nama("BP_26")
                .count(999999)
                .build();

        Pasal pph23 = Pasal.builder()
                .name("PPH23")
                .bupot(Arrays.asList(bp23, bp26))
                .build();
        //end pph 23

        //pph 23
        Bupot bp4a2 = Bupot.builder()
                .nama("BP_4A2")
                .count(999999)
                .build();


        Pasal pph4a2 = Pasal.builder()
                .name("PPH4A2")
                .bupot(Collections.singletonList(bp4a2))
                .build();

        Key key = Key.builder()
                .npwp("010016293527011")
                .name("PT.Mitra Pajakku")
                .sn("4bd1f39b-028e-4336-8fa2-df8923f1d283")
                .expiredAt("2018-12-30")
                .pasal(Arrays.asList(pph21, pph23, pph4a2))
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
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.DECRYPT_MODE);
        String decrypt = initializer.decrypt(cipher, "rjKFPnpFxF2F1G7QlNHNUXr3+7c62kH0BzFJGRqxEP8lwmNvUNjdVUw0icaSSyiyaXqszk9I4wPVbSwVBCrQDHqpdrbhPo2w83Ijv6nFOAcHqQpPGhuP007Pm1sZetf11fJqCKnzNkbXcu4FAAl5PYdjPcaA004zjNu8wBjaaojJu1SAYsQx3BdSQNLFTc61+w+TOJAQZM7NgE5YQctNO8XBKKGP2YTnIJJU+Uis6D297odE6V0BujOLQ+WSy0e9PPKSfYUrEZr5HzdjPtvr0y6t+Tg1iH0iSDdGgtwrsT4oEh0izeiek/aIfrjLjpJbunvuAR5xqZ0yRrgzmpzNJsi7QWDVWOtOikcUXOL2+pewF3xOy5tRSn03e7bq1tBj7QSySAeflDiRGVNSM2KcxJEbVnAyig9kRtNgLVW7BdquKoSm9Sg+MHpRrbzPSjyh+CKIsQ82/QY3KbDKGwpN19TnERpDbTPuaqHDDfIRartkW3gjCW7xfMpzKd54pS8g7Ln1T9fMO48U830Mi92O257R2EGW4+eXECV5oWJ4IpUFHkGN1Eu1mQeyaFg/nHkHU+ED3Z7suCb7Of7f75rd7H/aretQv8zk3lW6+7fZ3wiV/eREr7aGvYXrwbQrqDu9DEFNkVZig0VaEySeIjxq8g==");
        System.out.println(decrypt);
    }


}