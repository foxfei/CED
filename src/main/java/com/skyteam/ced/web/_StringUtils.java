package com.skyteam.ced.web;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class _StringUtils {

	static public String UTF2GB(String utfString) {
		StringTokenizer st = new StringTokenizer(utfString, "\\u");
		StringBuffer sb = new StringBuffer();
		while (st.hasMoreTokens()) {
			String ii = st.nextToken();
			int x = Integer.parseInt(ii, 16);
			char c = (char) x;
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static String main(String xxx) {
		String[] yyyy1 = xxx.split(" ");
		String nnn = "";
		for (int j = 0; j < yyyy1.length; j++) {
			nnn = nnn + UTF2GB(yyyy1[j]);
		}

		return nnn;
	}

}
