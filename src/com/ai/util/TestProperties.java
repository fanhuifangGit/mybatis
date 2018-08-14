package com.ai.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

//import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * @ClassName: TestProperties
 * @Description: 获取配置文件信息
 * @date: 2017年11月25日 上午10:56:00
 * @version: 1.0.0
 */
public class TestProperties {

	public static void main(String[] args) { // 注意路径问题
		System.out.println("*********************************************");
		PropertyUtil.loadProps();
		System.out.println("*********************************************");
	}
}