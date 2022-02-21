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

public class CipherInitializerTest {

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Bupot bp21Tf = Bupot.builder()
                .nama("BP_21_TF")
                .count(300)
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .count(300)
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .count(300)
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .count(300)
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .count(300)
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        //pph 23
        Bupot bp23 = Bupot.builder()
                .nama("BP_23")
                .count(5000)
                .build();

        Bupot bp26 = Bupot.builder()
                .nama("BP_26")
                .count(5000)
                .build();

        Pasal pph23 = Pasal.builder()
                .name("PPH23")
                .bupot(Arrays.asList(bp23, bp26))
                .build();
        //end pph 23

        //pph 4a2
        Bupot bp4a2 = Bupot.builder()
                .nama("BP_4A2")
                .count(5000)
                .build();


        Pasal pph4a2 = Pasal.builder()
                .name("PPH4A2")
                .bupot(Collections.singletonList(bp4a2))
                .build();


        //pph 22
        Bupot bp22 = Bupot.builder()
                .nama("BP_22")
                .count(5000)
                .build();


        Pasal pph22 = Pasal.builder()
                .name("PPH22")
                .bupot(Collections.singletonList(bp22))
                .build();


        //pph 15
        Bupot bp15 = Bupot.builder()
            .nama("BP_15")
            .count(5000)
            .build();


        Pasal pph15 = Pasal.builder()
            .name("PPH15")
            .bupot(Collections.singletonList(bp15))
            .build();

        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);

        String serial = "4bd1f39b-028e-4336-8fa2-df8923f1d283";
