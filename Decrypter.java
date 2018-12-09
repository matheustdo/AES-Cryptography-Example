import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Based on the DevMedia article:
 * https://www.devmedia.com.br/utilizando-criptografia-simetrica-em-java/31170
 * 
 * @author Matheus Teles
 */
public class Decrypter {

	private String IV;
	private byte[] encryptedText;
	private String cryptographyKey;

	public Decrypter(String IV, byte[] encryptedText, String cryptographyKey) {
		this.IV = IV;
		this.encryptedText = encryptedText;
		this.cryptographyKey = cryptographyKey;
	}

	public String decrypt() throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(cryptographyKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(cipher.doFinal(encryptedText), "UTF-8");
	}

}
