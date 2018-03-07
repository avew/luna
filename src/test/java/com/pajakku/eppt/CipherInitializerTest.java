package com.pajakku.eppt;

import com.google.gson.Gson;
import com.pajakku.eppt.model.Bupot;
import com.pajakku.eppt.model.Key;
import com.pajakku.eppt.model.Pasal;
import org.junit.Assert;
import org.junit.Before;
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

    private Key key;

    @Before
    public void before() {
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

        key = Key.builder()
                .npwp("023986557903002")
                .name("PT.B")
                .sn("57bWljA80it/56bcsUd3msYcFwkwUD0B7AgUSm+nfx4/c0SSFsCpyqDtpN4r1ta8")
                .expiredAt("28/02/2018")
                .pasal(Collections.singletonList(pph21))
                .build();
    }

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String toJson = new Gson().toJson(key);
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, toJson);
        Assert.assertEquals("WDR+H1s9GKp9rZ0MGAbS9sWvHfMkHocgA2dgrRcmzlAo1ocQPT3KETF4glIAUccX/fpZw7d/KmvQkG2mP+nqGeJa/E6kON06FdsKauT1PPtw2nAgf6os6LzdsaEpskLtTIUbAMHqGOvoL+Qku3n5IM+eDjZer3j2IiQwozwAakX1wlUejzA9ruvdFjNB3uPNUAnFrU9vrc4Thu49iahQHdZDHiyuRQsaxkVF36D2SDe/S/Tl3TOA600x5+DVMqJusE63eoEd+kEOcMI883XoEyAh3IvjjkMb3j7nvZLHoqAB5fx5Qa2UsOjngug9B3Jc8CgD/R9nlBf52FptCx/UKGOeqWR9N/uYFxOXtqgafwTY4zBWMepvaN2eDhcEIDl32dCP0ZdyRQe3+xh/3BWbiWNxXnTn1MMk2cNM05Fj6LlUauqZs3hwmagvvc0OBO9M2ltDYg37j3v0jTgtxr7pgQ==", encrypt);
    }

}