package com.skyteam.ced.business.query;

import java.util.List;

import com.skyteam.ced.domain.query.PageBean;
import com.skyteam.ced.domain.query.QueryResult;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface QueryEntry {

	Number queryForRowCount(Object _queryCondition);
	//List queryForList(Object _queryCondition, PagingAndSorting _pagingAndSorting);
	List queryForList(Object _queryCondition, PageBean pageBean);
	QueryResult queryForResult(Object _queryCondition, PageBean pageBean);
}
