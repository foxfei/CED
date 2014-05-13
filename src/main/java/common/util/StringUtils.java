package common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public final class StringUtils {
	public static List substring(String source, String startMark,
			String endMark, boolean containBeginMarkAndEndMark) {
		ArrayList arrayList = new ArrayList();
		int a = 0;
		int b = 0;
		int c = 0;
		while (a != -1 && b != -1) {
			a = source.indexOf(startMark, c);
			if (a != -1) {
				b = source.indexOf(endMark, a);
				if (b != -1) {
					String temp = source.substring(a + startMark.length(), b);
					if (containBeginMarkAndEndMark) {
						temp = source.substring(a, b + endMark.length());
					}
					arrayList.add(temp);
					c = b;
				}
			}
		}
		return arrayList;
	}

	public static List substring(StringBuffer arg0, int _begin, int _end,
			String _prifix, String _suffix) {
		List results = new ArrayList();
		int keyStart = _begin;
		int keyEnd = keyStart;
		while (true) {
			keyStart = arg0.indexOf(_prifix, keyStart);
			if (keyStart > _end || keyStart < 0)
				break;
			keyEnd = arg0.indexOf(_suffix, keyStart);
			if (keyEnd > _end || keyEnd < 0)
				break;
			String key = arg0.substring(keyStart + 1, keyEnd);
			results.add(key);
			keyStart = keyEnd;
		}
		return results;
	}
	/**
	 * @param input
	 * @return
	 */
	public static String toSBC(String input) {
		if (input == null)
			return input;
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}
	/**
	 * @param input
	 * @return
	 */
	public static String toDBC(String input) {
		if (input == null)
			return input;
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}
}