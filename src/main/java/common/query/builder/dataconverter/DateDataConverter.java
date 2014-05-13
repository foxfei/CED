package common.query.builder.dataconverter;

import java.text.DateFormat;
import java.util.Date;

import common.query.builder.DataConverter;
import common.query.builder.DefaultUtils;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class DateDataConverter implements DataConverter {

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private String dateFormat = DEFAULT_DATE_FORMAT;

	public DateDataConverter() {
	}

	public DateDataConverter(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Object convert(Object value, String obj1) throws Exception {
		if (value == null)
			return null;
		if (value instanceof Date)
			return value;
		DateFormat df = DefaultUtils.defaultDateFormat(obj1, dateFormat);
		return df.parse(value.toString());
	}
}
