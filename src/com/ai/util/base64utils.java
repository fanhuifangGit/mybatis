package com.ai.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class base64utils {
	public static void main(String[] args) {
		String str = "Hello World";   
        String str2 = base64utils.base64encode(str);  
        System.out.println(str2);  
        String str1 = base64utils.base64decode(str2);  
        System.out.println(str1); 
	}
	 public static String base64encode(String message) {  
	        try {  
	            byte[] encodeBase64 = Base64.encodeBase64(message.getBytes("UTF-8"));  
	            System.out.println("º”√‹£∫Result:" + new String(encodeBase64));  
	            return new String(encodeBase64);  
	        } catch (UnsupportedEncodingException e) {  
	            throw new RuntimeException();  
	        }  
	  
	    }  
	      
	    public static String base64decode(String message) {  
	        byte[] encodeBase64 = Base64.decodeBase64(message);  
	        System.out.println("Ω‚√‹£∫Result:" + new String(encodeBase64));  
	        return new String(encodeBase64);  
	  
	    }  
}
