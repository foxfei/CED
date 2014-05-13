package com.skyteam.ced.dao.query.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.dao.query.QueryDao;

import common.dao.GenericDao;
import common.query.Query;
import common.util.CollectionUtils;
import common.util.PagingAndSorting;
/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public abstract class BaseQueryDao implements QueryDao {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unchecked")
	protected abstract Query createQuery(Map map);

	private GenericDao genericDao;

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	protected GenericDao getGenericDao(){
		return genericDao;
	}
	
	
	protected abstract String createSelect(String temp);
	
	protected String createSelectCount(String temp){
		String xx =  "select count(*) " + temp;
		String yy = StringUtils.upperCase(xx);
		
		int orderBy = yy.lastIndexOf(" ORDER ");
		if(orderBy>-1){
			xx = StringUtils.substring(xx, 0, orderBy);
		}
		return xx;
	}
	

	@SuppressWarnings("unchecked")
	public Number queryForRowCount(Map queryCondition) {
		long begin = System.currentTimeMillis();
		Number lineCount = null;
		Query _query = createQuery(queryCondition);
		if (_query == null)
			lineCount =  new Integer(0);
		else {
			List list = getGenericDao().find(createSelectCount(_query.getQueryString()), _query.getNamedParameters(),null);
			if(!CollectionUtils.isEmpty(list)){
				lineCount = (Number)list.get(0);
			}
		}
		long end =System.currentTimeMillis();
		boolean debug = false;
		if(debug){
			System.out.println("queryForRowCount:"+(end-begin));
		}
		return lineCount;
	}

	@SuppressWarnings("unchecked")
	public List queryForList(Map queryCondition,PagingAndSorting pagingAndSorting) {
		long begin = System.currentTimeMillis();
		Query _query = createQuery(queryCondition);
		List list = getGenericDao().find(createSelect(_query.getQueryString()), _query.getNamedParameters(), pagingAndSorting);
		long end =System.currentTimeMillis();
		boolean debug = false;
		if(debug){
			System.out.println("queryForList:"+(end-begin));
		}
		return list;
	}
}
