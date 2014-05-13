package com.skyteam.ced.service;
/**
 * 查询服务工厂
 */
import java.util.List;

import com.skyteam.ced.domain.query.PageBean;
import com.skyteam.ced.domain.query.QueryResult;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface QueryFactory {
	Number queryForRowCount(String _beanId, Object _queryCondition);

	List queryForList(String _beanId, Object _queryCondition, PageBean pageBean);

	QueryResult queryForResult(String _beanId, Object _queryCondition, PageBean pageBean);

}
