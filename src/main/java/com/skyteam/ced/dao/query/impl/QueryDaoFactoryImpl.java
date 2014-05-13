package com.skyteam.ced.dao.query.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.skyteam.ced.dao.query.QueryDao;
import com.skyteam.ced.dao.query.QueryDaoFactory;

import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class QueryDaoFactoryImpl implements QueryDaoFactory {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private ListOrderedMap beans;

	public void setBeans(ListOrderedMap map) {
		beans = map;
	}

	private QueryDao fetchBean(String beanId) {
		Object obj = null;
		Assert.notEmpty(beans, "beans can not be empty");
		if (beans.containsKey(beanId)) {
			obj = (QueryDao) beans.get(beanId);
		} else {
			if (beans.get(0) != null)
				obj = (QueryDao) beans.get(0);
		}
		Assert.notNull(obj, "beans do not contains any queryDao");
		obj = (QueryDao) beans.get(beanId);
		Assert.isInstanceOf(QueryDao.class, obj);
		return (QueryDao)obj;
	}

	public Number queryForRowCount(String _beanId, Map _queryCondition) {
		QueryDao obj = fetchBean(_beanId);
		return obj.queryForRowCount(_queryCondition);
	}

	public List queryForList(String _beanId, Map _queryCondition,PagingAndSorting _pagingAndSorting) {
		QueryDao obj = fetchBean(_beanId);
		return obj.queryForList(_queryCondition,_pagingAndSorting);
	}

}
