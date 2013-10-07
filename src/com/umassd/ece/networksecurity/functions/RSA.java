package com.umassd.ece.networksecurity.functions;

import java.math.BigInteger;
import java.util.ArrayList;

public class RSA
{
	public static ArrayList<String> encrypt(BigInteger p, BigInteger q, BigInteger e, BigInteger M)
	{
		ArrayList<String> output = new ArrayList<String>();
		BigInteger n = p.multiply(q); 
		BigInteger z = (p.subtract(BigInteger.valueOf(1))).multiply(q.subtract(BigInteger.valueOf(1)));
		
		output.add("p = " + p);
		output.add("q = " + q);
		output.add("e = " + e);
		output.add("M = " + M);
		output.add("");
		output.add("n = (p)(q) = (" + p + ")(" + q + ") = " + n);
		output.add("z = (p-1)(q-1) = (" + p + "-1)(" + q + "-1) = " + z);
		output.add("");
		BigInteger d = e.modInverse(z);
		
		output.add("d = gcd(e, z) = " + d);
		output.add("");

		BigInteger enc = M;
		enc = enc.modPow(e, n);
		
		BigInteger dec = enc;
		dec = dec.modPow(d, n);

		output.add("Encrypted Output = " + enc);
		output.add("Decrypted Output (Check) = " + dec);
		
		return output;
	}
}
