package common.query.builder.dataconverter;

import java.text.DateFormat;

import common.query.builder.DataConverter;
import common.query.builder.DefaultUtils;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class SqlDateDataConverter implements DataConverter {
	private static final String DEFAULT_SQLDATE_FORMAT = "yyyy-MM-dd";

	private String dateFormat = DEFAULT_SQLDATE_FORMAT;

	public SqlDateDataConverter() {
	}

	public SqlDateDataConverter(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Object convert(Object value, String obj1) throws Exception {
		if (value == null)
			return null;
		if (value instanceof java.sql.Date)
			return value;
		DateFormat df = DefaultUtils.defaultDateFormat(obj1, dateFormat);
		return new java.sql.Date(df.parse(value.toString()).getTime());
	}
}
