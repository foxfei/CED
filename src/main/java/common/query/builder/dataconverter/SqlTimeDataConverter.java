package common.query.builder.dataconverter;

import java.sql.Time;
import java.text.DateFormat;

import common.query.builder.DataConverter;
import common.query.builder.DefaultUtils;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class SqlTimeDataConverter implements DataConverter {

	private static final String DEFAULT_SQLTIME_FORMAT = "HH:mm:ss";

	private String dateFormat = DEFAULT_SQLTIME_FORMAT;

	public SqlTimeDataConverter() {
	}

	public SqlTimeDataConverter(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Object convert(Object value, String obj1) throws Exception {
		if (value == null)
			return null;
		if (value instanceof java.sql.Time)
			return value;
		DateFormat df = DefaultUtils.defaultDateFormat(obj1, dateFormat);
		return new Time(df.parse(value.toString()).getTime());
	}
}
