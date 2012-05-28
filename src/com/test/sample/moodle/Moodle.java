package com.test.sample.moodle;

import java.util.LinkedList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class Moodle implements IMoodle {
	private String soapAction = ""; //SOAP_ACTION = NAMESPACE + METHOD_NAME;
	private static final String TAG = "SAMPLE";

	public boolean canAccessToCourse(UedCredentials uedCredentials, int courseId) {
		String methodName = "canAccessToCourse"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public boolean canInvokeMethod(UedCredentials uedCredentials, String invokingMethodName) {
		String methodName = "canInvokeMethod"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public String getAuthorizationKey(String username, String password, String deviceIdentification) {
		String methodName = "getAuthorizationKey";
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("username", username);
	        request.addProperty("password", password);
	        request.addProperty("deviceIdentification ", deviceIdentification);
	        
	        
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

	/* Throws an error */
	public List<UedCourseCategory> getCategories(UedCredentials uedCredentials, int parentId) {
		String methodName = "getCategories";
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials ", uedCredentials); 
	        request.addProperty("parentid", parentId);
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        String res = envelope.getResponse().toString();
	        return null;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	public List<UedRecentEnrolment> getCourseRecentEnrolments(UedCredentials uedCredentials, int courseId,
			UedDate uedStartDate) {
		
		String methodName = "getCourseRecentEnrolments"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentEnrolment> list = new LinkedList<UedRecentEnrolment>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public List<UedRecentForumActivity> getCourseRecentForumActivity(UedCredentials uedCredentials, int courseId,
			UedDate uedStartDate) {
		
		String methodName = "getCourseRecentForumActivity"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentForumActivity> list = new LinkedList<UedRecentForumActivity>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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
	
	public List<UedRecentModification> getCourseRecentModifications(UedCredentials uedCredentials, int courseId,
			UedDate uedStartDate) {
		
		String methodName = "getCourseRecentModifications"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		List<UedRecentModification> list = new LinkedList<UedRecentModification>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	/* Throws an error */
	public List<UedCourse> getCourses(UedCredentials uedCredentials, int categoryId) {
		String methodName = "getCourses"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
	        
//	        PropertyInfo p1=new PropertyInfo(); 
//            p1.name = "categoryid";
//            p1.type = PropertyInfo.INTEGER_CLASS;
//            request.addProperty(p1, categoryId);
	        
	        request.addProperty("categoryid", categoryId);
	        
	    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        androidHttpTransport.call(soapAction, envelope);
	        
	        String res = envelope.getResponse().toString();
	        //boolean result = Boolean.parseBoolean(envelope.getResponse().toString());
	        return null;
		} catch (Exception e) {
			RuntimeException ex = new RuntimeException(e.getCause());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	public List<UedCourseFull> getMyCourses(UedCredentials uedCredentials) {
		String methodName = "getMyCourses"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		List<UedCourseFull> list = new LinkedList<UedCourseFull>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
	        
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

	public UedUser getMyUserPublicProfile(UedCredentials uedCredentials) {
		String methodName = "getMyUserPublicProfile"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
	        
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

	/* Throws an error */
	public List<UedCourseFull> getUserCourses(UedCredentials uedCredentials, String username) {
		String methodName = "getUserCourses"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		List<UedCourseFull> list = new LinkedList<UedCourseFull>();
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
	        request.addProperty("username", username); 
	        
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

	public UedUser getUserPublicProfile(UedCredentials uedCredentials, int userId, int courseId) {
		String methodName = "getMyUserPublicProfile"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
	        request.addProperty("userId", userId); 
	        request.addProperty("courseId", courseId); 
	        
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

	public String getVersion() {
		String methodName = "getVersion";
		soapAction = NAMESPACE + methodName;
		
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

	public boolean isWebserviceEnabled() throws RuntimeException {
		String methodName = "isWebserviceEnabled";
		soapAction = NAMESPACE + methodName;
		
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

	public boolean revokeAuthorizationKey(UedCredentials uedCredentials, String deviceIdentification) {
		String methodName = "revokeAuthorizationKey"; 
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try { 
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public String uedDateToUnixTimestamp(UedCredentials uedCredentials, UedDate uedDate) {
		String methodName = "uedDateToUnixTimestamp";
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public UedDate unixTimestampToUedDate(UedCredentials uedCredentials, String timeStamp) {
		String methodName = "unixTimestampToUedDate";
		soapAction = NAMESPACE + methodName;
		
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials); 
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

	public boolean validateCredentials(UedCredentials uedCredentials) {
		String methodName = "validateCredentials";
		soapAction = NAMESPACE + methodName; 
		
		Log.i(TAG, "calling method " + methodName);
		
		try {
			SoapObject request = new SoapObject(NAMESPACE, methodName);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet = true;
	        envelope.setOutputSoapObject(request);
	        
	        request.addProperty("credentials", uedCredentials);
	        
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
	
	
}
