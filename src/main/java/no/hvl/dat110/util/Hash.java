package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");

			// compute the hash of the input 'entity'
			byte[] hash = md.digest(entity.getBytes());

			// convert the hash into hex format
			String hex = toHex(hash);

			// convert the hex into BigInteger
			BigInteger hashBigInt = new BigInteger(hex, 16);

			// return the BigInteger
			return hashBigInt;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// compute the number of bits = bitSize()
		int bits = bitSize();

		// compute the address size = 2 ^ number of bits
		BigInteger bigInt = BigInteger.valueOf(2).pow(bits);

		// return the address size
		return bigInt;
	}

	public static int bitSize() {

		int digestlen = 16;

		// find the digest length
		return digestlen*8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}
}
