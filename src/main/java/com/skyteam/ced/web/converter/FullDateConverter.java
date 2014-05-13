/**
 * 
 */
package com.skyteam.ced.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * @author Jiahao.Shao
 *
 */
public class FullDateConverter extends StrutsTypeConverter {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		try {
			return sdf.parse(arg1[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Date){
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			return sdf.format(arg1);
		}
		return null;
	}
}
