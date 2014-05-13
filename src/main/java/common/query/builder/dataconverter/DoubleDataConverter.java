package common.query.builder.dataconverter;

import common.query.builder.DataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class DoubleDataConverter implements DataConverter {
	public Object convert(Object value, String obj1) {
		if (value == null)
			return null;
		if (value instanceof Double)
			return value;
		return new Double(value.toString());
	}
}
