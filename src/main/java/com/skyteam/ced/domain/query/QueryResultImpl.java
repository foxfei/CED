package com.skyteam.ced.domain.query;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author liang.wang@footmarktech.com
 * 
 */
public class QueryResultImpl implements QueryResult {



	private static final long serialVersionUID = 6011907292733789385L;
	private Number rowCount;
	private String pageCount;
	private String currentPage;
	private String backPage;
	private String fwdPage;
	private List currentPageList;
	private String[] pagesDisplayed;
	boolean empty;

	public QueryResultImpl() {
		this.setRowCount(new Integer(0));
		this.setCurrentPageList(Collections.EMPTY_LIST);
	}

	public Number getRowCount() {
		return rowCount;
	}

	public void setRowCount(Number rowCount) {
		this.rowCount = rowCount;
	}

	public List getCurrentPageList() {
		return currentPageList;
	}

	public void setCurrentPageList(List currentPageList) {
		this.currentPageList = currentPageList;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getBackPage() {
		return backPage;
	}

	public void setBackPage(String backPage) {
		this.backPage = backPage;
	}

	public String getFwdPage() {
		return fwdPage;
	}

	public void setFwdPage(String fwdPage) {
		this.fwdPage = fwdPage;
	}

	public String[] getPagesDisplayed() {
		return pagesDisplayed;
	}

	public void setPagesDisplayed(String[] pagesDisplayed) {
		this.pagesDisplayed = pagesDisplayed;
	}



	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}


}
