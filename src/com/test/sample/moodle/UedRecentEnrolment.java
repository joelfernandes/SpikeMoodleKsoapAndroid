package com.test.sample.moodle;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedRecentEnrolment {
	private int userId;
	private int courseId;
	private String userFullName;
	private String userProfileLink;
	private UedDate date;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	
	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * @return the userFullName
	 */
	public String getUserFullName() {
		return userFullName;
	}
	
	/**
	 * @param userFullName
	 *            the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	/**
	 * @return the userProfileLink
	 */
	public String getUserProfileLink() {
		return userProfileLink;
	}
	
	/**
	 * @param userProfileLink
	 *            the userProfileLink to set
	 */
	public void setUserProfileLink(String userProfileLink) {
		this.userProfileLink = userProfileLink;
	}
	
	/**
	 * @return the date
	 */
	public UedDate getDate() {
		return date;
	}
	
	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(UedDate date) {
		this.date = date;
	}

	public static UedRecentEnrolment createfromSoapObject(SoapObject obj) {
		try {
			UedRecentEnrolment ure = new UedRecentEnrolment();
			Object p;
			System.out.println(obj.toString());
			//user Id - 0
			p = obj.getProperty(0);
			ure.setUserId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//course Id - 1
			p = obj.getProperty(1);
			ure.setCourseId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//user full name  - 2
			p = obj.getProperty(2);
			ure.setUserFullName(p == null ? "N/A" : p.toString());
			
			//user profile link  - 3
			p = obj.getProperty(3);
			ure.setUserProfileLink(p == null ? "N/A" : p.toString());
			
			//date - 4
			p = obj.getProperty(4);
			ure.setDate(UedDate.createfromSoapObject((SoapObject) p));
			
			return ure;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedRecentEnrolment: ", e);
			return null;
		}
	}
}
