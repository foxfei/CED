package com.skyteam.ced.web.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 
 * @author wangliang_gz@qq.com
 * 
 */
public class DateConverter extends StrutsTypeConverter {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		DateFormat[] allows = { new SimpleDateFormat(DEFAULT_DATE_FORMAT),
				new SimpleDateFormat("dd/MM/yyyy"),
				new SimpleDateFormat("yyyy/MM/dd") };

		if (values[0] == null || values[0].trim().equals(""))
			return null;
		for (DateFormat format : allows) {
			try {
				return format.parse(values[0]);
			} catch (ParseException e) {
				continue;
			} catch (RuntimeException e) {
				continue;
			}
		}
		return null;

	}

	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Date) {
			SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			try {
				return format.format((Date) o);
			} catch (RuntimeException e) {
				return "";
			}
		}
		return "";
	}

	public DateConverter() {
	}

}
