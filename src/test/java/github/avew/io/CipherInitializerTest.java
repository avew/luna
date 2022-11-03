package github.avew.io;

import com.google.gson.Gson;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CipherInitializerTest {
    @Test
    public void testEncryptNonDirect() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {


        Map<String, Object> map = new HashMap<>();
        map.put("name", "PT.ANGIN RIBUT");
        map.put("email", "anginribut@info.com");

        LunaInitializer initializer = new LunaInitializer();
        Cipher cipherEncrypt = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
        String encrypt = initializer.encrypt(cipherEncrypt, new Gson().toJson(map));
        System.out.println(encrypt);


    }
}