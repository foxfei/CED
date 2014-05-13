package common.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;





public class CommonUtil {
	
	
    public static boolean checkFieldBlank(String checkString ) {
    	if (checkString == null || checkString.trim().equals("")) {
    		return true;
    	} else {
    	    return false;
    	}
    }
    
    public static String convertDateToString(Date date, boolean keepHMS ) {
    	if (date == null ) {
    		return new String(" ");
    	} else {
            Format dateformat = null;
            if (keepHMS == false ) {
            	dateformat = new SimpleDateFormat("yyyy-MM-dd");
            } else {
            	dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
            }
            return dateformat.format(date);
    	}
    }
    
    public static String formatMillionSecond(long ms ) {//将毫秒数换算成x天x时x分x秒x毫秒
    	int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;
        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        String strDay = day < 10 ? "0" + day : "" + day;
        String strHour = hour < 10 ? "0" + hour : "" + hour;
        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
        
        //return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
        
        return strHour + ":" + strMinute + ":" + strSecond;
        
    } 

}