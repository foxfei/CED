package common.query;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class QueryImpl implements Query {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(QueryImpl.class);
	private static final long serialVersionUID = 6975842856000346030L;
	private String queryString = "";
	private Map namedParameters = Collections.synchronizedMap(new HashMap());

	// private boolean useSql;

	public QueryImpl() {
	}

	synchronized public Query setParameter(Object val) {
		String queryString = getQueryString();
		autoSetParameter(queryString, val);
		return this;
	}

	// public boolean isUseSql() {
	// return useSql;
	// }
	//
	// public void setUseSql(boolean _useSql) {
	// this.useSql = _useSql;
	// }

	synchronized private void autoSetParameter(String queryString, Object val) {
		String mark = ":";
		String parameterKey = null;
		int i = queryString.indexOf(mark);
		if (i != -1) {
			queryString = queryString.substring(i + mark.length());

			int j = queryString.indexOf(" ");
			if (j != -1) {
				parameterKey = StringUtils.substring(queryString, 0, j);
			} else {
				parameterKey = StringUtils.substring(queryString, 0,
						queryString.length());
			}
			LOGGER.info(parameterKey);

			if (!getNamedParameters().containsKey(parameterKey)) {
				this.setParameter(parameterKey, val);
			} else {
				autoSetParameter(queryString, val);
			}
		}

	}

	synchronized public Query setParameter(String parameterKey,
			Object parameterVal) {
		this.getNamedParameters().put(parameterKey, parameterVal);
		return this;
	}

	synchronized public Query appendQuery(String queryString) {
		if (queryString != null) {
			this.setQueryString(getQueryString() + queryString);
		}
		return this;
	}

	synchronized public String getQueryString() {
		return queryString;
	}

	synchronized void setQueryString(String queryString) {
		if (queryString != null) {
			this.queryString = StringUtils.trim(queryString);
		}
	}

	synchronized public Map getNamedParameters() {
		return namedParameters;
	}

	synchronized void setNamedParameters(Map namedParameters) {
		this.namedParameters = namedParameters;
	}

	synchronized public Query appendQuery(String queryString,
			String parameterKey, boolean appendCondition, Object parameterVal) {
		if (appendCondition) {
			this.appendQuery(queryString);
			this.setParameter(parameterKey, parameterVal);
		}
		return this;
	}

	synchronized public Query appendQuery(String queryString,
			boolean appendCondition, Object parameterVal) {
		if (appendCondition) {
			this.appendQuery(queryString);
			this.setParameter(parameterVal);
		}
		return this;
	}

	synchronized public Query insertQuery(String insertPatchString,
			String keyword, boolean appendBehind) {
		String queryString_old = getQueryString();
		String queryString_new = "";
		if (keyword == null) {
			if (appendBehind) {
				if (insertPatchString != null) {
					queryString_new = queryString_old + WHITE_SPACE
							+ insertPatchString;
				} else {
					queryString_new = queryString_old;
				}
			} else {
				if (insertPatchString != null) {
					queryString_new = insertPatchString + WHITE_SPACE
							+ queryString_old;
				}
			}
		} else {
			String tmp = StringUtils.lowerCase(queryString_old);
			int i = StringUtils.indexOf(tmp, StringUtils.lowerCase(keyword));
			if (i == -1)
				throw new RuntimeException("'" + keyword + "' not cotains in '"
						+ queryString_old + "'");

			StringBuffer strBuffer = new StringBuffer(queryString_old);

			if (appendBehind) {
				if (insertPatchString != null) {
					strBuffer = strBuffer.insert(i + keyword.length(),
							WHITE_SPACE + insertPatchString);
				}
			} else {
				if (insertPatchString != null) {
					strBuffer = strBuffer.insert(i, insertPatchString
							+ WHITE_SPACE);
				}
			}
			queryString_new = strBuffer.toString();

		}

		this.setQueryString(queryString_new);
		return this;
	}

	synchronized public Query setParameters(Map map) {
		setNamedParameters(map);
		return this;
	}

}
