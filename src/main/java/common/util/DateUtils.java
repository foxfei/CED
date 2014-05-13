package common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public final class DateUtils {
	private DateUtils() {

	}
	static public Date cleanDate(Date _date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DATE), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	static public Date cleanMonth(Date _date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	static public Date createDate(int _year, int _month, int _date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(_year, _month, _date, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	static public Date add(Date date, int calendarField, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendarField, amount);
		return calendar.getTime();
	}
}
