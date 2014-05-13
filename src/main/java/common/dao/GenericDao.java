package common.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface GenericDao {
	/**
	 * load a obj from session by objKey and class
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	Object load(Class entityClass, Serializable id);


	/**
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	Object get(Class entityClass, Serializable id);
	/**
	 * 
	 * @param entity
	 * @return
	 */
	//Object merge(Object entity);
	
	//public void evict(Object entity);

	/**
	 * 
	 * @param entity
	 * @return id(pk)
	 */
	Serializable save(Object entity);

	/**
	 * 
	 * @param entityClass
	 * @param id
	 */
	void delete(Class entityClass, Serializable id);

	/**
	 * 
	 * @param entity
	 */
	void delete(Object entity);

	/**
	 * 
	 * @param obj
	 */
	void update(Object entity);

	/**
	 * 
	 * @param obj
	 */
	void saveOrUpdate(Object entity);


	/**
	 * 
	 * @param HQLString
	 * @return
	 */
	List find(String HQLString);



	/**
	 * 
	 * @param HQLString
	 * @param pagingAndSorting
	 * @return
	 */
	List find(String HQLString, PagingAndSorting pagingAndSorting);

	/**
	 * 
	 * @param HQLString
	 * @param parameters
	 * @param pagingAndSorting
	 * @return
	 */
	List find(String HQLString, Map parameters,PagingAndSorting pagingAndSorting);
	/**
	 * @param HQLString
	 * @param parameters
	 * @param pagingAndSorting
	 * @param useCache
	 * @return
	 */
	List find(String HQLString, Map parameters,PagingAndSorting pagingAndSorting,boolean useCache);	

	/**
	 * execute a HQL Query
	 * 
	 * @param HQLString
	 * @param parameters
	 * @return
	 */
	int execute(String HQLString, Map parameters);

	/**
	 * execute a HQL Query
	 * 
	 * @param sqlString
	 * @return
	 */
	int execute(String HQLString);

	/**
	 * execute a SQL Query
	 * 
	 * @param SQLString
	 * @param parameters
	 * @return
	 */
	int executeSQL(String SQLString, Map parameters);

	/**
	 * execute a SQL Query
	 * 
	 * @param SQLString
	 * @return
	 */
	int executeSQL(String SQLString);

	/**
	 * 
	 * @param SQLString
	 * @return
	 */
	List findBySQL(String SQLString);

	/**
	 * @param SQLString
	 * @param parameters
	 * @param pagingAndSorting
	 * @return
	 */
	List findBySQL(String SQLString, Map parameters,PagingAndSorting pagingAndSorting);
	
	/**
	 * @param SQLString
	 * @param parameters
	 * @param pagingAndSorting
	 * @param useCache
	 * @return
	 */
	List findBySQL(String SQLString, Map parameters,PagingAndSorting pagingAndSorting,boolean useCache);	

//	/**
//	 * @param HQLString
//	 * @param _namedParameters
//	 * @return
//	 */
//	int executeSelectCount(String _queryString, Map _namedParameters);
//	
//	/**
//	 * @param SQLString
//	 * @param _namedParameters
//	 * @return
//	 */
//	int executeSelectCountBySQL(String _queryString, Map _namedParameters);

}
