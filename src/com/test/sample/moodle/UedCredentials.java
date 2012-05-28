package com.test.sample.moodle;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class UedCredentials implements KvmSerializable {
	private String username;
	private String autorizationKey;
	
	/**
	 * Create a new UedCredentials instance
	 */
	public UedCredentials () {}
	
	/**
	 * Create a new UedCredentials instance
	 * 
	 * @param username
	 * @param autorizationKey
	 */
	public UedCredentials(String username, String autorizationKey) {
		this.username = username;
		this.autorizationKey = autorizationKey;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the autorizationKey
	 */
	public String getAutorizationKey() {
		return autorizationKey;
	}
	
	/**
	 * @param autorizationKey
	 *            the autorizationKey to set
	 */
	public void setAutorizationKey(String autorizationKey) {
		this.autorizationKey = autorizationKey;
	}
	
	public Object getProperty(int index) {
		switch (index) {
			case 0:
				return username;
				
			case 1:
				return autorizationKey;
		}
		
		return null;
	}
	
	public int getPropertyCount() {
		return 2;
	}
	
	@SuppressWarnings("rawtypes")
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "username";
				break;
			
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "autorizationKey";
				break;
		}
		
	}
	
	public void setProperty(int index, Object value) {
		switch (index) {
			case 0:
				username = value.toString();
				break;
			case 1:
				autorizationKey = value.toString();
				break;
			default:
				break;
		}
	}
	
}
