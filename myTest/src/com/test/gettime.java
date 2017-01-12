package com.test;

import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date; 

public class gettime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
		Date dt=new Date();
        System.out.println(dt);
	}

}
