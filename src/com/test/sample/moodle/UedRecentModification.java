package com.test.sample.moodle;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedRecentModification {
	private String operation;
	private String text;
	private String module;
	private String moduleName;
	private String url;
	private UedDate date;
	
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}
	
	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}
	
	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	
	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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

	public static UedRecentModification createfromSoapObject(SoapObject obj) {
		try {
			UedRecentModification urm = new UedRecentModification();
			Object p;
			
			//operation - 0
			p = obj.getProperty(0);
			urm.setOperation((p == null ? "N/A" : p.toString()));
			
			//text - 1
			p = obj.getProperty(1);
			urm.setText((p == null ? "N/A" : p.toString()));
			
			//module - 2
			p = obj.getProperty(2);
			urm.setModule((p == null ? "N/A" : p.toString()));
			
			//module name - 3
			p = obj.getProperty(3);
			urm.setModuleName((p == null ? "N/A" : p.toString()));
			
			//url - 4
			p = obj.getProperty(4);
			urm.setUrl((p == null ? "N/A" : p.toString()));
			
			//date - 5
			p = obj.getProperty(5);
			urm.setDate(UedDate.createfromSoapObject((SoapObject) p));
						
			return urm;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedRecentModification: ", e);
			return null;
		}
	}
}
