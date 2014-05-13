package common.query.builder.dataconverter;

import common.query.builder.DataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class ShortDataConverter implements DataConverter {
	public Object convert(Object value, String obj1) {
		if (value == null)
			return null;
		if (value instanceof Short)
			return value;
		return new Short(value.toString());
	}
}
