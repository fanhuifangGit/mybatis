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
	private static String KEY_STR = "myKeyRyanCai";// ��Կ
	private static String CHARSETNAME = "UTF-8";// ����
	private static String ALGORITHM = "DES";// ��������
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
		String username = "�û���";
		input(username);
		String psw = "����";
		input(psw);
	}

	public static void input(String str){
		BASE64Encoder base64encoder = new BASE64Encoder();
		byte[] doFinal;
		
			System.out.println("������"+str+"��");
			Scanner scan=new Scanner(System.in);
			String inputstr=scan.nextLine();
			
			System.out.println("��Ҫ���ܵ�"+str+"��:"+inputstr);
			try {
				byte[] bytes = inputstr.getBytes(CHARSETNAME);
				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, key);
				doFinal = cipher.doFinal(bytes);
				System.out.println(inputstr+"�������ܺ�"+str+"�ǣ�"+base64encoder.encode(doFinal));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}	
		
		
	}
}
