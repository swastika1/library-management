package com.library.book.util;

public class Constant {
	
	public static final String TOKEN_INVALID_OR_EXPIRED = "Token is either Invalid/Expired!";
	public static final String USER_ID_AND_TOKEN_MISMATCH = "User id and token mismatch!";
	public static final String EMAIL_AND_PASSWORD_MISMATCH = "Email and password mismatch!";
	public static final String LOGIN_API_V1 = "/rest/v1/login";
	public static final String LOGOUT_API_V1 = "/rest/v1/logout";
	public static final String SWAGGER_URL = "/swagger-ui.html";
	public static final String STATUS_API = "/api/v1/status";
	public static final String ENABLE = "ENABLE";
	public static final String DISABLE = "DISABLE";
	public static final String NEW = "New";
	public static final String EMPTY_STRING = "";
	public static final String AIRPORT = "airports";
	public static final String HOSPITAL = "hospitals";
	public static final String SCHOOL = "schools";
	public static final String NOTICE = "notices";
	public static final String PROJECT = "projects";

	/* For JWT */
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "deependra123";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

}
