package com.logintest.util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemTimeDemo {


		public static String getTimeStamp(){
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			Date d = new Date();
			String timeStamp = sdf.format(d);
			System.out.println(timeStamp);
			return timeStamp;
		}
		
		public static String getDate()
		{
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			Date d = new Date();
			String timeStamp = sdf.format(d);
			System.out.println(timeStamp);
			return timeStamp;
}
}
