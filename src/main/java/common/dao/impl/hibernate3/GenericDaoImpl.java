package common.dao.impl.hibernate3;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.dao.GenericDao;
import common.util.PagingAndSorting;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class GenericDaoImpl extends HibernateDaoSupport implements GenericDao {
	final Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);
	public Object load(Class entityClass, Serializable id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	public Object load(String entityName, Serializable id) {
		return this.getHibernateTemplate().load(entityName, id);
	}
	
	public Object merge(Object entity){
		return this.getHibernateTemplate().merge(entity);
	}

	public Object get(String entityName, Serializable id) {
		return getHibernateTemplate().get(entityName, id);
	}

	public Object get(Class entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	public void delete(Class entityClass, Serializable id) {
		getHibernateTemplate().delete(load(entityClass, id), LockMode.UPGRADE);
	}

	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}

	public Serializable save(Object entity) {
		return this.getHibernateTemplate().save(entity);
	}

	public List find(String HQL) {
		return this.getHibernateTemplate().find(HQL);
	}

	public void saveOrUpdate(Object entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdate(String entityName, Object entity) {
		this.getHibernateTemplate().saveOrUpdate(entityName, entity);
	}

	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}

	public List find(final String HQLString,
			final PagingAndSorting pagingAndSorting) {
		return find(HQLString, null, pagingAndSorting);
	}

	
	public void evict(Object entity){
		this.getHibernateTemplate().evict(entity);
		
	}


	public List find(final String HQLString, final Map parameters,
			final PagingAndSorting pagingAndSorting,final boolean useCache) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(PagingAndSorting
						.buildOrderBy(HQLString, pagingAndSorting));
				 query.setCacheable(useCache);
				if (parameters != null && !parameters.isEmpty()) {
					Iterator iter = parameters.keySet().iterator();
					while (iter.hasNext()) {
						String parameterName = (String) iter.next();
						if (parameters.get(parameterName) instanceof Date) {
							query.setDate(parameterName, (Date) parameters
									.get(parameterName));
						} else {
							query.setParameter(parameterName, parameters
									.get(parameterName));
						}
					}
				}
				if (pagingAndSorting != null && !pagingAndSorting.isAll()) {
					query.setFirstResult(pagingAndSorting.getFirstResult());
					if (pagingAndSorting.getMaxResults() != -1) {
						query.setMaxResults(pagingAndSorting.getMaxResults());
					}
					query.setFetchSize(getFetchSize(pagingAndSorting
							.getFirstResult()));
				}
				List results = query.list();
				return results;
			}
		});
	}

	/**
	 * update or delete use HQL
	 */
	public int execute(final String HQLString) {
		return this.execute(HQLString, null);
	}

	/**
	 * update or delete use HQL
	 */
	public int execute(final String HQLString, final Map parameters) {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(HQLString);
				if (parameters != null && !parameters.isEmpty()) {
					Iterator iter = parameters.keySet().iterator();
					while (iter.hasNext()) {
						String parameterName = (String) iter.next();
						if (parameters.get(parameterName) instanceof Date) {
							query.setTimestamp(parameterName, (Date) parameters
									.get(parameterName));
						} else {
							query.setParameter(parameterName, parameters
									.get(parameterName));
						}

					}
				}
				return new Integer(query.executeUpdate());
			}
		});
		return ((Integer) obj).intValue();
	}

