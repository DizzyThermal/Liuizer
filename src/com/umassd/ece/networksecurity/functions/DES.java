package com.umassd.ece.networksecurity.functions;

import com.umassd.ece.networksecurity.constants.DESConstants;

public class DES {
	
	/**
	 * Input HEX key text.
	 */
	private static String keyIn;
	/**
	 * Binary version of the <b>ENCODED</b> key.
	 */
	private static String keyBin;
	/**
	 * Input message text.
	 */
	private static String messageIn;
	/**
	 * Binary version of the <b>OUTPUT</b> message.
	 */
	private static String messageBin;
	/**
	 * Binary version of the <b>PC1</b> step of the key.
	 */
	private static String PC1;
	/**
	 * Binary version of the <b>C1</b> step of the key.
	 */
	private static String C1;
	/**
	 * Binary version of the <b>D1</b> step of the key.
	 */
	private static String D1;

	public DES() {
		this.keyIn = "";
		this.messageIn = "";
	}
	
	public DES(String key, String message) {
		this.keyIn = key;
		generateKey();
		this.messageIn = message;
		generateMessage();
	}
	
	private static void generateKey() {
		keyBin = hexToBinary(keyIn);
		PC1 = keyBin.substring(0,7) + keyBin.substring(8,15) + keyBin.substring(16,23) + keyBin.substring(24,31) +
				keyBin.substring(32,39) + keyBin.substring(40,47) + keyBin.substring(48,55) + keyBin.substring(56,63);
		C1 = PC1.substring(0,28);
		D1 = PC1.substring(28,55);
		//keyBin = permute(PC1,DESConstants.PC2Order)
	}
	
	private static void generateMessage() {
		
	}
	
	/*private static String getKeyHex() {	}
	private static String getMessageHex() {	}
	private static String getKeyBin() {	}
	private static String getMessageBin() {	}*/
	
	public static String binaryToHex(String binary) {
		return Integer.toHexString(Integer.parseInt(binary,2)).toUpperCase();
	}
	public static String hexToBinary(String hex) {
		return Integer.toBinaryString(Integer.parseInt(hex,16));
	}
	
	private static String xor(String binary1, String binary2) {
		String out = "";
		for(int i = 0; i < binary1.length(); i++) {
			out += (binary1.charAt(i) == binary2.charAt(i))?("0"):("1");
		}
		return out;
	}
}
