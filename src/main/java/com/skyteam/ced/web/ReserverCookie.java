package com.skyteam.ced.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie辅助类
 * 
 */
public final class ReserverCookie {

	public final static String COOKIE_NAME = "cs1246643xde";


	public final static String FFP_TYPE = "FFP";
	public final static String B2C_TYPE = "B2C";

	public final static String CSAIR_COM = ".csair.com";
	public final static String CS_AIR_COM = ".cs-air.com";

	/**
	 * 返回cookie
	 * 
	 * @param request
	 * @return
	 */
	public Cookie getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (COOKIE_NAME.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public Cookie getCookie(HttpServletRequest request,String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (key.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

	/**
	 * 判断是否存在cookie
	 * 
	 * @param request
	 * @return
	 */
	public boolean isHasCookie(HttpServletRequest request) {
		Cookie cookie = getCookie(request);
		if (cookie != null && cookie.getValue() != null
				&& cookie.getValue().length() > 2) {
			return true;
		}
		return false;
	}

	/**
	 * 删除cookie
	 * 
	 * @param request
	 * @param response
	 */
	public void removeCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookie = getCookie(request);
		if (cookie != null) {
			cookie = new Cookie(COOKIE_NAME, "");
			cookie.setMaxAge(0);
			cookie.setValue("");
			cookie.setPath("/");
			cookie.setDomain(CSAIR_COM);
			response.addCookie(cookie);
		}
	}

	/**
	 * 添加cookie
	 * 
	 * @param response
	 * @param cookieValue
	 * @param domainValue
	 */
	public void addCookie(HttpServletResponse response, String cookieValue,
			String domainValue) {
		if (cookieValue != null && !"".equals(cookieValue)) {
			Cookie cookie = new Cookie(COOKIE_NAME, cookieValue);
			if (domainValue != null && !"".equals(domainValue)) {
				cookie.setDomain(domainValue);
			}
			cookie.setPath("/");
			// cookie.setMaxAge(60 * 60); //有效期为1个小时
			cookie.setMaxAge(-10); // 关闭浏览器即失效
			response.addCookie(cookie);
		}
	}
	
	public void addCookie(HttpServletResponse response,String cookieKey, String cookieValue,String domainValue) {
			Cookie cookie = new Cookie(cookieKey, cookieValue);
			if (domainValue != null && !"".equals(domainValue)) {
				cookie.setDomain(domainValue);
			}
			cookie.setPath("/");
			cookie.setMaxAge(-10); // 关闭浏览器即失效
			response.addCookie(cookie);
	}

}
