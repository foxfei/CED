package common.query;

import java.util.Map;

import common.query.builder.QueryBuilder;


/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public final class QueryUtils {
	private QueryUtils(){}
	public static Query createQuery() {
		return new QueryImpl();

	}

	public static Query createQuery(String queryString) {
		Query query = QueryUtils.createQuery();
		query.appendQuery(queryString);
		return query;
	}

	public static Query filterQuery(StringBuffer queryString, Map filters) {
		return QueryUtils.filterQuery(String.valueOf(queryString), filters);
	}
	public static Query filterQuery(String queryString, Map filters) {
		//del by wangliang no more need this ,use tapestry TextField to trim your input strings 20090227
//		Iterator it = filters.keySet().iterator();
//		while (it.hasNext()) {
//			Object key = it.next();
//			Object val = filters.get(key);
//			if (val != null && (val instanceof String)) {
//				String temp = (String) val;
//				temp = temp.trim();
//				filters.put(key, temp);
//			}
//		}

		QueryBuilder _builder = new QueryBuilder();
		QueryBuilder.Result result = _builder.generateNamedParameterQuery(
				queryString, filters);
		Query query = QueryUtils.createQuery().appendQuery(
				result.getQueryString()).setParameters(
				result.getNamedParameters());
		return query;
	}
//
//	public static void main(String[] args) {
//		String xsql = "from User a where 1=1 "
//				+ "/~ and a.Username = {username} ~/"
//				+ "/~ and a.Password = {password} ~/"
//				+ "/~ and a.Age = {age} ~/"
//				+ "/~ and a.Sex like {sex?string_fl} ~/"
//				+ "/~ and a.Test like '%[like]%' ~/";
//		Map filters = new HashMap();
//		filters.put("username", "badqiu ");
//		filters.put("password", "adfasdf");
//		filters.put("sex", "11");
//		filters.put("like", "xxx");
//		Query query = QueryUtils.filterQuery(xsql, filters);
//		System.out.println(query.getQueryString());
//
//		Iterator it = query.getNamedParameters().keySet().iterator();
//		while (it.hasNext()) {
//			Object obj = it.next();
//			Object obj1 = query.getNamedParameters().get(obj);
//			System.out.print(obj);
//			System.out.print("==>");
//			System.out.print(obj1.getClass());
//			System.out.print("==>");
//			System.out.println(obj1);
//
//		}
//
//	}
}
