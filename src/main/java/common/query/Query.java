package common.query;

import java.util.Map;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public interface Query extends java.io.Serializable {
	static final String WHITE_SPACE = " ";

	Query setParameter(String parameterKey, Object val);

	Query setParameters(Map map);

	Map getNamedParameters();

	String getQueryString();

	Query appendQuery(String queryString, String parameterKey,
			boolean appendCondition, Object parameterVal);

	Query appendQuery(String queryString, boolean appendCondition,
			Object parameterVal);

	Query appendQuery(String queryString);

	Query setParameter(Object parameterVal);

	Query insertQuery(String insertPatchString, String keyword,
			boolean appendBehind);
}
