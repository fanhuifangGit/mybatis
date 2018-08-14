package com.ai.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Desc:properties�ļ���ȡ������ Created by fanny 2018-5-22
 */
public class PropertyUtil {
	private static final Logger logger = Logger.getLogger(PropertyUtil.class);
	static ResourceBundle resourceBundle;
	static Properties props;

	// static {
	// loadProps();
	// }

	/*
	 * decode.ip=10.248.32.33 �������ض˿ڡ�IP listen.ip=0.0.0.0 listen.port=8000
	 * ����Ȩ�ӿ����� hp.url=/sync/resmgnt/card/authen POST��ʱʱ�� hp.timeout=60
	 * hp.send.url=http://127.0.0.1:8889/sync/resmgnt/card/authen ��״���ӿ�����
	 * tsn.url=/sync/interboss/inteross/sysmgr
	 */
	public static String getDecodeIp() {
		loadProps();
		return resourceBundle.getString("decode.ip");

	}

	public static String getlistenIp() {
		loadProps();
		return resourceBundle.getString("listen.ip");

	}

	public static String getlistenPort() {
		loadProps();
		return resourceBundle.getString("listen.port");
	}

	public static String getHpUrl() {
		loadProps();
		return resourceBundle.getString("hp.url");

	}

	public static String getHpTimeOut() {
		loadProps();
		return resourceBundle.getString("hp.timeout");

	}

	public static String getHpSendUrl() {
		loadProps();
		return resourceBundle.getString("hp.send.url");

	}

	public static String getTsnUrl() {
		loadProps();
		return resourceBundle.getString("tsn.url");
	}

	public static void loadProps() {
		logger.info("��ʼ����properties�ļ�����.......");
		try {
			resourceBundle = ResourceBundle.getBundle("ods3");
		} catch (Exception e) {
			try {
				throw new FileNotFoundException(
						"���������ļ�ods3.properties����............................");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("����properties�ļ��������...........");
		// getProperties();
		logger.info("properties�ļ�����********************" + printAllProperty(props));
		// logger.info("properties�ļ�����-DecodeIp��     " +
		// resourceBundle.getString("decode.ip"));
		// logger.info("properties�ļ�����-listenIp��     " +
		// resourceBundle.getString("listen.port"));
		// logger.info("properties�ļ�����-listenPort��" +
		// resourceBundle.getString("listen.port"));
		// logger.info("properties�ļ�����-HpUrl��             " +
		// resourceBundle.getString("hp.url"));
		// logger.info("properties�ļ�����-HpTimeOut��   " +
		// resourceBundle.getString("hp.timeout"));
		// logger.info("properties�ļ�����-HpSendUrl��   " +
		// resourceBundle.getString("hp.send.url"));
		// logger.info("properties�ļ�����-TsnUrl��           " +
		// resourceBundle.getString("tsn.url"));
	}

	private static String printAllProperty(Properties props) {
		String key = null;
		String value = null;
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			key = (String) en.nextElement();
			value = props.getProperty(key);
		}
		return key + " : " + value;
	}

}
