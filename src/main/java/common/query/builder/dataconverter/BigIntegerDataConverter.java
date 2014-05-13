package common.query.builder.dataconverter;

import java.math.BigInteger;

import common.query.builder.DataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class BigIntegerDataConverter implements DataConverter {
	public Object convert(Object value, String obj1) {
		if (value == null)
			return null;
		if (value instanceof BigInteger)
			return value;
		return new BigInteger(value.toString());
	}
}
