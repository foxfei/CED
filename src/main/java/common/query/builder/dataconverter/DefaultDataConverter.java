package common.query.builder.dataconverter;

import common.query.builder.DataConverter;
import common.query.builder.DefaultUtils;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class DefaultDataConverter implements DataConverter {
	private static final String DEFAULT_STRING = "";

	public Object convert(Object value, String obj1) {
		if (value == null)
			return DefaultUtils.defaultString(obj1, DEFAULT_STRING);
		return value;
	}
}
