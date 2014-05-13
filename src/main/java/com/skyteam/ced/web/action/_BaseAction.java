package com.skyteam.ced.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 * @author liang.wang@footmarktech.com
 * 
 */
public class _BaseAction extends ActionSupport implements Preparable,
		ServletRequestAware, ServletContextAware, ServletResponseAware {

	private static final long serialVersionUID = 6619860966587467796L;
	private static final String NEW_SUCCESS_MESSAGE = "新增成功！";
	private static final String UPDATE_SUCCESS_MESSAGE = "更新成功！";
	private String message;
	private HttpServletRequest servletRequest;
	private ServletContext servletContext;
	private HttpServletResponse servletResponse;

	public boolean isProtected() {
		return Boolean.TRUE.booleanValue();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	protected String getMessage(boolean isNew) {
		String msg = null;
		msg = (isNew ? NEW_SUCCESS_MESSAGE : UPDATE_SUCCESS_MESSAGE);
		return msg;
	}

	public void prepare() throws Exception {

	}

	/**
	 * session中是否存在
	 * 
	 * @param key
	 * @return
	 */
	protected boolean isContainsAttribute(String key) {
		Object obj = getSessionAttribute(key);
		return obj != null;
	}

	/**
	 * 放入session中
	 * 
	 * @param key
	 * @param value
	 */
	protected void setSessionAttribute(String key, Object value) {
		HttpSession session = this.getServletRequest().getSession();
		session.setAttribute(key, value);
	}

	/**
	 * 从session中获取Object
	 * 
	 * @param key
	 * @return
	 */
	protected Object getSessionAttribute(String key) {
		HttpSession session = this.getServletRequest().getSession();
		Object obj = session.getAttribute(key);
		return obj;
	}

	/**
	 * 清理session
	 */
	protected void clearSession() {

		SessionMap sessionMap = (SessionMap) ActionContext.getContext()
				.getSession();
		try {
			sessionMap.clear();
		} catch (Exception e) {
			//
		}

		HttpSession httpSession = this.getServletRequest().getSession();
		try {
			httpSession.invalidate();
		} catch (Exception e) {
			//
		}
	}

	protected HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	protected ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	protected HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}
}
