package com.test.sample.moodle;

import java.util.List;

public interface IMoodle {
	public static final String NAMESPACE = "http://ead.ipleiria.pt/admin/report/uedws/";
	public static final String URL = "http://ead.ipleiria.pt/admin/report/uedws/index.php";
	
	/**
	 * Verify if the user can access to the information of a specific course
	 * 
	 * @param uedCredentials
	 * @param courseId
	 * @return true or false if user can access a specific course
	 */
	public boolean canAccessToCourse(UedCredentials uedCredentials, int courseId);
	
	/**
	 * Verify if the user can execute the specified method
	 * 
	 * @param uedCredentials
	 * @param methodName
	 * @return true if the user can access a given method
	 */
	public boolean canInvokeMethod(UedCredentials uedCredentials, String invokingMethodName);
	
	/**
	 * Request an autorization key to the webservice using the user credentials
	 * 
	 * @param username
	 * @param password
	 * @param deviceIdentification
	 * @return the key or null if authentication fails
	 */
	public String getAuthorizationKey(String username, String password, String deviceIdentification);
	
	/**
	 * Get the course categories from the system
	 * 
	 * @param uedCredentials
	 * @param parentId
	 * @return the course categories
	 */
	public List<UedCourseCategory> getCategories(UedCredentials uedCredentials, int parentId);
	
	/**
	 * Return the recent enrolments in a course
	 * 
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return recent enrolments within a course
	 */
	public List<UedRecentEnrolment> getCourseRecentEnrolments(UedCredentials uedCredentials, int courseId,
			UedDate uedStartDate);
	
	/**
	 * Return the recent forum activity within a course
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return
	 */
	public List<UedRecentForumActivity> getCourseRecentForumActivity(UedCredentials uedCredentials, 
			int courseId, UedDate uedStartDate);
	
	/**
	 * Return the recent modifications in a course
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return recent modifications within a course
	 */
	public List<UedRecentModification> getCourseRecentModifications(UedCredentials uedCredentials, 
			int courseId, UedDate uedStartDate);
	
	/**
	 * Get the courses from a category on the system
	 * @param uedCredentials
	 * @param categoryId
	 * @return
	 */
	public List<UedCourse> getCourses(UedCredentials uedCredentials, int categoryId);
	
	/**
	 * Get the courses of the user
	 * @param uedCredentials
	 * @return a list with the courses from authenticated student
	 */
	public List<UedCourseFull> getMyCourses (UedCredentials uedCredentials);
	
	/**
	 * Get the user profile
	 * @param uedCredentials
	 * @return the profile of the authenticated user
	 */
	public UedUser getMyUserPublicProfile (UedCredentials uedCredentials);
	
	/**
	 * Get the courses of the user
	 * @param uedCredentials
	 * @return the course of a given username
	 */
	public List<UedCourseFull> getUserCourses (UedCredentials uedCredentials, String username);
	
	/**
	 * Get the public profile of a specific user
	 * @param uedCredentials
	 * @return the profile of a given user ID
	 */
	public UedUser getUserPublicProfile (UedCredentials uedCredentials, int userId, int courseId);
	
	/**
	 * getVersion
	 * @return the version of the webservice
	 */
	public String getVersion ();
	
	/**
	 * Check is the webservice is enabled
	 * @return true or false wether the webservice is enabled
	 */
	public boolean isWebserviceEnabled ();
	
	/**
	 * Revoke the autorization key within the credentials object associated 
	 * to the specified device identifier
	 * @param uedCredentials
	 * @param deviceIdentification
	 * @return true or false wether authorization key was revoked
	 */
	public boolean revokeAuthorizationKey (UedCredentials uedCredentials, String deviceIdentification);
	
	/**
	 * Convert an UedDate to an unix timestamp
	 * @param uedCredentials
	 * @param uedDate
	 * @return unix representation of the provided ued date
	 */
	public String uedDateToUnixTimestamp (UedCredentials uedCredentials, UedDate uedDate);
	
	/**
	 * Convert an unix timestamp to UedDate
	 * @param uedCredentials
	 * @param timeStamp
	 * @return ued representation of the provided unix date
	 */
	public UedDate unixTimestampToUedDate (UedCredentials uedCredentials, String timeStamp);
	
	/**
	 * Verify if the credentials are valid and can be used by the webservice
	 * @param uedCredentials
	 * @return true if credentials are valid, false otherwise
	 */
	public boolean validateCredentials (UedCredentials uedCredentials);
	
	
}
