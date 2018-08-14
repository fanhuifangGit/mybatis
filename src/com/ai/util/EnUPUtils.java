package com.ai.util;

import java.security.Key;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Encoder;

public class EnUPUtils {
	private static Key key;
	private static String KEY_STR = "myKeyRyanCai";// 密钥
	private static String CHARSETNAME = "UTF-8";// 编码
	private static String ALGORITHM = "DES";// 加密类型
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws ParseException {
		String username = "用户名";
		input(username);
		String psw = "密码";
		input(psw);
	}

	public static void input(String str){
		BASE64Encoder base64encoder = new BASE64Encoder();
		byte[] doFinal;
		
			System.out.println("请输入"+str+"：");
			Scanner scan=new Scanner(System.in);
			String inputstr=scan.nextLine();
			
			System.out.println("需要加密的"+str+"是:"+inputstr);
			try {
				byte[] bytes = inputstr.getBytes(CHARSETNAME);
				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, key);
				doFinal = cipher.doFinal(bytes);
				System.out.println(inputstr+"经过加密后，"+str+"是："+base64encoder.encode(doFinal));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}	
		
		
	}
}