//        String serial = "79b53c11-49d1-46b9-a469-606e6633a834";

        Key key_023986557423001 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("023986557423001")
            .name("PT. MITRA PAJAKKU")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_023986557423001 = new Gson().toJson(key_023986557423001);
        String encrypt_023986557423001 = initializer.encrypt(cipher, json_023986557423001);
        System.out.println("023986557423001: " + encrypt_023986557423001);

        serial = "e3b914de-0f1a-45c6-a064-ab7e9fe3db61";
        serial = "cf783395-0187-40e2-8d25-33b43bae770d";

        Key key_027506971125002 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("027506971125002")
            .name("PT TIGA DUA DELAPAN")
            .sn(serial)
            .expiredAt("2022-04-29")
            .pasal(Arrays.asList(pph23, pph4a2, pph22, pph15))
            .build();

        String json_027506971125002 = new Gson().toJson(key_027506971125002);
        String encrypt_027506971125002 = initializer.encrypt(cipher, json_027506971125002);
        System.out.println("027506971125002: " + encrypt_027506971125002);

        Key key_722121746439000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("722121746439000")
            .name("PT. CABANG HERU")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_722121746439000 = new Gson().toJson(key_722121746439000);
        String encrypt_722121746439000 = initializer.encrypt(cipher, json_722121746439000);
        System.out.println("722121746439000: " + encrypt_722121746439000);

        Key key_000000000000000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("000000000000000")
            .name("PT. TEST")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_000000000000000 = new Gson().toJson(key_000000000000000);
        String encrypt_000000000000000 = initializer.encrypt(cipher, json_000000000000000);
        System.out.println("000000000000000: " + encrypt_000000000000000);

        Key key_023986557031000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("023986557031000")
            .name("PT. MITRA PAJAKKU")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_023986557031000 = new Gson().toJson(key_023986557031000);
        String encrypt_023986557031000 = initializer.encrypt(cipher, json_023986557031000);
        System.out.println("023986557031000: " + encrypt_023986557031000);

        Key key_096115852016000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("096115852016000")
            .name("PT. MITRA PAJAKKU 2")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_096115852016000 = new Gson().toJson(key_096115852016000);
        String encrypt_096115852016000 = initializer.encrypt(cipher, json_096115852016000);
        System.out.println("096115852016000: " + encrypt_096115852016000);

        key_722121746439000 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("722121746439000")
            .name("PT. CABANG HERU")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        json_722121746439000 = new Gson().toJson(key_722121746439000);
        encrypt_722121746439000 = initializer.encrypt(cipher, json_722121746439000);
        System.out.println("722121746439000 payjak: " + encrypt_722121746439000);

        Key key_023986557031002 = Key.builder()
            .id(UUID.randomUUID().toString())
            .npwp("023986557031002")
            .name("PT. EFILING TEST")
            .sn(serial)
            .expiredAt("2030-12-31")
            .pasal(Arrays.asList(pph21, pph23, pph4a2, pph22, pph15))
            .build();

        String json_023986557031002 = new Gson().toJson(key_023986557031002);
        String encrypt_023986557031002 = initializer.encrypt(cipher, json_023986557031002);
        System.out.println("023986557031002: " + encrypt_023986557031002);

        MinioCredential minioCredential = MinioCredential.builder()
            .endpoint("https://ebupot-files.pajakku.com")
            .access("ebupot")
            .secret("Eb23up26oT#2!")
            .build();

        String json_minio_credential = new Gson().toJson(minioCredential);
        String encrypt_minio_credential = initializer.encrypt(cipher, json_minio_credential);
        System.out.println("encrypt_minio_credential: " + encrypt_minio_credential);
    }

    @Test
    public void testDecrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        LunaInitializer initializer = new LunaInitializer();
        Cipher cipherDecrypt = initializer.prepareAndInitCipher(Cipher.DECRYPT_MODE);
        String decrypt = initializer.decrypt(cipherDecrypt, "MtcxrEyUEX9fz1HVhDHZHdjs02dBsrYjcaTTd9QAbDrjVgEITlC1/YvS++XxHSkGbdbgPcu1EjCbqzRe5dMNdPG7QvEojKUGdPs0VXERhYDDkZIKS6TVSdZ9CymLvZoWg7vOFYh2Cxcf1vJbTs4xs/OkePIVgDcPKctx9O1NkFzAptIeIWFpn+REfUDtxD3EsHWlfmcL7ClEfIAFDI0vmf78dFqHiFeUPMdV37R43YzNUboUYhaWdK0KVhPQhIgNRF3cyUDedUrQdYVdkjn0muywZ/mkikkgcc3r/3LmPKyYHMOHniXteWj26rhfPTDQZoJsmVMubIlXXVNKrniiWXFK9fUtOt354SuLUTtBLlP8g8V5IbxAJgR2AG/xh1Hy+CBWB2xs8avnIqXufvlCqV34YXb6XS8aajHmCieCBX2/V2zTcKhVuckRRvRCH1dp1NplOfgxaegRP35l6NPeul/w+b5u2Z8cDYz6gBCeAD2EU84Zq/41XB3NF8myUe4qqBQ72F960VWzgIWTJmW0t5DavCs218irUdrfp1oKpGWt90eL9O78x/91Hy1Fh8W5shGojORz8y+hAe7czxWkoyHr8ghrrGwMoyPaOG621zGCQxZvGahG4eiUAk45Z10mPMgJ5+V8lmMxdwD2g+wzki3UEUqBZ1zFLSqMHPdOdMQDLZfI2ZL/anW4mY9LSlZ6BR2BELdCtc6kYH6sc7GTNErYbXeBJj8ruqjEqiKds1W5/wLaSQ0mAOlG91Zq8KFInOg8LcW6pNySAs3WwecU2dPPBgGLa/KWlODNhkS7Y0Stbu5CV+dXlObq0VgKuUYRIyuMwrHWX9JXwdhWnoi+EzNdBBmmoA9se9PtYatM4gk=");
        System.out.println(decrypt);

        Cipher cipherEncrypt = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipherEncrypt, "014466585062000");
        System.out.println(encrypt);
