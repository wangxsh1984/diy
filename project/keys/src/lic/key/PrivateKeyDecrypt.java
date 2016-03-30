package lic.key;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class PrivateKeyDecrypt {
	private String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMoUPVpODiFRqyHuwwSiq1B8YFGk"
			+ "\r\n"
			+ "5+mbzu0m0n0Nz2daWQlduG80ED0AykwE0Gj4Tb2AC/6fKQ9+ymyqYgjjmJBybZFVZqop/+pRRkk6"
			+ "\r\n"
			+ "pCjjjuUuexZJzKT7EIaJCPf7AQeSEesPHWZ1thZTrWctOc8+Yy/fAFSAhERgajuQw/fHAgMBAAEC"
			+ "\r\n"
			+ "gYBgFgOePuMlIKoYtmjweVCwMpOx/pFvWPCpfv4zDDAEWsdfVrrt1XmrKAcI4nkekIKWip4pchCa"
			+ "\r\n"
			+ "F5W02cdHpsDRheqEbLIQvh5nnQk6DDCNvCXYhI6/ZRWfSyZHINW1HIi2ZtLwqpImiwgMu0u0FKqQ"
			+ "\r\n"
			+ "Gw4njsy90o5YNdTdajZCsQJBAOP5yFwl6c6hneMo4SCPwlheLJa2nHcL/dRWmGwb081fkVqhTQgr"
			+ "\r\n"
			+ "ALit2G12qgeDa7MOuK0ojRybtLJ97Jwbdz0CQQDi64J2HnMZq7QotN5OVuT8O+eUgP9FcaL88piI"
			+ "\r\n"
			+ "9wQvwGzWtDL86u3N3kwZs+SxImlY5z+i2Qn0flEciguQ+ntTAkEAoPw3D1M6is631rx8VWkO/SXr"
			+ "\r\n"
			+ "aLYlQS+3m+VWlykDZQhydURoSDdNuBwTNCFSqiGUwQnJQYXcN/KAJHclyYrfpQJBANOtnAqxxu8o"
			+ "\r\n"
			+ "dCwQ5NuxRXRiMVofp4FRSxio+U+zFe2xlBYJDRNP17vWZakIXgo7LoinV36C9j1j5Cg6QiXg808C"
			+ "\r\n"
			+ "QHuwNCIIJp12Oe4Bih4d59xzl2+uxADqJjcQ31FGhWrfoUe/ICOOCmbd+KbSQDU3Rbeozb4HSMku"
			+ "\r\n" + "+c16HMmDgAY=" + "\r\n";

	private Key getPrivateKey() {
		try {
			byte[] privateKey_ = Base64.decode(privateKey);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey_);
			return keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decryptSource(String source) {
		Key privateKey = this.getPrivateKey();
		try {
			byte[] source_ = Base64.decode(source);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] target = cipher.doFinal(source_);
			return new String(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
