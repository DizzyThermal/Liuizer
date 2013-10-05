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
	/** 
	 * Binary version of the <b>L0</b> step of the message output. 
	 */
	private static String L0;
	/** 
	 * Binary version of the <b>R0</b> step of the message output
	 */
	private static String R0;
	/** 
	 * Binary version of the <b>E[R0]</b> step of the message output. 
	 */
	private static String ER0;
	/** 
	 * Binary version of the <b>E[R0] xor with K</b> step of the message output.
	 */
	private static String ERxorK;
	/** 
	 * Binary version of the <b>B</b> step of the message output.
	 */
	private static String B;
	/** 
	 * Binary version of the <b>P(B)</b> step of the message output.
	 */
	private static String PB;

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
		PC1 = permute(keyBin,DESConstants.PC1Order);
		C1 = PC1.substring(1,28) + PC1.charAt(0);
		D1 = PC1.substring(29,56) + PC1.charAt(28);
		keyBin = permute(C1+D1,DESConstants.PC2Order);
		binaryToHex(keyBin);
	}
	
	private static String permute(String initial, int[] order) {
		String out = "";
		for (int i = 0; i < order.length; i++) {
			out += initial.charAt(order[i]-1);
		}
		return out;
	}
	
	private static void generateMessage() {
		messageBin = hexToBinary(messageIn);
		L0 = permute(messageBin,DESConstants.L0Order);
		R0 = permute(messageBin,DESConstants.R0Order);
		ER0 = eTable();
		ERxorK = xor(ER0,keyBin);
		B = sboxSubstitution();
		PB = permute(B,DESConstants.Permute);
		messageBin = xor(PB,L0);
	}
	
	private static String sboxSubstitution() {
		String out = "";
		int row, column, bounds = 0;
		String bits = "";
		for(int i = 0; i < DESConstants.SBox.size(); i++) {
			bits = ERxorK.substring(bounds, bounds+6);
			row = Integer.parseInt(""+bits.charAt(0)+bits.charAt(5),2);
			column = Integer.parseInt(bits.substring(1,5),2);
			out += String.format("%4s",Integer.toBinaryString(DESConstants.SBox.get(i)[row][column])).replace(' ','0');
			bounds += 6;
		}
		return out;
	}
	
	private static String eTable() {
		String out = "";
		out = R0.charAt(31) + R0.substring(0,4) + R0.charAt(4);
		out += R0.charAt(3) + R0.substring(4,8) + R0.charAt(8);
		out += R0.charAt(7) + R0.substring(8,12) + R0.charAt(12);
		out += R0.charAt(11) + R0.substring(12,16) + R0.charAt(16);
		out += R0.charAt(15) + R0.substring(16,20) + R0.charAt(20);
		out += R0.charAt(19) + R0.substring(20,24) + R0.charAt(24);
		out += R0.charAt(23) + R0.substring(24,28) + R0.charAt(28);
		out += R0.charAt(27) + R0.substring(28,32) + R0.charAt(0);
		return out;
	}
	/*private static String getKeyHex() {	}
	private static String getMessageHex() {	}
	private static String getKeyBin() {	}
	private static String getMessageBin() {	}*/
	
	public static String binaryToHex(String binary) {
		String out = "";
		for(int i = 0; i < binary.length(); i+=4) { 
			out += Integer.toHexString(Integer.parseInt(binary.substring(i,i+4),2)).toUpperCase();
		}
		return out;
	}
	public static String hexToBinary(String hex) {
		String out = "";
		for (int i = 0; i < hex.length(); i++) {
			out += String.format("%4s",Integer.toBinaryString(Integer.parseInt("" + hex.charAt(i),16))).replace(' ','0');
		}
		return out;
	}
	
	private static String xor(String binary1, String binary2) {
		String out = "";
		for(int i = 0; i < binary1.length(); i++) {
			out += (binary1.charAt(i) == binary2.charAt(i))?("0"):("1");
		}
		return out;
	}
}
