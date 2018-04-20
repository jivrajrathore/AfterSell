package com.GladMinds.afterSell.GenericLib;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ReadProperties {
    private static ReadProperties obj = null;
    	Properties prop = null;
	private ReadProperties() throws UnsupportedEncodingException, IOException {
		 prop = new Properties();
		prop.load(new FileInputStream("config//config.properties"));
	}
	public static synchronized ReadProperties getInstence() throws UnsupportedEncodingException, IOException{
		if(obj==null) {
			obj = new ReadProperties();
		}
		return obj;
	}
       public  String getValue(String value) {
    	String name = prop.getProperty(value);
    	return name;
       }
}
