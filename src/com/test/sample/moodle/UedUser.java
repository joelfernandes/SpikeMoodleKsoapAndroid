package com.test.sample.moodle;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedUser {
	private int id;
	private String fullName;
	private String imageUrl;
	private String description;
	private String country;
	private String city;
	private String webPageUrl;
	private String profileLink;
	
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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the webPageUrl
	 */
	public String getWebPageUrl() {
		return webPageUrl;
	}
	
	/**
	 * @param webPageUrl
	 *            the webPageUrl to set
	 */
	public void setWebPageUrl(String webPageUrl) {
		this.webPageUrl = webPageUrl;
	}
	
	/**
	 * @return the profileLink
	 */
	public String getProfileLink() {
		return profileLink;
	}
	
	/**
	 * @param profileLink
	 *            the profileLink to set
	 */
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	public static UedUser createfromSoapObject(SoapObject obj) {
		try {
			UedUser uUser = new UedUser();
			Object p;
			
			//id - 0
			p = obj.getProperty(0);
			uUser.setId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//full name - 1
			p = obj.getProperty(1);
			uUser.setFullName(p == null ? "N/A" : p.toString());
			
			//image url - 2
			p = obj.getProperty(2);
			uUser.setImageUrl(p == null ? "N/A" : p.toString());
			
			//description - 3
			p = obj.getProperty(3);
			uUser.setDescription(p == null ? "N/A" : p.toString());
			
			//country - 4
			p = obj.getProperty(4);
			uUser.setCountry(p == null ? "N/A" : p.toString());
			
			//city - 5
			p = obj.getProperty(5);
			uUser.setCity(p == null ? "N/A" : p.toString());
			
			//web page url - 6
			p = obj.getProperty(6);
			uUser.setWebPageUrl(p == null ? "N/A" : p.toString());
			
			//country - 7
			p = obj.getProperty(7);
			uUser.setProfileLink(p == null ? "N/A" : p.toString());
			
			return uUser;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedDate: ", e);
			return null;
		}
		
	}
	
}
