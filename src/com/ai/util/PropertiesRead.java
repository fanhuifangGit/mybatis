package com.ai.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PropertiesRead {
	private static SqlSessionFactory sqlSessionFactory;
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

	public static void init() {

		InputStream cfgStream = null;
		Reader cfgReader = null;
		InputStream proStream = null;
		Reader proReader = null;
		Properties properties = new Properties();

		try {
			// ����Mybatis�����ļ�
			cfgStream = Resources.getResourceAsStream("conf/mybaitsconfig.xml");
			cfgReader = new InputStreamReader(cfgStream);// cfgReader������cfgStream���ȹر�cfgStream
			String realPath = "/mybatis.properties";
			ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatis");
			String username = resourceBundle.getString("jdbc.username");
			String pwd = resourceBundle.getString("jdbc.password");
			if (username == null||pwd==null) {
				throw new RuntimeException("û�и����Ե�ֵ��" + key);
			}
			// Resources.class����Ķ�ȡ�����ļ��ķ���ֻ�ܶ�ȡ��Ŀ�µ������ļ�
			proStream = Resources.class.getResourceAsStream(realPath);
			proReader = new InputStreamReader(proStream);
			properties.load(proReader);
			// ��ӡproperties����
			// printProperties(properties);
			// String username=properties.getProperty("jdbc.username");
			// String password=properties.getProperty("jdbc.password");
			// int lenpassword=password.length();
			// if(lenpassword<12){//�������ļ���ȡ������ĳ���<7��ʱ���û�м��ܣ���ʱ�ͽ��м���
			// System.out.println("--------���ܲ��� start-------------");
			// //���ܲ���
			// System.out.println("���ܵ��û����ǣ�"+username+",���ܵ������ǣ�"+password);
			// String newUserName = sqlNameAndPasswordEcode("jdbc.username",properties.getProperty("jdbc.username"));
			// String newUserPassword =sqlNameAndPasswordEcode("jdbc.password",properties.getProperty("jdbc.password"));
			// //���µ��û���������д�������ļ�
			// properties.setProperty("jdbc.username",newUserName);
			// properties.setProperty("jdbc.password",newUserPassword);
			// printProperties("���ܺ�",properties);
			// System.out.println("--------���ܲ��� end-------------");
			// }else{//�������ļ���ȡ������ĳ���>7��ʱ���û�м��ܣ���ʱ�ͽ��м���
			// System.out.println("--------���ܲ��� start-------------");
			// ���ܲ���
			// System.out.println("���ܵ��û����ǣ�"+username+",���ܵ������ǣ�"+password);
			String deUserName = sqlNameAndPasswordDecode("jdbc.username",username);
			String dewUserPassword = sqlNameAndPasswordDecode("jdbc.password",pwd);
			// �����ܺ���û���������д�������ļ�
			properties.setProperty("jdbc.username", deUserName);
			properties.setProperty("jdbc.password", dewUserPassword);
			// printProperties("���ܺ�",properties);
			// System.out.println("--------���ܲ��� end-------------");
			System.out.println("--------�û����������ѽ���-------------");
			// }
			// ����sqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfgReader,properties);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			closeIO(cfgStream, cfgReader);
			closeIO(proStream, proReader);
		}
	}

	public static SqlSession getSqlSession() {
		return PropertiesRead.sqlSessionFactory.openSession();
	}

	// ��ӡ������Ϣ
	public static void printProperties(String type, Properties properties) {

		@SuppressWarnings("unchecked")
		Enumeration<String> enu = (Enumeration<String>) properties
				.propertyNames();

		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			if (name.equals("jdbc.username") || name.equals("jdbc.password")) {
				System.out.println(type + "" + name + ":"
						+ properties.getProperty(name));
			}
		}
	}


	/** ���� */
	public static String sqlNameAndPasswordDecode(String decodename,
			String decodevalue) {

		if (decodename.equals("jdbc.username")) {
			return getDecryptString(decodevalue);

		} else if (decodename.equals("jdbc.password")) {
			return getDecryptString(decodevalue);
		} else {
			return null;
		}

	}

	/**
	 * ��str����DES����
	 * 
	 * @param str
	 * @return
	 */
	// public static String getEncryptString(String str) {
	// BASE64Encoder base64encoder = new BASE64Encoder();
	// try {
	// byte[] bytes = str.getBytes(CHARSETNAME);
	// Cipher cipher = Cipher.getInstance(ALGORITHM);
	// cipher.init(Cipher.ENCRYPT_MODE, key);
	// byte[] doFinal = cipher.doFinal(bytes);
	// return base64encoder.encode(doFinal);
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }

	/**
	 * ��str����DES����
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		BASE64Decoder base64decoder = new BASE64Decoder();
		try {
			byte[] bytes = base64decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] doFinal = cipher.doFinal(bytes);
			return new String(doFinal, CHARSETNAME);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// �ر�����ͬ��ͬ�����
	public static void closeIO(InputStream inputstream, Reader reader) {
		try {
			if (inputstream != null) {
				inputstream.close();// ����˴������쳣����Ҳ�ᱻ�ر�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();// ����˴������쳣����Ҳ�ᱻ�ر�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
