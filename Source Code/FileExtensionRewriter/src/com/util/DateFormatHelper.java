/**
 * 
 */
package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Lini 07-Mar-2020 Last modified on 05/01/2023
 */
public class DateFormatHelper {

	public static Date convertTo24HourFormat(String time_12HourFormats) {
		try {
			SimpleDateFormat pf = new SimpleDateFormat("hh:mm a");
			return pf.parse(time_12HourFormats);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convertToDisplayFormat(Date date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getCombinedDateTime(Date date, Date time) {
		try {
			SimpleDateFormat pf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
			return pf.parse(convertToDisplayFormat(date) + " " + getTimeIn12hourFormat(time));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getCurrentTimeAsDateType() {
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(1970, 0, 1);
			return cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDateFromDate(Date date) {
		try {
			SimpleDateFormat pf = new SimpleDateFormat("dd/MM/yyyy");
			return pf.parse(convertToDisplayFormat(date));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDateFromString(String dateDdMmYyyyy) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(dateDdMmYyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDateFromString(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getDateTimeString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getDateXDaysBefore(Date dt, int count) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DATE, -count);
			return c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getTimeIn12hourFormat(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getTimeIn24hourFormat(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getTodaysDate() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date today = new Date();
			return formatter.parse(formatter.format(today));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getTimeStampString() {
		try {
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.format(today);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
