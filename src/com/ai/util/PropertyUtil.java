package com.ai.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Desc:properties文件获取工具类 Created by fanny 2018-5-22
 */
public class PropertyUtil {
	private static final Logger logger = Logger.getLogger(PropertyUtil.class);
	static ResourceBundle resourceBundle;
	static Properties props;

	// static {
	// loadProps();
	// }

	/*
	 * decode.ip=10.248.32.33 监听本地端口、IP listen.ip=0.0.0.0 listen.port=8000
	 * 卡鉴权接口配置 hp.url=/sync/resmgnt/card/authen POST超时时间 hp.timeout=60
	 * hp.send.url=http://127.0.0.1:8889/sync/resmgnt/card/authen 网状网接口配置
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
		logger.info("开始加载properties文件内容.......");
		try {
			resourceBundle = ResourceBundle.getBundle("ods3");
		} catch (Exception e) {
			try {
				throw new FileNotFoundException(
						"加载配置文件ods3.properties出错............................");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		logger.info("加载properties文件内容完成...........");
		// getProperties();
		logger.info("properties文件内容********************" + printAllProperty(props));
		// logger.info("properties文件内容-DecodeIp：     " +
		// resourceBundle.getString("decode.ip"));
		// logger.info("properties文件内容-listenIp：     " +
		// resourceBundle.getString("listen.port"));
		// logger.info("properties文件内容-listenPort：" +
		// resourceBundle.getString("listen.port"));
		// logger.info("properties文件内容-HpUrl：             " +
		// resourceBundle.getString("hp.url"));
		// logger.info("properties文件内容-HpTimeOut：   " +
		// resourceBundle.getString("hp.timeout"));
		// logger.info("properties文件内容-HpSendUrl：   " +
		// resourceBundle.getString("hp.send.url"));
		// logger.info("properties文件内容-TsnUrl：           " +
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
