package com.pajakku.eppt;

import com.google.gson.Gson;
import com.pajakku.eppt.model.Bupot;
import com.pajakku.eppt.model.Key;
import com.pajakku.eppt.model.MinioCredential;
import com.pajakku.eppt.model.Pasal;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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
				.count(300)
				.build();

		Bupot bp26 = Bupot.builder()
				.nama("BP_26")
				.count(300)
				.build();

		Pasal pph23 = Pasal.builder()
				.name("PPH23")
				.bupot(Arrays.asList(bp23, bp26))
				.build();
		//end pph 23

		//pph 4a2
		Bupot bp4a2 = Bupot.builder()
				.nama("BP_4A2")
				.count(300)
				.build();


		Pasal pph4a2 = Pasal.builder()
				.name("PPH4A2")
				.bupot(Collections.singletonList(bp4a2))
				.build();


		//pph 22
		Bupot bp22 = Bupot.builder()
				.nama("BP_22")
				.count(300)
				.build();


		Pasal pph22 = Pasal.builder()
				.name("PPH22")
				.bupot(Collections.singletonList(bp22))
				.build();


		//pph 15
		Bupot bp15 = Bupot.builder()
				.nama("BP_15")
				.count(300)
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
		String decrypt = initializer.decrypt(cipherDecrypt, "boo9YAIGlJoe/GQyUtcOdXVEJHH4YKE44vpLP3vBHr6vC3YApxT9W3FbwRtydtGzhyqA30xItCYWQ0rDVQmn2SZFF7OqoLbDCL056NxZQ1OW+MBUUK0DlO5mfM7WrXv4LvzxxVcesmar45FuWFpYDDuHJkDXjZmkcyX7tScQZt7RQqMAF3iqdjeZ6nRaK+qts/q8AyeXjxE2eDvf4kNB+8yuNZ1NPbqYyc7/78EC4wzrngSH5SrLUxrG52QmNVtNOkhyzYucsIMhBewMgoB4ql1GTJnqsPwg6ESJczw/6pLw9rfXc5knA//Xvc2AwtTJ3xBnOWn//1Ko/IWJ6v5mtieYoeYh+oOyEhj1GkI+dsOfdmP96PKN0re4jLQ8bIAA");
		System.out.println(decrypt);

//		Cipher cipherEncrypt = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);
//		String encrypt = initializer.encrypt(cipherEncrypt, "014466585062000");
//		System.out.println(encrypt);
////        Key key = new Gson().fromJson(decrypt, Key.class);
////        System.out.println(key.getNpwp());
//
//		decrypt = initializer.decrypt(cipherDecrypt, "IAffG3dc8aBUDLiQgw2UfXm653F2r/DWtswBjiQ66RwIAqq/4xMM7p2irCzR/XAS+hN1LITaJGxAU8eB5601gj5p4Ge1DVThtb8Ru1mrOd7lJ2MroPuKsvFAayi2CJXborpB8qbvZ2DmRS9wA+8VlQ3ObPHFOLIinjYgpN5QJCdR9WRg58ZUnmy8M6CzX6w8sAAJ1UX9Scg4/K2V1GfTvF2uLdKCh1tNAyp8aqZAiCISd4ZiGsuUdKpGkPeIZLLdk2QZwYmGq4HFFIjOGgOZUxd6wGp5mn77ZdVv9l8H8Rs2+BRY8f63jhrFMKqBEJA7dWQSF7wJYYCrUL68yJou86zLpLGDNsUOJdBusR7DiSTwXoDqXn2y6YCjvcrkuvrGRTbPrU1mdXINKGE7vD3Mzya69RYC7ZUqfuj4OpDQEk5Mjhmp9zDnDbBTyyJO/+oqJa51K2IVYjrTUD80hBdfTTNglLIyUom5toFKsr6UMQSXPZZiPO6Wjq+kCr/hwdYh198IRqN8eT66lioskj0Kyw==");
//		System.out.println(decrypt);
	}

	@Test
	public void testEncryptString() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		LunaInitializer initializer = new LunaInitializer();
		Cipher cipher = initializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE);

//        name
//                email
//        accessKeySptEmet
//                sptEmetClientId
//        npwp
//                membershipStartDate
//        membershipEndDate
		Map<String, Object> map = new HashMap<>();
		map.put("name", "testing-emetspt1");
		map.put("email", "testing-emetspt1@pajakku.com");
		map.put("accessKeySptEmet", "PVlGbKWxqtqzmEeaPlevGRSAwHnaDLTQAPdWVksA");
		map.put("sptEmetClientId", "rC0LgKHetE2TuT0tK2vONSh5CXvQgK78FN8n06AM");
		map.put("npwp", "023586498331000");
		map.put("membershipStartDate", "2021-12-31");
		map.put("membershipEndDate", "2022-01-25");

		String encrypt = initializer.encrypt(cipher, new Gson().toJson(map));
		System.out.println(encrypt);
	}

}