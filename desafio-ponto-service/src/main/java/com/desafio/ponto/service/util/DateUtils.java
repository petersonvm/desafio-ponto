package com.desafio.ponto.service.util;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;


public class DateUtils {
	
	private static String DATE_PATTERN =  "dd/MM/yyyy HH:mm";
	
	
	public static Date atStartOfDay(Date date) {
	    LocalDateTime localDateTime = dateToLocalDateTime(date);
	    LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
	    return localDateTimeToDate(startOfDay);
	}

	public static Date atEndOfDay(Date date) {
	    LocalDateTime localDateTime = dateToLocalDateTime(date);
	    LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
	    return localDateTimeToDate(endOfDay);
	}
	
	public static String readableDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date);
	}
	
	public static boolean isSaturday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
	}
	
	public static boolean isSunday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}

	public static boolean isWeekday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return !(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}
	

	private static LocalDateTime dateToLocalDateTime(Date date) {
	    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	private static Date localDateTimeToDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
