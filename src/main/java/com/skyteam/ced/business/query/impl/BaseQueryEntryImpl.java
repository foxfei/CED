package com.skyteam.ced.business.query.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.business.query.QueryEntry;
import com.skyteam.ced.dao.query.QueryDaoFactory;
import com.skyteam.ced.domain.query.PageBean;
import com.skyteam.ced.domain.query.QueryResult;
import com.skyteam.ced.domain.query.QueryResultImpl;

import common.util.ObjectUtilsEx;
import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public abstract class BaseQueryEntryImpl implements QueryEntry {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private QueryDaoFactory queryDaoFactory;
	private String queryDao;

	protected abstract Object cast(Object obj);

	public Number queryForRowCount(Object _queryCondition) {
		long begin = System.currentTimeMillis();
		Number lineCount = null;
		if (_queryCondition instanceof java.util.Map) {
			Map map = (Map) _queryCondition;
			lineCount =  queryForRowCount(map);
		} else if (_queryCondition instanceof java.io.Serializable) {
			Map map = ObjectUtilsEx.beanToMap(_queryCondition);
			lineCount= queryForRowCount(map);
		}
		
		long end =System.currentTimeMillis();
		boolean debug = true;
		if(debug){
			System.out.println(getQueryDao()+"----------->queryForRowCount:"+(end-begin));
		}
		return lineCount;
	}
	
	public List queryForList(Object _queryCondition,PageBean pageBean) {
		

		List list=  queryForList(_queryCondition,cast(pageBean));

		return list;
	}
	

	private List queryForList(Object _queryCondition,PagingAndSorting _pagingAndSorting) {
		if (_queryCondition instanceof java.util.Map) {
			Map map = (Map) _queryCondition;
			return queryForList(map, _pagingAndSorting);
		} else if (_queryCondition instanceof java.io.Serializable) {
			Map map = ObjectUtilsEx.beanToMap(_queryCondition);
			return queryForList(map, _pagingAndSorting);
		}
		return Collections.EMPTY_LIST;
	}

	private List queryForList(Map queryCondition,PagingAndSorting pagingAndSorting) {
		List list = queryDaoFactory.queryForList(getQueryDao(), queryCondition,
				pagingAndSorting);
		Iterator it = list.iterator();
		List _list = new ArrayList();
		while (it.hasNext()) {
			_list.add(this.cast(it.next()));
		}
		return _list;
	}
	

	private Number queryForRowCount(Map queryCondition) {
		return queryDaoFactory.queryForRowCount(getQueryDao(), queryCondition);
	}

	public QueryDaoFactory getQueryDaoFactory() {
		return queryDaoFactory;
	}

	public void setQueryDaoFactory(QueryDaoFactory queryDaoFactory) {
		this.queryDaoFactory = queryDaoFactory;
	}

	private void init() {
		String shortClassName = ClassUtils.getShortClassName(getClass().getName());
		int x = StringUtils.lastIndexOf(shortClassName, "Query");
		if (x > -1) {
			String p1 = StringUtils.substring(shortClassName, 0, 1)
					.toLowerCase();
			String p2 = StringUtils.substring(shortClassName, 1, x);
			queryDao = p1 + p2 + "QueryDao";
		}
	}

	public BaseQueryEntryImpl() {
		init();
	}

	protected String getQueryDao() {
		if (StringUtils.isBlank(queryDao)) {
			init();
		}
		return queryDao;
	}

	public void setQueryDao(String queryDao) {
		this.queryDao = queryDao;
	}
	
	
	protected PagingAndSorting cast(PageBean pageBean){
		if(pageBean != null){
			PagingAndSorting _pagingAndSorting = new PagingAndSorting(pageBean.getSortColumn());
			_pagingAndSorting.setMaxResults(pageBean.getPageSize());
			_pagingAndSorting.setFirstResult(pageBean.getPageNo()!=null?pageBean.getPageNo()* pageBean.getPageSize():0);
			_pagingAndSorting.setOrderProperties(pageBean.getSortColumn());
			_pagingAndSorting.setOrderDescending(Boolean.valueOf(pageBean.getSortOrder()));
			return _pagingAndSorting;
		}
		return null;
	}
	

	public QueryResult queryForResult(Object _queryCondition,PageBean pageBean) {
		long begin = System.currentTimeMillis();
		QueryResultImpl _result = new QueryResultImpl();
		Number rowCount = queryForRowCount(_queryCondition);
		
		if(rowCount==null || (rowCount!=null && rowCount.intValue()==0)){
			_result.setEmpty(true);
			return _result;
		}
		
		Integer pageCount = (rowCount.intValue()+pageBean.getPageSize()-1)/pageBean.getPageSize();
		PagingAndSorting _pagingAndSorting = cast(pageBean);
		int currentPage = 1;
		int fwdPage = 0;
		int backPage = 0;
		int lastPage = pageCount.intValue();
		
		if(pageBean.getPageNo().intValue()>lastPage){
			currentPage = lastPage;
		}else if(pageBean.getPageNo().intValue() <1){
			currentPage = 1;
		}else {
			currentPage = pageBean.getPageNo();
		}
		fwdPage = currentPage+1;
		backPage = currentPage-1;
		
		if(fwdPage<1){
			fwdPage =1;
		}
		if(fwdPage>lastPage){
			fwdPage = lastPage;
		}

		if(backPage<1){
			backPage =1;
		}
		if(backPage>lastPage){
			backPage = lastPage;
		}
		
		
		int x = 0;
		int _start = 0;
		int _stop =0;
		
		int nPagesDisplayed = pageBean.getPagesDisplayed();
		if(x==0){
	        int nCurrent = currentPage;
	        int nRightMargin = nPagesDisplayed / 2;
	        int nStop = nCurrent + nRightMargin;
	        int nLastPage = lastPage;

	        int nLeftAddon = 0;
	        if (nStop > nLastPage)
	            nLeftAddon = nStop - nLastPage;

	        int nLeftMargin = (nPagesDisplayed - 1) / 2 + nLeftAddon;
	        int nStart = nCurrent - nLeftMargin;
	        int nFirstPage = 1;
	        if (nStart < nFirstPage){
	            nStart = nFirstPage;
	        }
	        _start = nStart;
		}
		x=1;
		

		if(x==1){
	        int nCurrent = currentPage;
	        int nLeftMargin = (nPagesDisplayed - 1) / 2;
	        int nStart = nCurrent - nLeftMargin;
	        int nFirstPage = 1;

	        int nRightAddon = 0;
	        if (nStart < nFirstPage)
	            nRightAddon = nFirstPage - nStart;

	        int nRightMargin = nPagesDisplayed / 2 + nRightAddon;
	        int nStop = nCurrent + nRightMargin;
	        int nLastPage = lastPage;
	        if (nStop > nLastPage){
	            nStop = nLastPage;
	        }
	        _stop = nStop;
		}
		
		
		int firstResult = 0;
		if(currentPage>=1){
			firstResult = (currentPage-1)* pageBean.getPageSize();
		}
		
		_pagingAndSorting.setFirstResult(firstResult);
		List currentPageList = queryForList(_queryCondition, _pagingAndSorting);

		

		
		List<String> pagesDisplayedList = new ArrayList<String>();
		for(int i=_start;i<=_stop;i++){
			pagesDisplayedList.add(String.valueOf(i));
		}
		String[] xxx = (String[]) pagesDisplayedList.toArray(new String[pagesDisplayedList.size()]);
		
		_result.setPageCount(ObjectUtils.toString(pageCount));
		_result.setCurrentPage(ObjectUtils.toString(currentPage));
		_result.setPagesDisplayed(xxx);
		_result.setCurrentPageList(currentPageList);
		_result.setRowCount(rowCount);
		_result.setBackPage(ObjectUtils.toString(backPage));
		_result.setFwdPage(ObjectUtils.toString(fwdPage));
		
		
		long end =System.currentTimeMillis();
		boolean debug = true;
		if(debug){
			System.out.println(getQueryDao()+"----------->queryForList:"+(end-begin));
		}
		return _result;
	}

}
