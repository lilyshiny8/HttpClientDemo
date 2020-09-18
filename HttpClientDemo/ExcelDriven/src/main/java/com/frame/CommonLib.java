package com.frame;


import java.util.Calendar;


public class CommonLib {
	public static  String getCurrentTime() {

	   Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH);
		int day = ca.get(Calendar.DATE);
		int minute = ca.get(Calendar.MINUTE);
		int hour = ca.get(Calendar.HOUR);
		int second = ca.get(Calendar.SECOND);
		String currentTime=(String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
				+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
				+ String.valueOf(minute) + "-" + String.valueOf(second));
	
		
		return currentTime;
   }
  
   
	public static void sleep(int p_time){
		
		try {
			Thread.sleep(p_time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

   

}