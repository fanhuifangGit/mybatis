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

	public static void init() {

		InputStream cfgStream = null;
		Reader cfgReader = null;
		InputStream proStream = null;
		Reader proReader = null;
		Properties properties = new Properties();

		try {
			// 读入Mybatis配置文件
			cfgStream = Resources.getResourceAsStream("conf/mybaitsconfig.xml");
			cfgReader = new InputStreamReader(cfgStream);// cfgReader依赖于cfgStream，先关闭cfgStream
			String realPath = "/mybatis.properties";
			ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatis");
			String username = resourceBundle.getString("jdbc.username");
			String pwd = resourceBundle.getString("jdbc.password");
			if (username == null||pwd==null) {
				throw new RuntimeException("没有该属性的值：" + key);
			}
			// Resources.class此类的读取配置文件的方法只能读取项目下的配置文件
			proStream = Resources.class.getResourceAsStream(realPath);
			proReader = new InputStreamReader(proStream);
			properties.load(proReader);
			// 打印properties数据
			// printProperties(properties);
			// String username=properties.getProperty("jdbc.username");
			// String password=properties.getProperty("jdbc.password");
			// int lenpassword=password.length();
			// if(lenpassword<12){//从配置文件读取的密码的长度<7的时候就没有加密，此时就进行加密
			// System.out.println("--------加密操作 start-------------");
			// //加密操作
			// System.out.println("加密的用户名是："+username+",加密的密码是："+password);
			// String newUserName = sqlNameAndPasswordEcode("jdbc.username",properties.getProperty("jdbc.username"));
			// String newUserPassword =sqlNameAndPasswordEcode("jdbc.password",properties.getProperty("jdbc.password"));
			// //将新的用户名和密码写入配置文件
			// properties.setProperty("jdbc.username",newUserName);
			// properties.setProperty("jdbc.password",newUserPassword);
			// printProperties("加密后：",properties);
			// System.out.println("--------加密操作 end-------------");
			// }else{//从配置文件读取的密码的长度>7的时候就没有加密，此时就进行加密
			// System.out.println("--------解密操作 start-------------");
			// 解密操作
			// System.out.println("解密的用户名是："+username+",解密的密码是："+password);
			String deUserName = sqlNameAndPasswordDecode("jdbc.username",username);
			String dewUserPassword = sqlNameAndPasswordDecode("jdbc.password",pwd);
			// 将解密后的用户名和密码写入配置文件
			properties.setProperty("jdbc.username", deUserName);
			properties.setProperty("jdbc.password", dewUserPassword);
			// printProperties("解密后：",properties);
			// System.out.println("--------解密操作 end-------------");
			System.out.println("--------用户名和密码已解密-------------");
			// }
			// 创建sqlSessionFactory
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

	// 打印属性信息
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


	/** 解密 */
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
	 * 对str进行DES加密
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
	 * 对str进行DES解密
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

	// 关闭流的同样同意操作
	public static void closeIO(InputStream inputstream, Reader reader) {
		try {
			if (inputstream != null) {
				inputstream.close();// 如果此处出现异常，流也会被关闭
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();// 如果此处出现异常，流也会被关闭
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
