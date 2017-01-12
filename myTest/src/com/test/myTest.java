package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class myTest {
	private static String commonConfig = "E:/data/common.properties";

	public static void main(String args[]) throws ParseException {
		String data = "1.0E-4";
		Double d1 = parseToDouble(data);
		Double d2 = 0.0;
		Double res = (d1 + d2) / 2;
		System.out.println(res);
		Double t = 0.0;
		if (t == 0) {
			System.out.println("the same");
		} else {
			System.out.println("diff");
		}
		System.out.println(getOneHoursAgoTime());
		
		getLastHour();
		getLastDay();
		
		double data1 = 0.045329;
		String res1 = String.format("%.2f", data1*100)+"%";
		System.out.println("res1="+res1);
		Long l1 =(long) 8.4;
		Long l2 = (long) 2.0;
		System.out.println("l1/l2="+(long)l1/l2);
	}

	public static String getLastHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) -1);
		
		String day = getToday(calendar.getTime());
		String hour = getHour(calendar.getTime());
		
		System.out.println("һ��Сʱǰ��ʱ�䣺" + day+hour);
		return day+hour;
	}
	
	public static String getLastDay() {  
        Calendar calendar = Calendar.getInstance();  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        String month = getMonth(calendar.getTime());
        String day = getToday(calendar.getTime());
        
        System.out.println("һ��ǰ��ʱ�䣺" + month+day);
        return day;  
    }  
	
	public static final String getDate(Date time, String dateFormat){
		SimpleDateFormat date = new SimpleDateFormat(dateFormat);
		return date.format(time);
	}
	
	public static final String getMonth(Date time){
		return getDate(time, "MM");
	}
	
	public static final String getToday(Date time){
		return getDate(time, "dd");
	}
	
	public static final String getHour(Date time){
		return getDate(time, "HH");
	}

	public static String getOneHoursAgoTime() {
		String oneHoursAgoTime = "";
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, Calendar.HOUR - 1); // ��ʱ������Ϊ��ǰʱ��-1Сʱ��ͬ��Ҳ������������ʱ��
		cal.set(Calendar.MONTH, Calendar.MONTH); // ��ǰ��ǰһ��
		oneHoursAgoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(cal.getTime());// ��ȡ��������ʱ��
		return oneHoursAgoTime;
	}

	public static Double parseToDouble(Object value) {
		String valueStr = (String) value;
		if (null != valueStr && valueStr.length() > 0) {
			return Double.valueOf(valueStr);
		}
		return null;
	}
}
