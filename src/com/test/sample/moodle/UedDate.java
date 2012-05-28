package com.test.sample.moodle;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedDate implements KvmSerializable {
	private String hour;
	private String minute;
	private String second;
	private String day;
	private String month;
	private String year;
	
	public UedDate () {}

	public UedDate (String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = "00";
		this.minute = "00";
		this.second = "00";		
	}
	
	public UedDate (String day, String month, String year, String hour, String minute, String second) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;		
	}
	
	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}
	
	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	/**
	 * @return the minute
	 */
	public String getMinute() {
		return minute;
	}
	
	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(String minute) {
		this.minute = minute;
	}
	
	/**
	 * @return the second
	 */
	public String getSecond() {
		return second;
	}
	
	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(String second) {
		this.second = second;
	}
	
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year + " - " + hour + ":" + minute + ":" + second;
	}


	public Object getProperty(int index) {
		switch (index) {
			case 0:
				return hour;
				
			case 1:
				return minute;
				
			case 2:
				return second;
				
			case 3:
				return day;
				
			case 4:
				return month;
				
			case 5:
				return year;
		}
		
		return null;
	}
	
	public int getPropertyCount() {
		return 6;
	}
	
	@SuppressWarnings("rawtypes")
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "hour";
				break;
			
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "minute";
				break;
			
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "second";
				break;
				
			case 3:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "day";
				break;
				
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "month";
				break;
				
			case 5:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "year";
				break;
		}
		
	}
	
	public void setProperty(int index, Object value) {
		switch (index) {
			case 0:
				hour = value.toString();
				break;
				
			case 1:
				minute = value.toString();
				break;
				
			case 2:
				second = value.toString();
				break;
				
			case 3:
				day = value.toString();
				break;
				
			case 4:
				month = value.toString();
				break;
				
			case 5:
				year = value.toString();
				break;
				
			default:
				break;
		}
	}
	
	
	public static UedDate createfromSoapObject(SoapObject obj) {
		try {
			UedDate ud = new UedDate();
			Object p;
			
			//hour - 0
			p = obj.getProperty(0);
			ud.setHour((p == null ? "N/A" : p.toString()));
			
			//minute - 1
			p = obj.getProperty(1);
			ud.setMinute((p == null ? "N/A" : p.toString()));
			
			//second - 2
			p = obj.getProperty(2);
			ud.setSecond((p == null ? "N/A" : p.toString()));
			
			//day - 3
			p = obj.getProperty(3);
			ud.setDay((p == null ? "N/A" : p.toString()));
			
			//month - 4
			p = obj.getProperty(4);
			ud.setMonth((p == null ? "N/A" : p.toString()));
			
			//year - 5
			p = obj.getProperty(5);
			ud.setYear((p == null ? "N/A" : p.toString()));
			
			
			return ud;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedDate: ", e);
			return null;
		}
	}

}
