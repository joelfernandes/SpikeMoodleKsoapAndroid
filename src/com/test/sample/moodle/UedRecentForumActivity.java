package com.test.sample.moodle;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedRecentForumActivity {
	private int forumId;
	private String forumName;
	private int sectionNumber;
	private List<UedForumActivity> activity;
	
	/**
	 * @return the forumId
	 */
	public int getForumId() {
		return forumId;
	}
	
	/**
	 * @param forumId
	 *            the forumId to set
	 */
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	/**
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
	}
	
	/**
	 * @param forumName
	 *            the forumName to set
	 */
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	
	/**
	 * @return the sectionNumber
	 */
	public int getSectionNumber() {
		return sectionNumber;
	}
	
	/**
	 * @param sectionNumber
	 *            the sectionNumber to set
	 */
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	
	/**
	 * @return the activity
	 */
	public List<UedForumActivity> getActivity() {
		return activity;
	}
	
	/**
	 * @param activity
	 *            the activity to set
	 */
	public void setActivity(List<UedForumActivity> activity) {
		this.activity = activity;
	}

	public static UedRecentForumActivity createfromSoapObject(SoapObject obj) {
		try {
			UedRecentForumActivity urfa = new UedRecentForumActivity();
			Object p;
			
			//forum id - 0
			p = obj.getProperty(0);
			urfa.setForumId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//forum name - 1
			p = obj.getProperty(1);
			urfa.setForumName((p == null ? "N/A" : p.toString()));
			
			//section number - 2
			p = obj.getProperty(2);
			urfa.setForumId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//Activity - 2
			p = obj.getProperty(3);
			urfa.setActivity(UedForumActivity.createListfromSoapObject((SoapObject)p));
			
			return urfa;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedRecentForumActivity: ", e);
			return null;
		}
	}
	
}