//        Key key = new Gson().fromJson(decrypt, Key.class);
//        System.out.println(key.getNpwp());

        decrypt = initializer.decrypt(cipherDecrypt, "sApZuhCIBaH0Wz14MQKBmyOXjjeYUl1FZaDPpthtfxP933cONpbWBE3YUu6bbNRph9fOGKJm6FlGr8BRHDfXSXO3XN7gN+6OBQWsNdG3CIZKFipEh806ZF1wjYyDnsa8");
        decrypt = initializer.decrypt(cipherDecrypt, "rjKFPnpFxF2F1G7QlNHNUZeR4wqoRAysCsU6+G2iHyfYQvjW0Dk7bDtDr38Y1yGr8Rfbw4bL9ISZlEjGj8HhwnOKm0ok1pFH5micAUb4EyqDueWJTczlbyO1zX7mCuc0U4qg/EY4LTU+3WMSEPV7r6i8jsZHTYfTuUtCu3dNXj2umzb49FAqJvfrK5XdU2dp7gkgLx9OjRMKZdSVmDaiuDc3n6WCed+Z1AWIubc4BmO1ntS8fn2ECzKjlUOvERSimB1R/zx9PVkF/jyzQRFlopGGlnQx9AjqI5OvZkzp5LkNrkvRAuXfLemG0A051ovgcrIZtOMHfKCdbLG3ZDKckkSpvdCd8G4n+NajfVAI/OUAXBuggcEKpXmzh8QxFMzWsxVX3Wr9VxVdViHAgpVShW1KhH2j6szdAzeMT/AXRpq4MQolHnZB6ndskjtPkt/Jb+8vkppoGsNvZRHY8PqHx/wgNDOGTXTfuK7nXofchqCNcFHT1MgjToDKBxDXpzZQP+vzDF9nA5I5YLi3tnWKvbeUrdpLwDY/53lX5YRrsA8=");
        decrypt = initializer.decrypt(cipherDecrypt, "WDR+H1s9GKp9rZ0MGAbS9js1whEKBYbpp/aV3W0rKDhv6YnglLv0Yu7TxkO8mZ9cfMgZDh/Nql2MBb3icRURh2uRIzbZOE4ebmg9cXhWtyyMen52uncMeSE/PStYyQXnqWzQxoMlbi4OlKHJVHk6YlFuGZQ0T2pF557I3O2Zd0WqSFoyZh0ft7YbxhXKnI6mq08Q9yMhFkl6DRtJsNMAs4PVIDgQtZrMHtSxrZgb9toe4Vz3kKI2zQX0xZ1BqB0k/rCXyYNjB8TcoJIScwxazpihHhzaVM6h1AeoX26PuD8b2MMgt03IrrtcReHdyvZt4lx5u7yIE0kVzK7ZP4dIb6XBwi6RpOCPs5lsfNIUUCJhykHM/5ctjmdUGDa3k4yrZjDyBXCLXhPiaVJ2TVb+52xCOtoQZIMg5AAtHdIiyXP6PAl5Y9M84FCInqREAg768hIVq/ggYCW0wyLYz5xIBpMo0vWN8Q4ckGALaCOZ2qZuE3wFRfawv0NqB2I+eQVw5z+32i7j0qNO2rC5CvEfPhc4Z8Isg6W8KS7mQcfo8cuK6Q3xtPVbD45L1kK1L0l/");
        System.out.println(decrypt);
    }

    @Test
    public void testEncryptString() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, "2e4a7947-4015-4571-8c45-861703ae624f");
        System.out.println(encrypt);
    }

    @Test
    public void testDecryptFile() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, UnsupportedEncodingException, DecoderException {

        File inputFile = new File("/media/pajakku-dev/Data/bceac90f-c8ac-441f-ac2a-8687fbb4cd1f/0239865570310001111202100F1132041218.mpk");
        File outputFile = new File("/media/pajakku-dev/Data/bceac90f-c8ac-441f-ac2a-8687fbb4cd1f/0239865570310001111202100F1132041218.csv");
        File decryptFile = DesedeInitializer.decryptFile(inputFile, outputFile);
        System.out.println(decryptFile);

    }

}