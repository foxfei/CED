package com.skyteam.ced.dao.query;

import java.util.List;
import java.util.Map;

import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface QueryDao {
	Number queryForRowCount(Map _queryCondition);

	List queryForList(Map _queryCondition, PagingAndSorting _pagingAndSorting);
}
