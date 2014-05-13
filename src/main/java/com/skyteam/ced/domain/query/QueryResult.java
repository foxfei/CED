package com.skyteam.ced.domain.query;

import java.util.List;

/**
 * 
 * @author liang.wang@footmarktech.com
 * 
 */
public interface QueryResult extends java.io.Serializable {
	Number getRowCount();
	String getPageCount();
	String getCurrentPage();
	String getBackPage();
	String getFwdPage();
	List getCurrentPageList();
	boolean isEmpty();
}
