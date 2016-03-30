package lic.key;

public class TestKey {
	public static void main(String[] args) {
		PublicKeyEncrypt pe = new PublicKeyEncrypt();
		String aa = pe.encryptSource("aaa");
		System.out.println(aa);
		PrivateKeyDecrypt pd = new PrivateKeyDecrypt();
		aa = pd.decryptSource(aa);
		System.out.println(aa);
	}
}
