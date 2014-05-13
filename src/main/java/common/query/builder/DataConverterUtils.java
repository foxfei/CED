package common.query.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import common.query.builder.dataconverter.BigDecimalDataConverter;
import common.query.builder.dataconverter.BigIntegerDataConverter;
import common.query.builder.dataconverter.BooleanDataConverter;
import common.query.builder.dataconverter.ByteDataConverter;
import common.query.builder.dataconverter.DateDataConverter;
import common.query.builder.dataconverter.DefaultDataConverter;
import common.query.builder.dataconverter.DoubleDataConverter;
import common.query.builder.dataconverter.FloatDataConverter;
import common.query.builder.dataconverter.IntegerDataConverter;
import common.query.builder.dataconverter.LongDataConverter;
import common.query.builder.dataconverter.ShortDataConverter;
import common.query.builder.dataconverter.SqlDateDataConverter;
import common.query.builder.dataconverter.SqlTimeDataConverter;
import common.query.builder.dataconverter.StringDataConverter;
import common.query.builder.dataconverter.StringDataFullLikeConverter;
import common.query.builder.dataconverter.StringDataLeftLikeConverter;
import common.query.builder.dataconverter.StringDataRightLikeConverter;
import common.query.builder.dataconverter.TimestampDataConverter;
/**
 * @author liang.wang@footmarktech.com
 * @version 1.0
 */
public class DataConverterUtils {
	public static final String DATA_CONVERTER_OPERATOR = "?";
	private static final Map converters = new HashMap();

	public static String getConverterVariable(String obj) {
		int index = obj.indexOf(DATA_CONVERTER_OPERATOR);
		if (index == -1)
			return obj;
		return obj.substring(0, index);
	}

	static {
		converters.put("default", new DefaultDataConverter());
		converters.put("boolean", new BooleanDataConverter());
		converters.put("string", new StringDataConverter());
		converters.put("string_ll", new StringDataLeftLikeConverter());
		converters.put("string_rl", new StringDataRightLikeConverter());
		converters.put("string_fl", new StringDataFullLikeConverter());
		converters.put("byte", new ByteDataConverter());
		converters.put("short", new ShortDataConverter());
		converters.put("int", new IntegerDataConverter());
		converters.put("long", new LongDataConverter());
		converters.put("float", new FloatDataConverter());
		converters.put("double", new DoubleDataConverter());
		converters.put("BigInteger", new BigIntegerDataConverter());
		converters.put("BigDecimal", new BigDecimalDataConverter());
		converters.put("date", new DateDataConverter());
		converters.put("sqldate", new SqlDateDataConverter());
		converters.put("sqltime", new SqlTimeDataConverter());
		converters.put("timestamp", new TimestampDataConverter());
	}

	public static Object convert(String obj, Object obj1) {
		int index = obj.indexOf(DATA_CONVERTER_OPERATOR);
		if (index == -1) {
			return obj1;
		}
		String obj11 = obj.substring(index);
		try {
			return directConvert0(obj11, obj1);
		} catch (Exception e) {
			throw new RuntimeException("cannot convert value:" + obj1
					+ " with :" + obj, e);
		}
	}

	public static Object directConvert(String obj, Object obj1) {
		try {
			return directConvert0(obj, obj1);
		} catch (Exception e) {
			throw new RuntimeException("cannot modify value:" + obj1
					+ " with expression:" + obj, e);
		}
	}

	private static Object directConvert0(String obj, Object obj1)
			throws Exception {
		if (StringUtils.isEmpty(obj)) {
			return obj1;
		}
		if (!obj.startsWith(DATA_CONVERTER_OPERATOR)) {
			throw new Exception(
					"Syntax error,DataConverter expression must start with ["
							+ DATA_CONVERTER_OPERATOR + "]. but not :" + obj);
		}

		StringTokenizer tokenizer = new StringTokenizer(obj,
				DATA_CONVERTER_OPERATOR);
		Object result = obj1;
		while (tokenizer.hasMoreElements()) {
			String singleExpression = (String) tokenizer.nextElement();
			String _converterName = singleExpression;
			String _argument = null;
			int index = -1;
			if ((index = singleExpression.indexOf("(")) != -1) {
				if (!singleExpression.endsWith(")")) {
					throw new Exception(
							"Syntax error,dataConverterArguments must wrap with '(arg1,arg2)'");
				}
				_converterName = _converterName.substring(0, index);
				_argument = singleExpression.substring(index + 1,
						singleExpression.length() - 1);
			}

			DataConverter obj0 = (DataConverter) converters.get(_converterName);
			if (obj0 == null)
				throw new Exception("not found DataModifier with give name["
						+ _converterName + "],available modifier names:"
						+ converters.keySet());
			result = obj0.convert(result, _argument);
		}
		return result;
	}

}