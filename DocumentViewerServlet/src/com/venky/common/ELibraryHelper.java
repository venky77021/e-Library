package com.venky.common;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ELibraryHelper {
	/**
	 * This method is used to generate hash code for the password
	 * 
	 * @param input
	 * @return
	 */
	public String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hash.toString();
	}

	/**
	 * This method is used to generate otp
	 * 
	 * @return
	 */
	public String generateOtp() {
		int randomPin = (int) (Math.random() * 90000) + 10000;
		String otp = String.valueOf(randomPin);
		return otp;
	}

	/**
	 * This method is used to validate the email enter in the user registration
	 * form
	 * 
	 * @param eMail
	 * @return
	 */
	public boolean CheckEmail(String eMail) {
		boolean st = false;
		String dummy = eMail;
		Pattern p = Pattern.compile(ELibraryConstants.EMAIL_CHECK);
		Matcher m = p.matcher(dummy);
		if (m.find() && m.group().equals(dummy)) {

			st = true;
		} else {
			st = false;
		}
		return st;
	}

	/**
	 * This method is used to get the files present in the specific path
	 * @return
	 */
	public String[] getFileNames() {
		Properties prop = LoadProperties.getProperties();
		String[] resultFileName = null;
		File file = new File(prop.getProperty("dcoRepository"));
		String fileName = "";
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				fileName = fileName + "," + files[i].getPath();
			}
		}
		resultFileName = fileName.substring(1).split(",");
		return resultFileName;
	}

	/*
	 * public static void main(String[] args) { ELibraryHelper elh = new
	 * ELibraryHelper(); String[] result = elh.getFileNames(); for (String r :
	 * result){
	 * System.out.println(r.substring(r.lastIndexOf("\\")+1,r.lastIndexOf('.')))
	 * ; } }
	 */
}
