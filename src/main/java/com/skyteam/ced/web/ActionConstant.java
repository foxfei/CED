package com.skyteam.ced.web;

import com.opensymphony.xwork2.Action;

/**
 * 
 * @author liang.wang@footmarktech.com
 * 
 */
public interface ActionConstant extends Action {
	public static final String METHOD_POST = "POST";
	public static final String METHOD_GET = "GET";

	public static final String SESSION_ATTRIBUTE_KEY_USER = "USER";

	//public static final String SESSION_ATTRIBUTE_KEY_USER_LOGINED = "USER_LOGINED";
	public static final String SESSION_ATTRIBUTE_KEY_DISPATCHER_DATA = "DISPATCHER_DATA";
	public static final String SESSION_ATTRIBUTE_KEY_CTISTATUS_DATA ="SESSION_CTISTATUS_DATA";
	public static final String SESSION_ATTRIBUTE_KEY_WORKSHEET ="SESSION_WORKSHEET";
	
	public static final String ROOT_BRANCH_ID = "000000";
	public static final String PARENT_BRANCH_ID = "PARENT_BRANCH_ID";
	
	public static final String COOKIES_ATTRIBUTE_KEY_EMPLOYEE_NO = "empNo";
	public static final String COOKIES_ATTRIBUTE_KEY_WORKSHEET_CLOSE = "workCloseStatus";
	public static final String COOKIES_ATTRIBUTE_KEY_WORKSHEET_NO = "workNo";
	public static final String SESSION_ATTRIBUTE_KEY_WORKSHEET_CLOSE = "workCloseStatus";
	public static final String SESSION_ATTRIBUTE_KEY_WORKSHEET_NO = "workNo";
	public static final String SESSION_ATTRIBUTE_KEY_TOURL = "tourl";
	public static final String CSAIR_DOMAIN = ".csair.com";
	
}
