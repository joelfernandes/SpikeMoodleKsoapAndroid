package com.test.sample.moodle;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;


public class UedCourse {
	private int id;
	private String shortName;
	private String idNumber;
	private int category;
	private String fullName;
	private String summary;
	private int visible;
	private String newsItems;
	private String fullLink;
	private UedDate startDate;
	private int enrollable;
	private int enrolStartDate;
	private int enrolEndDate;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}
	
	/**
	 * @param idNumber
	 *            the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
	
	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	
	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	/**
	 * @return the visible
	 */
	public int getVisible() {
		return visible;
	}
	
	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	/**
	 * @return the newsItems
	 */
	public String getNewsItems() {
		return newsItems;
	}
	
	/**
	 * @param newsItems
	 *            the newsItems to set
	 */
	public void setNewsItems(String newsItems) {
		this.newsItems = newsItems;
	}
	
	/**
	 * @return the fullLink
	 */
	public String getFullLink() {
		return fullLink;
	}
	
	/**
	 * @param fullLink
	 *            the fullLink to set
	 */
	public void setFullLink(String fullLink) {
		this.fullLink = fullLink;
	}
	
	/**
	 * @return the startDate
	 */
	public UedDate getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(UedDate startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the enrollable
	 */
	public int getEnrollable() {
		return enrollable;
	}
	
	/**
	 * @param enrollable
	 *            the enrollable to set
	 */
	public void setEnrollable(int enrollable) {
		this.enrollable = enrollable;
	}
	
	/**
	 * @return the enrolStartDate
	 */
	public int getEnrolStartDate() {
		return enrolStartDate;
	}
	
	/**
	 * @param enrolStartDate
	 *            the enrolStartDate to set
	 */
	public void setEnrolStartDate(int enrolStartDate) {
		this.enrolStartDate = enrolStartDate;
	}
	
	/**
	 * @return the enrolEndDate
	 */
	public int getEnrolEndDate() {
		return enrolEndDate;
	}
	
	/**
	 * @param enrolEndDate
	 *            the enrolEndDate to set
	 */
	public void setEnrolEndDate(int enrolEndDate) {
		this.enrolEndDate = enrolEndDate;
	}
	
	public static UedCourse createfromSoapObject(SoapObject obj) {
		try {
			UedCourse ucf = new UedCourse();
			Object p;
			
			//id - 0
			p = obj.getProperty(0);
			ucf.setId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//short name - 1
			p = obj.getProperty(1);
			ucf.setShortName((p == null ? "N/A" : p.toString()));
			
			//id number - 2
			p = obj.getProperty(2);
			ucf.setIdNumber((p == null ? "N/A" : p.toString()));
			
			//category - 3
			p = obj.getProperty(3);
			ucf.setCategory(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//full name - 4
			p = obj.getProperty(4);
			ucf.setFullName((p == null ? "N/A" : p.toString()));
			
			//summary - 5
			p = obj.getProperty(5);
			ucf.setSummary((p == null ? "N/A" : p.toString()));
			
			//visible - 6
			p = obj.getProperty(6);
			ucf.setVisible(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//news items - 7
			p = obj.getProperty(7);
			ucf.setNewsItems((p == null ? "N/A" : p.toString()));
			
			//full link - 8
			p = obj.getProperty(8);
			ucf.setFullLink((p == null ? "N/A" : p.toString()));
			
			//start date - 9
			p = obj.getProperty(9);
			SoapObject uedDate = (SoapObject) p;
			ucf.setStartDate(UedDate.createfromSoapObject(uedDate));
			
			//enrollable - 10
			p = obj.getProperty(10);
			ucf.setEnrollable(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//enrol Start Date - 11
			p = obj.getProperty(12);
			ucf.setEnrolStartDate(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//enrol End Date - 12
			p = obj.getProperty(13);
			ucf.setEnrolEndDate(p == null ? 0 : Integer.parseInt(p.toString()));
			
			return ucf;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedCourse: ", e);
			return null;
		}
	}
	
}
