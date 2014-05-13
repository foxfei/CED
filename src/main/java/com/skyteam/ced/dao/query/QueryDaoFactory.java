package com.skyteam.ced.dao.query;

import java.util.List;
import java.util.Map;

import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface QueryDaoFactory {
	Number queryForRowCount(String beanId, Map queryCondition);
	List queryForList(String beanId, Map queryCondition, PagingAndSorting _p);
}
