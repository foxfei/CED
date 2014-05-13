package common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class ObjectArrayUtils {

	public static Integer getIntegerValue(Object[] source, int index,
			Integer nullVal) {
		if (ArrayUtils.isEmpty(source) || ArrayUtils.getLength(source) <= index)
			return nullVal;
		Object _val = source[index];
		return NumberUtils.createInteger(String.valueOf(_val));
	}

	public static Long getIntegerValue(Object[] source, int index, Long nullVal) {
		if (ArrayUtils.isEmpty(source) || ArrayUtils.getLength(source) <= index)
			return nullVal;
		Object _val = source[index];
		return NumberUtils.createLong(String.valueOf(_val));
	}

	public static String getStringValue(Object[] source, int index,
			String nullVal) {
		if (ArrayUtils.isEmpty(source) || ArrayUtils.getLength(source) <= index)
			return nullVal;

		Object _val = source[index];

		return ObjectUtils.toString(_val, nullVal);
	}
	
	public static Object getObjectValue(Object[] source, int index,
			Object nullVal) {
		if (ArrayUtils.isEmpty(source) || ArrayUtils.getLength(source) <= index)
			return nullVal;

		Object _val = source[index];

		return _val;
	}

}
