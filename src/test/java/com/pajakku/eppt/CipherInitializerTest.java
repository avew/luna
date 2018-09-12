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

    public static Integer count = 100;

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Bupot bp21Tf = Bupot.builder()
                .nama("BP_21_TF")
                .count(count)
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .count(count)
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .count(count)
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .count(count)
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .count(count)
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        //pph 23
        Bupot bp23 = Bupot.builder()
                .nama("BP_23")
                .count(count)
                .build();

        Bupot bp26 = Bupot.builder()
                .nama("BP_26")
                .count(count)
                .build();

        Pasal pph23 = Pasal.builder()
                .name("PPH23")
                .bupot(Arrays.asList(bp23, bp26))
                .build();
        //end pph 23

        //pph 23
        Bupot bp4a2 = Bupot.builder()
                .nama("BP_4A2")
                .count(count)
                .build();


        Pasal pph4a2 = Pasal.builder()
                .name("PPH4A2")
                .bupot(Collections.singletonList(bp4a2))
                .build();

        Key key = Key.builder()
                .id(UUID.randomUUID().toString())
                .npwp("010016293527001")
                .name("PT.Test 1")
                .sn("4bd1f39b-028e-4336-8fa2-df8923f1d283")
                .expiredAt("2018-12-30")
                .pasal(Arrays.asList(pph21, pph23, pph4a2))
                .build();


        String toJson = new Gson().toJson(key);
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, "1000");
        System.out.println(encrypt);

    }

    @Test
    public void testDecrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.DECRYPT_MODE);
        String decrypt = initializer.decrypt(cipher, "Q1S/zrkMF3gAyvyT1iVTbfTmkg3ZEmTjVQubmMfGBFixasZYHpgZLesIiuIYmd+J9qCAkwyBg494k5yz4eMyErHIo19tiY5QuL6O2q8xYqVcKzf/N5UCBjxaMbAp2TYdvP5TQqR5F7idkizrRZZnMtT6DCstoBtOtroD7l9OedLvNTFoecoWIvr++Y6dr3kgGZV5ZsbdG2pz3ev3s1M/cGxYeF+id2nkeUysv0NxEqLeQUX260aPmlsPilRKzgr6YwYZ8v1I0lHPtomTcoTwGNN4UgytEOoDF3aPXA8JxoBv2Ri3QaGSVbz79kS2qwdwlZGRWx87Ydfm8f2yxkw+gvie7ppx9BoWvWtrv7w61JLgfzlTS2aSbpQUxCNGyVLZTIifpLuzNI5kBdv7gY9fypTuNafDLB1taB941BUSnSXlzzu/+OdprpQ3vm1yq4il9/U/CVApHAKmpdp9JUnsZciclCi0bEUocm6nVU5EK8x7LJTMsBvgs9AG8Ags9iJZM4RcarxvYC0YQZZb/A9AmG/9V2veHe/CgXEAgmYwmsq7TnX3sVob0R323YQAU8UfzgCMsRuAT4ZOZcsmLh+gLJHL/LRpMCeGDtCrtuJ8TSmi3/3D+QDPWEpK6O9QRJFUrCb1vE1RKalZOc1hcIz6CgGYH/8VtUew19ombQMqAGbT+gESpzw62SeLMCvVTIJeYSQkSrR+VPFTWctrsRLCe6Dm7f5/+hC7imdMDEGdMMY=");
        System.out.println(decrypt);
    }


}