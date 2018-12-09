import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Based on the DevMedia article:
 * https://www.devmedia.com.br/utilizando-criptografia-simetrica-em-java/31170
 * 
 * @author Matheus Teles
 */
public class Encrypter {
	
	private String IV;
	private String originalText;
	private String cryptographyKey;

	public Encrypter(String IV, String originalText, String cryptographyKey) {
		this.IV = IV;
		this.originalText = originalText;
		this.cryptographyKey = cryptographyKey;
	}

	public byte[] encrypt() throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(cryptographyKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return cipher.doFinal(originalText.getBytes("UTF-8"));
	}

}
