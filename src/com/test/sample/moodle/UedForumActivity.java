package com.test.sample.moodle;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.util.Log;

public class UedForumActivity {
	private String discussionType;
	private int parentId;
	private int discussionId;
	private int userId;
	private UedDate date;
	private int postId;
	private String postSubject;
	private String postUrl;
	
	/**
	 * @return the discussionType
	 */
	public String getDiscussionType() {
		return discussionType;
	}
	
	/**
	 * @param discussionType
	 *            the discussionType to set
	 */
	public void setDiscussionType(String discussionType) {
		this.discussionType = discussionType;
	}
	
	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}
	
	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * @return the discussionId
	 */
	public int getDiscussionId() {
		return discussionId;
	}
	
	/**
	 * @param discussionId
	 *            the discussionId to set
	 */
	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
	}
	
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
	
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	
	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	/**
	 * @return the postSubject
	 */
	public String getPostSubject() {
		return postSubject;
	}
	
	/**
	 * @param postSubject
	 *            the postSubject to set
	 */
	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}
	
	/**
	 * @return the postUrl
	 */
	public String getPostUrl() {
		return postUrl;
	}
	
	/**
	 * @param postUrl
	 *            the postUrl to set
	 */
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	private static UedForumActivity createfromSoapObject(SoapObject obj) {
		try {
			UedForumActivity ufa = new UedForumActivity();
			Object p;
			
			//discussion type - 0
			p = obj.getProperty(0);
			ufa.setDiscussionType(p == null ? "N/A" : p.toString());

			//parent id - 1
			p = obj.getProperty(1);
			ufa.setParentId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//discussion id - 2
			p = obj.getProperty(2);
			ufa.setDiscussionId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//user id - 3
			p = obj.getProperty(3);
			ufa.setUserId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//date - 4
			p = obj.getProperty(4);
			ufa.setDate(UedDate.createfromSoapObject((SoapObject)p));
			
			//post id - 5
			p = obj.getProperty(5);
			ufa.setPostId(p == null ? 0 : Integer.parseInt(p.toString()));
			
			//post subject - 6
			p = obj.getProperty(6);
			ufa.setPostSubject(p == null ? "N/A" : p.toString());
			
			//post url - 7
			p = obj.getProperty(7);
			ufa.setPostUrl(p == null ? "N/A" : p.toString());
			
			return ufa;
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedForumActivity: ", e);
			return null;
		}
	}
	
	public static List<UedForumActivity> createListfromSoapObject(SoapObject obj) {
		List<UedForumActivity> list = new ArrayList<UedForumActivity>();
		try {
			UedForumActivity ufa = null;
			for (int i = 0; i < obj.getPropertyCount(); i++) {
	        	SoapObject aux = (SoapObject) obj.getProperty(i);
	        	
	        	ufa = UedForumActivity.createfromSoapObject(aux);
	        	list.add(ufa);
	        }
	        
		} catch (Exception e) {
			Log.e("SAMPLE", "Error parsing UedForumActivity list: ", e);
			return null;
		}
		return list;
	}
	
}
