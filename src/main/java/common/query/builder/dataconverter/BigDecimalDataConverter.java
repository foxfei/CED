package common.query.builder.dataconverter;

import java.math.BigDecimal;

import common.query.builder.DataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class BigDecimalDataConverter implements DataConverter {
	public Object convert(Object value, String obj1) {
		if (value == null)
			return null;
		if(value instanceof BigDecimal) return value;
		return new BigDecimal(value.toString());
	}
}
