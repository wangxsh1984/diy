package lic.key;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class PublicKeyEncrypt {
	private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKFD1aTg4hUash7sMEoqtQfGBRpOfpm87tJtJ9"
			+ "\r\n"
			+ "Dc9nWlkJXbhvNBA9AMpMBNBo+E29gAv+nykPfspsqmII45iQcm2RVWaqKf/qUUZJOqQo447lLnsW"
			+ "\r\n"
			+ "Scyk+xCGiQj3+wEHkhHrDx1mdbYWU61nLTnPPmMv3wBUgIREYGo7kMP3xwIDAQAB"
			+ "\r\n";

	private Key getPublicKey() {
		try {
			byte[] publicKey_ = Base64.decode(publicKey);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey_);
			return keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encryptSource(String source) {
		Key publicKey = this.getPublicKey();
		String target = "";
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] source_ = source.getBytes();
			byte[] target_ = cipher.doFinal(source_);
			target = Base64.encode(target_);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}
}
