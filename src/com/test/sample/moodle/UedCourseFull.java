package com.test.sample.moodle;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;


public class UedCourseFull extends UedCourse {
	private String directLink;

	/**
	 * @return the directLink
	 */
	public String getDirectLink() {
		return directLink;
	}

	/**
	 * @param directLink the directLink to set
	 */
	public void setDirectLink(String directLink) { 
		this.directLink = directLink;
	}
	
	public static UedCourseFull createfromSoapObject(SoapObject obj) {
		try {
			UedCourseFull ucf = new UedCourseFull();
			Object p;
			
			//direct link - 0
			p = obj.getProperty(0);
			ucf.setDirectLink((p == null ? "N/A" : p.toString()));
			
			//id - 1
			p = obj.getProperty(1);
			ucf.setId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//short name - 2
			p = obj.getProperty(2);
			ucf.setShortName((p == null ? "N/A" : p.toString()));
			
			//id number - 3
			p = obj.getProperty(3);
			ucf.setIdNumber((p == null ? "N/A" : p.toString()));
			
			//category - 4
			p = obj.getProperty(4);
			ucf.setCategory(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//full name - 5
			p = obj.getProperty(5);
			ucf.setFullName((p == null ? "N/A" : p.toString()));
			
			//summary - 6
			p = obj.getProperty(6);
			ucf.setSummary((p == null ? "N/A" : p.toString()));
			
			//visible - 7
			p = obj.getProperty(7);
			ucf.setVisible(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//news items - 8
			p = obj.getProperty(8);
			ucf.setNewsItems((p == null ? "N/A" : p.toString()));
			
			//full link - 9
			p = obj.getProperty(9);
			ucf.setFullLink((p == null ? "N/A" : p.toString()));
			
			//start date - 10
			p = obj.getProperty(10);
			SoapObject uedDate = (SoapObject) p;
			ucf.setStartDate(UedDate.createfromSoapObject(uedDate));
			
			//enrollable - 11
			p = obj.getProperty(11);
			ucf.setEnrollable(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//enrol Start Date - 12
			p = obj.getProperty(12);
			ucf.setEnrolStartDate(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//enrol End Date - 13
			p = obj.getProperty(13);
			ucf.setEnrolEndDate(p == null ? 0 : Integer.parseInt(p.toString()));
			
			return ucf;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedCourseFull: ", e);
			return null;
		}
	}
	
}
