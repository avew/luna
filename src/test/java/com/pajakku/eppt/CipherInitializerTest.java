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


        //pph 15
        Bupot bp15 = Bupot.builder()
            .nama("BP_15")
            .build();


        Pasal pph15 = Pasal.builder()
            .name("PPH15")
            .bupot(Collections.singletonList(bp15))
            .build();

        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);

        String serial = "dbb546d3-fc73-429d-acd0-b7f3a991bbc8";

        Key key_023986557423001 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("023986557423001")
            .name("PT. MITRA PAJAKKU")
            .sn(serial)
            .expiredAt("2030-12-30")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_023986557423001 = new Gson().toJson(key_023986557423001);
        String encrypt_023986557423001 = initializer.encrypt(cipher, json_023986557423001);
        System.out.println("023986557423001: " + encrypt_023986557423001);

        Key key_722121746439000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("722121746439000")
            .name("PT. CABANG HERU")
            .sn(serial)
            .expiredAt("2030-12-30")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_722121746439000 = new Gson().toJson(key_722121746439000);
        String encrypt_722121746439000 = initializer.encrypt(cipher, json_722121746439000);
        System.out.println("722121746439000: " + encrypt_722121746439000);

        Key key_000000000000000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("010000000000000")
            .name("PT. TEST")
            .sn(serial)
            .expiredAt("2030-12-30")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_000000000000000 = new Gson().toJson(key_000000000000000);
        String encrypt_000000000000000 = initializer.encrypt(cipher, json_000000000000000);
        System.out.println("000000000000000: " + encrypt_000000000000000);
    }

    @Test
    public void testDecrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        LunaInitializer initializer = new LunaInitializer();
        Cipher cipherDecrypt = initializer.prepareAndInitCipher(Cipher.DECRYPT_MODE);
        String decrypt = initializer.decrypt(cipherDecrypt, "6te+VPFZQMeJrYgVKDU6LCoWW8T4tJGzaq7SYkyfIpi0xDOw/9Gst118h+nVO06nrSYJGlsDvnLEz64J6xf8KwELF6CzZi6i0//BvJQ695aU+ti16a9sTVJfOKN67DqhXwFUxKYuavD3+GGE7YRd79/XOmvrF+u9tlJDGqH75wOk7waGfn+7FHv46tO5KToHSRQ8FJYA1sguHz5SixLMH6B/+ho2GIXSfO+cCeAWmEWQkB9+V15GrOj1u+JjFjgfFlAdqnoxbATlPkQnIX54TuLOTXX7h+udbvl7HpYk7PY3IMLAkvSKXsLG5OF5+ILPRVQgx1EFJLbgh0aDpPZ4VUWkG3XA9uYomRvafZMZdfT99EGf7B5Bbi4fr83iu/6r3TY93sABsFOaBEu0A2gInkb3s2aMSRdWetnwDilJ42Ak8fcCL4eJQCmCIo3T3lbTEZXcVnrIdNAiafgRfiA344RRAE9G5k+0pXtaAa0yiOE4RJVWWOea1LAGqntVHnrcnjX9iLR8BD7xISjfCSk3Tvz5yYMKG48TuqtjvDrAZZdZoqiMtxj3WZYjSxz188M+3KpkHG6aZgVNFPNhvS+dyP9pm3zmbB10OoEYtREXtf15MqccbulZS1R5W7K2/XeXOGxUAngcFwhTUwvx+c0bb/laSMGY8RKESpdSpRSLfeeP1WyX8l+xJnGQ5l1caC5pIwbiykAx2abK9irNEL77CwV8zrcnXx8PP5OGuX2mVS3hYJhy5RskeOdUcm+JxpLG52jxbXwbJEutOWCA49dJZMFfCTqJVltIV88l7u8irtV3VJQ9UafloBK5Qc+ZDagV");
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