package com.skyteam.ced.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.business.query.QueryEntry;
import com.skyteam.ced.domain.query.PageBean;
import com.skyteam.ced.domain.query.QueryResult;
import com.skyteam.ced.service.QueryFactory;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class QueryFactoryImpl implements QueryFactory {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private Map beans;

	public void setBeans(Map map) {
		beans = map;
	}

	public Map getBeans() {
		return this.beans;
	}

	public Number queryForRowCount(String _beanId, Object _queryCondition) {
		QueryEntry obj = (QueryEntry) getBeans().get(_beanId);
		Number lineCount =  obj.queryForRowCount(_queryCondition);
		return lineCount;
	}

	public List queryForList(String _beanId, Object _queryCondition,PageBean pageBean) {
		QueryEntry obj = (QueryEntry) getBeans().get(_beanId);
		List list =  obj.queryForList(_queryCondition, pageBean);
		return list;
	}

	public QueryResult queryForResult(String _beanId, Object _queryCondition,PageBean pageBean) {
		QueryEntry obj = (QueryEntry) getBeans().get(_beanId);
		QueryResult _queryResult =  obj.queryForResult(_queryCondition, pageBean);
		return _queryResult;
	}

}
