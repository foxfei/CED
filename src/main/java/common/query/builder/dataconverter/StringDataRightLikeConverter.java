package common.query.builder.dataconverter;

import common.query.builder.DataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class StringDataRightLikeConverter implements DataConverter {
	public Object convert(Object value, String obj1) {
		if (value == null)
			return null;
		if (value instanceof String)
			return value+"%";
		return value.toString();
	}
}
