package com.pajakku.eppt;

import com.google.gson.Gson;
import com.pajakku.eppt.model.Bupot;
import com.pajakku.eppt.model.Key;
import com.pajakku.eppt.model.Pasal;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CipherInitializerTest {

    private Key key;

    @Before
    public void before() {
        Bupot bp21Tf = Bupot.builder()
                .nama("BP_21_TF")
                .count(100)
                .build();

        Bupot bp21F = Bupot.builder()
                .nama("BP_21_F")
                .count(100)
                .build();

        Bupot bp21A1 = Bupot.builder()
                .nama("BP_21_A1")
                .count(100)
                .build();

        Bupot bp21A2 = Bupot.builder()
                .nama("BP_21_A2")
                .count(100)
                .build();

        Bupot bp21SatuMasa = Bupot.builder()
                .nama("BP_21_SATU_MASA")
                .count(100)
                .build();

        Pasal pph21 = Pasal.builder()
                .name("PPH21")
                .bupot(Arrays.asList(bp21Tf, bp21F, bp21A1, bp21A2, bp21SatuMasa))
                .build();

        key = Key.builder()
                .npwp("010016293913002")
                .name("PT.Qiwary Solusi Finansiaku")
                .sn("VWxdY8RNhglVEPi4FqmLwoY47CqtfeqIEuBEsAQFCpv6ZMIVCVnDnsO1m486bcOk")
                .expiredAt("2018-04-13")
                .pasal(Collections.singletonList(pph21))
                .build();
    }

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String toJson = new Gson().toJson(key);
        LunaInitializer initializer = new LunaInitializer();
        Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipher, toJson);
        System.out.println(encrypt);

//        assertEquals("Nom1k4JskxFAx1BtBe1E778IjbC/eQ8k3E7UyWL36yy4nONLr+QsgQllSlpIEiJzkoFQLzXaVLGDQ6a5achCEVQixV9WylWAtMhh5kDohiBfes0X1jVlaKaiW8sK+H7sgGC6M+Umng/Ofd3CRMslTBJnVXsHCel3vqmgmzw1bIUUq7oIfy+qEsxpLouhP/lWw027+TzhVV1WWDtg95/ex/yJcoKBKFMQb6pujKWxgR2aOj5cDphPm3MWzZoln+fHdblMuzeSiDe4JVOVILQva4jDRaEEeM5gf5E05HdeyKQI3TjQVcPYFQR/E5NHXyQd7FKvQFpF4e0iuKlaWSmxaXFwN5Gyk1T/OAf7vReTKmjl68IdioVjuSBRsO2BklZIusJuL6VzEraoTe0Bdqm1Zv/3nbF8ORCT7YLNar0/d+RTXAsq5upubtw4TpjwH7UFkYSuGqWby0b8ypXNpQlXNjPoDoOzFS0SEuW47yEDAxk=", encrypt);
    }



}