package com.ai.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

//import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * @ClassName: TestProperties
 * @Description: ��ȡ�����ļ���Ϣ
 * @date: 2017��11��25�� ����10:56:00
 * @version: 1.0.0
 */
public class TestProperties {

	public static void main(String[] args) { // ע��·������
		System.out.println("*********************************************");
		PropertyUtil.loadProps();
		System.out.println("*********************************************");
	}
}