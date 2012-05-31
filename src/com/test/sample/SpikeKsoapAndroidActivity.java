package com.test.sample;

import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

import com.test.sample.moodle.Moodle;
import com.test.sample.moodle.UedCourse;
import com.test.sample.moodle.UedCourseFull;
import com.test.sample.moodle.UedCredentials;
import com.test.sample.moodle.UedDate;
import com.test.sample.moodle.UedForumActivity;
import com.test.sample.moodle.UedRecentForumActivity;

public class SpikeKsoapAndroidActivity extends Activity {
	public static final String PREFERENCES = "PREFS";
	public static final String PREF_SESSION_KEY = "PREF_SESSION";
	
	private SharedPreferences preferences;
	
	private String username = "your_username"; 
	private String password = "your_password";
	private String deviceId = "spooky";//"use_mac_addr_here";
	private String sessionId = "";
	private UedCredentials uedCredentials;
	private Moodle moodle;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		moodle = new Moodle();
		loadkey();
		
		
		/* ******************** check wether the webservice is enable or not ******************** */
		//		        Log.d("SAMPLE", "Web service enabled: " + moodle.isWebserviceEnabled());
		
		
		/* ******************** handle authorization key ******************** */
		if (sessionId.equals("")) {
			getNewAuthenticationKey();
		}
		uedCredentials = new UedCredentials(username, sessionId);
		
		
		/* ******************** Validate credentials ******************** */
		boolean validCredentials = false;
		while (!validCredentials) {
			//FIXME might generate an infinite loop!!!!
			validCredentials = moodle.validateCredentials(uedCredentials);
			Log.d("SAMPLE", "Credentials are valid: " + validCredentials);
			
			if (!validCredentials) {
				getNewAuthenticationKey();
				uedCredentials = new UedCredentials(username, sessionId);
			}
			
		}
		
		
		/* ******************** get authenticated user couses ******************** */
		List<UedCourseFull> courses = moodle.getMyCourses(uedCredentials);
		if (courses != null) {
			Log.d("SAMPLE", "User courses: " + courses.size());
			for (UedCourseFull ucf : courses) {
				Log.d("SAMPLE", "Course: id=" + ucf.getId() + " category=" + ucf.getCategory() +
						" name=" + ucf.getFullName());
			}
		}
		
		
		/* ******************** check if user has access to one specific course ******************** */
		// 2126 - GPI 
		//		Log.d("SAMPLE", "User can access GPI: " + moodle.canAccessToCourse(uedCredentials, 2126));

		
		/* ******************** check if user has access to one method ******************** */
//				String method = "getVersion"; 
//				Log.d("SAMPLE", "Can access method " + method + ": " + 
//						moodle.canInvokeMethod(uedCredentials, method));

		
		/* ******************** Convert UED date into timestamp ******************** */
//		String timestamp = moodle.uedDateToUnixTimestamp(uedCredentials, courses.get(0).getStartDate());
//		Log.d("SAMPEL", timestamp);
		
		
		/* ******************** Convert timestamp into UED date ******************** */
//		Log.d("SAMPLE", moodle.unixTimestampToUedDate(uedCredentials, timestamp).toString());
		
		
		/* ******************** Get my user public profile ******************** */
//		UedUser uUser = moodle.getMyUserPublicProfile(uedCredentials);
//		Log.d("SAMPLE", "Name: " + uUser.getFullName() + " ID: " + uUser.getId());
		
		
		/* ******************** Get a user specific public profile ******************** */
		//Spooky mobile - ID 1889, AM - 3175
//		UedUser uUser2 = moodle.getUserPublicProfile(uedCredentials, 1889, 3175);
//		Log.d("SAMPLE", "Name: " + uUser2.getFullName() + " ID: " + uUser2.getId());
		
		
		/* ******************** get course recent enrolment ******************** */
		//TODO not the right way to test... what's wrong?
//		UedDate date = new UedDate("1", "9", "2010");
//		for(UedCourse uc : courses) {
//			List<UedRecentEnrolment> enrolments = moodle.getCourseRecentEnrolments(
//					uedCredentials, uc.getId(), date);
//			if (enrolments != null) {
//				Log.d("SAMPLE", "Recent enrolments: " + enrolments.size());
//				for (UedRecentEnrolment ure : enrolments) {
//					Log.d("SAMPLE", "Enrolment: user=" + ure.getUserId() + " course id=" + ure.getCourseId() +
//							" profile=" + ure.getUserProfileLink());
//				}
//			}
//		}
		
		
		/* ******************** get course recent modification ******************** */
//		UedDate date = new UedDate("1", "9", "2011"); 
//		for(UedCourse uc : courses) { 
//			List<UedRecentModification> enrolments = moodle.getCourseRecentModifications(uedCredentials, uc.getId(), date);
//			if (enrolments != null) {
//				Log.d("SAMPLE", "Recent modifications: " + enrolments.size() + " - " + uc.getFullName());
//				for (UedRecentModification urm : enrolments) {
//									Log.d("SAMPLE", "Modification: module=" + urm.getModule() + " module name=" + urm.getModuleName() +
//											" operation=" + urm.getOperation() + " text=" + urm.getText() + " date=" + urm.getDate() 
//											+ " url=" + urm.getUrl());
//				}
//			}
//		}

		
		/* ******************** get course forum activity ******************** */
		UedDate date = new UedDate("1", "9", "2011");
		for(UedCourse uc : courses) {
			List<UedRecentForumActivity> recentForumActivity = moodle.getCourseRecentForumActivity(uedCredentials, uc.getId(), date);
			if (recentForumActivity != null) {
				Log.d("SAMPLE", "Recent forum activity: " + recentForumActivity.size());
				for (UedRecentForumActivity urfa : recentForumActivity) {
					Log.d("SAMPLE", "Forum activity: forum id=" + urfa.getForumId() + " forum name=" + urfa.getForumName() +
							" section number=" + urfa.getSectionNumber() + " activity size=" + urfa.getActivity().size());
					for(UedForumActivity ufa : urfa.getActivity()) {
						Log.i("SAMPLE", "Activity: id=" + ufa.getUserId() + " date=" + ufa.getDate() +
								" discussion id=" + ufa.getDiscussionId() + " discussion type=" + ufa.getDiscussionType() + 
								" parent: " + ufa.getParentId() + " post subject=" + ufa.getPostSubject());
					}
				}
			}
		}
		
		
		/* ******************** Revoke authorization key ******************** */
//		Log.d("SAMPLE", "Key revoked: " + moodle.revokeAuthorizationKey(uedCredentials, deviceId));
		
	}
	
	private void getNewAuthenticationKey() {
		String session_key = moodle.getAuthorizationKey(username, password, deviceId);
		Log.d("SAMPLE", "Auth_key: " + session_key);
		saveKey(session_key);
		this.sessionId = session_key;
	}
	
	private void loadkey() {
		preferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
		sessionId = preferences.getString(PREF_SESSION_KEY, "");
	}
	
	private void saveKey(String key) {
		Editor pEditor = preferences.edit();
		pEditor.putString(PREF_SESSION_KEY, key);
		pEditor.commit();
	}
	
}