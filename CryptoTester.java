/**
 * Based on the DevMedia article:
 * https://www.devmedia.com.br/utilizando-criptografia-simetrica-em-java/31170
 * 
 * @author Matheus Teles
 */
public class CryptoTester {

	static String IV = "AAAAAAAAAAAAAAAA";
	static String originalText = "Hello World!";
	static String cryptographyKey = "1234567890123456";

	public static void main(String[] args) throws Exception {
		System.out.println("Original text: " + originalText);
		
		Encrypter e = new Encrypter(IV, originalText, cryptographyKey);
		byte[] encryptedText = e.encrypt();		
		System.out.println("Encrypted text: " + printEncrypted(encryptedText));
		
		Decrypter d = new Decrypter(IV, encryptedText, cryptographyKey);
		System.out.println("Decrypted text: " + d.decrypt());
	}
	
	private static String printEncrypted(byte[] encryptedText) {
		String e = new String();
		
		for(int i = 0; i < encryptedText.length; i++) {
			e += encryptedText[i] + " ";
		}
		
		return e;
	}
	
}
