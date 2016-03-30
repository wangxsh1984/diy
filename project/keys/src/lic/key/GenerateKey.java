package lic.key;

import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class GenerateKey {
	private String privateKey;
	private String publicKey;

	public GenerateKey() {
		/** RSA算法要求有一个可信任的随机数源 */
		SecureRandom sr = new SecureRandom();
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024, sr);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			Key privateKey = keyPair.getPrivate();
			Key publicKey = keyPair.getPublic();
			this.privateKey = this.encryptBASE64(privateKey.getEncoded());
			this.publicKey = this.encryptBASE64(publicKey.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public byte[] decryptBASE64(String key) {
		try {
			return (new BASE64Decoder()).decodeBuffer(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encryptBASE64(byte[] key) {
		return (new BASE64Encoder()).encodeBuffer(key);
	}
}