//	public Object uniqueResult(final String HQLString) {
//		return getHibernateTemplate().execute(new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				Query query = session.createQuery(HQLString);
//				Object results = query.uniqueResult();
//				return results;
//			}
//		});
//	}
//
//	public Object uniqueResult(final String HQLString, final Map parameters) {
//		return getHibernateTemplate().execute(new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				Query query = session.createQuery(HQLString);
//				if (parameters != null && !parameters.isEmpty()) {
//					Iterator iter = parameters.keySet().iterator();
//					while (iter.hasNext()) {
//						String parameterName = (String) iter.next();
//						if (parameters.get(parameterName) instanceof Date) {
//							query.setDate(parameterName, (Date) parameters
//									.get(parameterName));
//						} else {
//							query.setParameter(parameterName, parameters
//									.get(parameterName));
//						}
//					}
//				}
//
//				Object results = query.uniqueResult();
//				return results;
//			}
//		});
//	}

	public int executeSQL(final String SQLString) {
		return executeSQL(SQLString, null);
	}

	public int executeSQL(final String SQLString, final Map parameters) {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(SQLString);
				if (parameters != null && !parameters.isEmpty()) {
					Iterator iter = parameters.keySet().iterator();
					while (iter.hasNext()) {
						String parameterName = (String) iter.next();
						if (parameters.get(parameterName) instanceof Date) {
							query.setDate(parameterName, (Date) parameters
									.get(parameterName));
						} else {
							query.setParameter(parameterName, parameters
									.get(parameterName));
						}

					}
				}
				return new Integer(query.executeUpdate());
			}

		});
		return ((Integer) obj).intValue();
	}

	public static int getFetchSize(int firstRow) {
		if (firstRow > 150) {
			return firstRow > 10000 ? 150 : firstRow > 5000 ? 100
					: firstRow > 1000 ? 50 : 30;
		}
		if (firstRow > 100)
			return 15;
		if (firstRow > 50)
			return 10;
		return 0;
	}

	public List findBySQL(String SQLString) {
		return findBySQL(SQLString, null, null);
	}
	
	public List findBySQL(String SQLString,Map parameters,PagingAndSorting pagingAndSorting){
		return this.findBySQL(SQLString,parameters,pagingAndSorting,false);
	}

	public List findBySQL(final String SQLString, final Map parameters,
			final PagingAndSorting pagingAndSorting,final boolean useCache) {
		Object obj = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(PagingAndSorting
						.buildOrderBy(SQLString, pagingAndSorting));
				query.setCacheable(useCache);
				if (parameters != null && !parameters.isEmpty()) {
					Iterator iter = parameters.keySet().iterator();
					while (iter.hasNext()) {
						String parameterName = (String) iter.next();
						if (parameters.get(parameterName) instanceof Date) {
							query.setDate(parameterName, (Date) parameters
									.get(parameterName));
						} else {
							query.setParameter(parameterName, parameters
									.get(parameterName));
						}
					}
				}

				if (pagingAndSorting != null && !pagingAndSorting.isAll()) {
					query.setFirstResult(pagingAndSorting.getFirstResult());
					if (pagingAndSorting.getMaxResults() != -1) {
						query.setMaxResults(pagingAndSorting.getMaxResults());
					}
					query.setFetchSize(getFetchSize(pagingAndSorting
							.getFirstResult()));
				}
				return query.list();
			}

		});
		return (List) obj;
	}
	
	
	
	
	/** removed by wangliang 20090322
	public int getRowCount(String _queryString, Map _namedParameters){
		return getRowCount1(_queryString,_namedParameters,false);
	}
	public int getRowCountBySQL(String _queryString, Map _namedParameters){
		return getRowCount1(_queryString,_namedParameters,true);
	}

	private int getRowCount1(String _queryString, Map _namedParameters,
			boolean _useSQL) {
		int rowCount = 0;
		List list;
//		int i = -1;
//		if (!(_queryString.trim().toLowerCase().startsWith("from")))
//			i = _queryString.trim().toLowerCase().indexOf(" from ");
//
//		String queryStringCount = _queryString.trim();
		
		String queryStringCount =("select count(*) "+SqlUtils.removeSelect(_queryString) ).trim();
		
		
		int groupby = queryStringCount.toLowerCase().indexOf(" group ");
		if (groupby > 0) {

			int iorder = queryStringCount.indexOf(" order ", groupby);
			if (iorder > 0) {
				//queryStringCount = _queryString.trim().substring(0, iorder);
				queryStringCount = queryStringCount.substring(0, iorder);
			}
		}

		int posOrderBy = queryStringCount.toLowerCase().indexOf(" order ");
		if (posOrderBy > 0) {
			//queryStringCount = _queryString.trim().substring(0, posOrderBy);
			queryStringCount = queryStringCount.substring(0, posOrderBy);
		}

//		String _queryStringCount = "select count(*) ";
//		if (i > 0) {
//			_queryStringCount = _queryStringCount
//					+ queryStringCount.substring(i);
//		} else {
//			_queryStringCount = _queryStringCount + queryStringCount;
//		}

		if (!_useSQL) {
			//list = find(_queryStringCount, _namedParameters, null);
			list = find(queryStringCount, _namedParameters, null);
			if (list.size() == 0) {
			} else {
				int count = 0;
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					Number value = (Number) iterator.next();
					if (groupby > 0)
						count++;
					else
						count += value.intValue();
				}
				rowCount = count;
			}

		} else {

			//list = findBySQL(_queryStringCount, _namedParameters, null);
			list = findBySQL(queryStringCount, _namedParameters, null);
			if (list.size() == 0) {
			} else {
				rowCount = ((Number) list.get(0)).intValue();
			}
		}

		return rowCount;
	}
	
	
	**/
	
	
	public List find(String HQLString, Map parameters,PagingAndSorting pagingAndSorting) {
		return this.find(HQLString, parameters, pagingAndSorting,false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public int executeSelectCount(String queryStringCount, Map _namedParameters){
//		return getRowCount2009(queryStringCount,_namedParameters,false);
//	}
//	public int executeSelectCountBySQL(String queryStringCount, Map _namedParameters){
//		return getRowCount2009(queryStringCount,_namedParameters,true);
//	}
//
//	private int getRowCount2009(String queryStringCount, Map _namedParameters,boolean _useSQL) {
//		int rowCount = 0;
//		List list = null;
//		if (!_useSQL) {
//			list = find(queryStringCount, _namedParameters, null);
//			if (list.size() == 0) {
//			} else {
//				int count = 0;
//				Iterator iterator = list.iterator();
//				while (iterator.hasNext()) {
//					Number value = (Number) iterator.next();
//					if (queryStringCount.toLowerCase().indexOf(" group by ") > 0)
//						count++;
//					else
//						count += value.intValue();
//				}
//				rowCount = count;
//			}
//
//		} else {
//			list = findBySQL(queryStringCount, _namedParameters, null);
//			if (list.size() == 0) {
//			} else {
//				rowCount = ((Number) list.get(0)).intValue();
//			}
//		}
//		return rowCount;
//	}
	
	
	
}
