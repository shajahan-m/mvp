package com.mvp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	private DateUtils() {

	}

	public static String getCurrentDateWithTime() {

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyy-MM-d HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat.format(date);

	}
}
