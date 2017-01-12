package com.test;

import java.util.Properties;
import java.io.*;

public class PropertyHelper {
	private static final PropertyHelper instance= new PropertyHelper();
	private static Properties p=null;
	
	private PropertyHelper()
	{
		
	}
	
	public static PropertyHelper getInstance(){
		return instance;
	}
	
	public String getProperty(String s, InputStream inStream)
	{
		String temp="";
		try {
			if(p==null){
			p = new Properties();
			p.load(inStream);
			}
			temp = p.getProperty(s).toString().trim();
				
		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
		
		return temp;
		
	}
	  

}
