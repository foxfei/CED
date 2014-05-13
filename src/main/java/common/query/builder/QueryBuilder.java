package common.query.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import common.query.QueryImpl;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class QueryBuilder {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(QueryImpl.class);

	public static final String QUERY_BLOCK_MARK_PRIFIX = "/~";
	public static final String QUERY_BLOCK_MARK_SUFFIX = "~/";

	public static final String QUERY_NAMED_KEY_PRIFIX = "{";
	public static final String QUERY_NAMED_KEY_SUFFIX = "}";
	public static final String QUERY_REPLACE_KEY_PRIFIX = "[";
	public static final String QUERY_REPLACE_KEY_SUFFIX = "]";

	private class KeyData {
		List namedKeys;
		List replaceKeys;

		public KeyData(List obj, List obj1) {
			this.namedKeys = obj;
			this.replaceKeys = obj1;
		}
	}

	private KeyData getKeyMetaDatas(StringBuffer arg0, int _begin, int _end) {
		List list0 = substring(arg0, _begin, _end, QUERY_NAMED_KEY_PRIFIX,
				QUERY_NAMED_KEY_SUFFIX);
		List list1 = substring(arg0, _begin, _end, QUERY_REPLACE_KEY_PRIFIX,
				QUERY_REPLACE_KEY_SUFFIX);
		return new KeyData(list0, list1);
	}

	public class Result {
		private String queryString;
		private Map namedParameters;

		public Result(String obj, Map obj1) {
			this.setQueryString(obj);
			this.setNamedParameters(obj1);
		}

		public String getQueryString() {
			return queryString;
		}

		public void setQueryString(String queryString) {
			this.queryString = queryString;
		}

		public Map getNamedParameters() {
			return namedParameters;
		}

		public void setNamedParameters(Map namedParameters) {
			this.namedParameters = namedParameters;
		}

	}

	public Result generateNamedParameterQuery(String _queryString, Map _map) {
		Result _result = doFilter(_queryString, _map);
		String _resultQueryString = _result.getQueryString();
		for (Iterator it = _result.getNamedParameters().keySet().iterator(); it
				.hasNext();) {
			Object key = it.next();
			_resultQueryString = StringUtils.replace(_resultQueryString,
					QUERY_NAMED_KEY_PRIFIX + key + QUERY_NAMED_KEY_SUFFIX, ":"
							+ key);
		}
		return new Result(_resultQueryString, _result.getNamedParameters());
	}

	protected boolean isEmpty(Object value) {
		if (value == null) {
			return false;
		}
		if (value instanceof String) {
			return ((String) value).trim().length() > 0;
		} else {
			return true;
		}
	}

	private boolean isAcceptedAllKeys(Map filters, List keys) {
		for (int n = 0; n < keys.size(); n++) {
			String dataModifierExpression = (String) keys.get(n);
			String key = DataConverterUtils
					.getConverterVariable(dataModifierExpression);
			Object value = filters.get(key);
			if (!isEmpty(value)) {
				return false;
			}
		}
		return true;
	}

	public Result doFilter(String xsql, Map filters) {
		return doFilter(new StringBuffer(xsql), filters);
	}

	private Result doFilter(StringBuffer queryString, Map filters) {
		LinkedHashMap acceptedFilters = new LinkedHashMap();
		for (int i = 0, end = 0, start = queryString
				.indexOf(QUERY_BLOCK_MARK_PRIFIX); ((start = queryString
				.indexOf(QUERY_BLOCK_MARK_PRIFIX, end)) >= 0); i++) {
			end = queryString.indexOf(QUERY_BLOCK_MARK_SUFFIX, start);
			KeyData keyData = getKeyMetaDatas(queryString, start, end);

			if (keyData.namedKeys.isEmpty() && keyData.replaceKeys.isEmpty())
				throw new IllegalArgumentException("Not key found in segment="
						+ queryString.substring(start, end
								+ QUERY_BLOCK_MARK_SUFFIX.length()));

			if (isAcceptedAllKeys(filters, keyData.namedKeys)
					&& isAcceptedAllKeys(filters, keyData.replaceKeys)) {

				LOGGER.debug("The filter markKeys="
						+ keyData.namedKeys
						+ " replaceKeys="
						+ keyData.replaceKeys
						+ " is accepted on segment="
						+ queryString.substring(start, end
								+ QUERY_BLOCK_MARK_SUFFIX.length()));

				String segment = queryString.substring(start
						+ QUERY_BLOCK_MARK_PRIFIX.length(), end);
				segment = mergeNamedKeysIntoAcceptedFilters(filters,
						acceptedFilters, keyData, segment);
				segment = replaceReplaceKeysWithValues(filters,
						keyData.replaceKeys, segment);
				queryString.replace(start, end
						+ QUERY_BLOCK_MARK_SUFFIX.length(), segment);
				end = start + segment.length();
			} else {

				LOGGER.debug("The filter markKeys="
						+ keyData.namedKeys
						+ " replaceKeys="
						+ keyData.replaceKeys
						+ " is removed from the query on segment="
						+ queryString.substring(start, end
								+ QUERY_BLOCK_MARK_SUFFIX.length()));

				queryString.replace(start, end
						+ QUERY_BLOCK_MARK_SUFFIX.length(), "");
				end = start;
			}
		}
		return new Result(queryString.toString(), acceptedFilters);
	}

	private String mergeNamedKeysIntoAcceptedFilters(Map filters,
			Map acceptedFilters, KeyData metadatas, String segment) {
		for (int n = 0; n < metadatas.namedKeys.size(); n++) {
			String dataConverterExpression = (String) metadatas.namedKeys
					.get(n);
			String key = DataConverterUtils
					.getConverterVariable(dataConverterExpression);
			Object value = DataConverterUtils.convert(dataConverterExpression,
					filters.get(key));
			acceptedFilters.put(key, value);
			segment = StringUtils.replace(segment, QUERY_NAMED_KEY_PRIFIX
					+ dataConverterExpression + QUERY_NAMED_KEY_SUFFIX,
					QUERY_NAMED_KEY_PRIFIX + key + QUERY_NAMED_KEY_SUFFIX);
		}
		return segment;
	}

	private String replaceReplaceKeysWithValues(Map filters, List replaceKeys,
			String segment) {
		for (int n = 0; n < replaceKeys.size(); n++) {
			String dataConverterExpression = (String) replaceKeys.get(n);
			String key = DataConverterUtils
					.getConverterVariable(dataConverterExpression);
			String value = (String) DataConverterUtils.convert(
					dataConverterExpression, filters.get(key));

			segment = StringUtils
					.replace(segment, QUERY_REPLACE_KEY_PRIFIX
							+ dataConverterExpression
							+ QUERY_REPLACE_KEY_SUFFIX, value);
		}
		return segment;
	}

	public static List substring(String source, String startMark,
			String endMark, boolean containBeginMarkAndEndMark) {
		ArrayList arrayList = new ArrayList();
		int a = 0;
		int b = 0;
		int c = 0;
		while (a != -1 && b != -1) {
			a = source.indexOf(startMark, c);
			if (a != -1) {
				b = source.indexOf(endMark, a);
				if (b != -1) {
					String temp = source.substring(a + startMark.length(), b);
					if (containBeginMarkAndEndMark) {
						temp = source.substring(a, b + endMark.length());
					}
					arrayList.add(temp);
					c = b;
				}
			}
		}
		return arrayList;
	}

	public static List substring(StringBuffer arg0, int _begin, int _end,
			String _prifix, String _suffix) {
		List results = new ArrayList();
		int keyStart = _begin;
		int keyEnd = keyStart;
		while (true) {
			keyStart = arg0.indexOf(_prifix, keyStart);
			if (keyStart > _end || keyStart < 0)
				break;
			keyEnd = arg0.indexOf(_suffix, keyStart);
			if (keyEnd > _end || keyEnd < 0)
				break;
			String key = arg0.substring(keyStart + 1, keyEnd);
			results.add(key);
			keyStart = keyEnd;
		}
		return results;
	}

}
