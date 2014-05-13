package common.query.builder.dataconverter;

import java.sql.Timestamp;
import java.text.DateFormat;

import common.query.builder.DataConverter;
import common.query.builder.DefaultUtils;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class TimestampDataConverter implements DataConverter {
	private static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	private String dateFormat = DEFAULT_TIMESTAMP_FORMAT;

	public TimestampDataConverter() {
	}

	public TimestampDataConverter(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Object convert(Object value, String obj1) throws Exception {
		if (value == null)
			return null;
		if (value instanceof Timestamp)
			return value;
		DateFormat df = DefaultUtils.defaultDateFormat(obj1, dateFormat);
		return new Timestamp(df.parse(value.toString()).getTime());
	}

}
