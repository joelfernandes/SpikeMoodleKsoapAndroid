package com.test.sample.moodle;

import java.util.LinkedList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class Moodle {
	public static final String NAMESPACE = "http://ead.ipleiria.pt/admin/report/uedws/";
	public static final String URL = "http://ead.ipleiria.pt/admin/report/uedws/index.php";
	private static final String TAG = "MOODLE";
	
	private String username;
	private String password;
	private String deviceId;
	
	private UedCredentials credentials;

	/**
	 * Create a new Moodle Instance. Next Step: getAuthorizationKey()
	 * @param username
	 * @param password
	 * @param deviceId
	 */
	public Moodle (String username, String password, String deviceId) {
		if(username == null || password == null || deviceId == null) {
			throw new NullPointerException("Must provide non null arguments in contructor" +
					" Moodle(String, String, String");
		}
		
		this.username = username;
		this.password = password;
		this.deviceId = deviceId;
	}
	
	/**
	 * Create a new Moodle Instance. This method will NOT call validate validateCredentials().
	 * @param authorizationKey
	 */
	public Moodle(String username, String authorizationKey) {
		if(username == null || authorizationKey == null) {
			throw new NullPointerException("Neither username or auth key can be null");
		}
		this.username = username;
		this.setCredentials(username, authorizationKey);
	}
	
	/**
	 * Create a new Moodle Instance. 
	 * Next step: getAuthorizationKey(username, password, deviceId)
	 */
	public Moodle() {}
	
	/**
	 * Verify if the user can access to the information of a specific course
	 * 
	 * @param uedCredentials
	 * @param courseId
	 * @return true or false if user can access a specific course
	 */
	public boolean canAccessToCourse(int courseId) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "canAccessToCourse"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("courseId ", courseId ); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        boolean result = Boolean.parseBoolean(envelope.getResponse().toString());
	        return result;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Verify if the user can execute the specified method
	 * 
	 * @param uedCredentials
	 * @param methodName
	 * @return true if the user can access a given method
	 */
	public boolean canInvokeMethod(String invokingMethodName) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "canInvokeMethod"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("methodName", invokingMethodName); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        boolean result = Boolean.parseBoolean(envelope.getResponse().toString());
	        return result;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Request an autorization key to the webservice using the user credentials
	 * 
	 * @param username
	 * @param password
	 * @param deviceIdentification
	 * @return the key or null if authentication fails
	 */
	public String getAuthorizationKey(String username, String password, String deviceId) {
		if(username == null || password == null || deviceId == null) {
			throw new NullPointerException("Must provide non null arguments in contructor" +
					" Moodle(String, String, String");
		}
		
		this.username = username;
		this.password = password;
		this.deviceId = deviceId;
		
		return getAuthorizationKey();
	}
	
	/**
	 * Request an autorization key to the webservice using the user credentials
	 * 
	 * @return the key or null if authentication fails
	 */
	public String getAuthorizationKey() {
		if(username == null || password == null || deviceId == null) {
			throw new NullPointerException("Must provide non null arguments in contructor" +
					" Moodle(String, String, String");
		}
		
		String methodName = "getAuthorizationKey";

		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("username", username);
	        request.addProperty("password", password);
	        request.addProperty("deviceIdentification ", deviceId);
	        
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        String key = envelope.getResponse().toString().trim();
	        return key.equals("") ? null : key;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Return the recent enrolments in a course
	 * 
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return recent enrolments within a course
	 */
	public List<UedRecentEnrolment> getCourseRecentEnrolments(int courseId, UedDate uedStartDate) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "getCourseRecentEnrolments"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentEnrolment> list = new LinkedList<UedRecentEnrolment>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("courseId", courseId); 
	        request.addProperty("UedStartDate ", uedStartDate); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
	        Log.d(TAG, "OUTPUT: " + res.toString());
	        UedRecentEnrolment ure;
	        for (int i = 0; i < res.getPropertyCount(); i++) {
	        	SoapObject obj = (SoapObject) res.getProperty(i);
	        	
	        	ure = UedRecentEnrolment.createfromSoapObject(obj);
	        	list.add(ure);
	        }
	        
	        return list;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Return the recent forum activity within a course
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return
	 */
	public List<UedRecentForumActivity> getCourseRecentForumActivity(int courseId, UedDate uedStartDate) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "getCourseRecentForumActivity";
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentForumActivity> list = new LinkedList<UedRecentForumActivity>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("courseId", courseId); 
	        request.addProperty("UedStartDate ", uedStartDate); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
	       
	        UedRecentForumActivity urfa;
	        for (int i = 0; i < res.getPropertyCount(); i++) {
	        	SoapObject obj = (SoapObject) res.getProperty(i);
	        	
	        	urfa = UedRecentForumActivity.createfromSoapObject(obj);
	        	list.add(urfa);
	        }
	        
	        return list;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}
	
	/**
	 * Return the recent modifications in a course
	 * @param uedCredentials
	 * @param courseId
	 * @param uedStartDate
	 * @return recent modifications within a course
	 */
	public List<UedRecentModification> getCourseRecentModifications(int courseId, UedDate uedStartDate) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "getCourseRecentModifications"; 
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentModification> list = new LinkedList<UedRecentModification>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("courseId", courseId); 
	        request.addProperty("UedStartDate ", uedStartDate); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
	        
	        UedRecentModification urm;
	        for (int i = 0; i < res.getPropertyCount(); i++) {
	        	SoapObject obj = (SoapObject) res.getProperty(i);
	        	
	        	urm = UedRecentModification.createfromSoapObject(obj);
	        	list.add(urm);
	        }
	        
	        return list;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}
	
	/**
	 * Get the courses of the user
	 * @param uedCredentials
	 * @return a list with the courses from authenticated student
	 */
	public List<UedCourseFull> getMyCourses() {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "getMyCourses"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		List<UedCourseFull> list = new LinkedList<UedCourseFull>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
	        
	        UedCourseFull ucf;
	        for (int i = 0; i < res.getPropertyCount(); i++) {
	        	SoapObject obj = (SoapObject) res.getProperty(i);
	        	
	        	ucf = UedCourseFull.createfromSoapObject(obj);
	        	list.add(ucf);
	        }
	        
	        return list;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Get the user profile
	 * @param uedCredentials
	 * @return the profile of the authenticated user
	 */
	public UedUser getMyUserPublicProfile() {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "getMyUserPublicProfile"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
				
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
	        
	        UedUser uUser = UedUser.createfromSoapObject(res);
	        return uUser;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}
	
	/**
	 * getVersion
	 * @return the version of the webservice
	 */
	public String getVersion() {
		String methodName = "getVersion";
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
				
		try {
			SoapObject Request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(Request);
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        return envelope.getResponse().toString();
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Check is the webservice is enabled
	 * @return true or false wether the webservice is enabled
	 */
	public boolean isWebserviceEnabled() throws RuntimeException {
		String methodName = "isWebserviceEnabled";
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
				
		try {
			SoapObject Request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(Request);
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        boolean result = Boolean.parseBoolean(envelope.getResponse().toString());
	        return result;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Revoke the autorization key within the credentials object associated 
	 * to the specified device identifier
	 * @param uedCredentials
	 * @param deviceIdentification
	 * @return true or false wether authorization key was revoked
	 */
	public boolean revokeAuthorizationKey(String deviceIdentification) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "revokeAuthorizationKey"; 
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("deviceIdentification", deviceIdentification ); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        boolean result = Boolean.parseBoolean(envelope.getResponse().toString());
	        return result;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Convert an UedDate to an unix timestamp
	 * @param uedCredentials
	 * @param uedDate
	 * @return unix representation of the provided ued date
	 */
	public String uedDateToUnixTimestamp(UedDate uedDate) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "uedDateToUnixTimestamp";
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("uedDate ", uedDate); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        return envelope.getResponse().toString();
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Convert an unix timestamp to UedDate
	 * @param uedCredentials
	 * @param timeStamp
	 * @return ued representation of the provided unix date
	 */
	public UedDate unixTimestampToUedDate(String timeStamp) {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "unixTimestampToUedDate";
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials); 
	        request.addProperty("timeStamp ", timeStamp); 
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        SoapObject res = (SoapObject) envelope.getResponse();
        	UedDate date = UedDate.createfromSoapObject(res);
        	
	        return date;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * Verify if the credentials are valid and can be used by the webservice
	 * @param uedCredentials
	 * @return true if credentials are valid, false otherwise
	 */
	public boolean validateCredentials() {
		if(credentials == null) {
			throw new InvalidCredentialsException();
		}
		
		String methodName = "validateCredentials";
		
		//SOAP_ACTION = NAMESPACE + METHOD_NAME;
		String soapAction = NAMESPACE + methodName;
		Log.i(TAG, "calling method " + methodName);
				
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", credentials);
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        String result = envelope.getResponse().toString().trim();
	        boolean isValid = result.equals("true") ? true : false;
	        if(! isValid) {
	        	Log.d(TAG, "Invalid credentials. details: " + result);
	        }
	        
	        return isValid;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * @return the credentials
	 */
	public UedCredentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(UedCredentials credentials) {
		this.credentials = credentials;
	}
	
	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(String username, String authorizationKey) {
		this.username = username;
		this.credentials = new UedCredentials(username, authorizationKey);
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
}
