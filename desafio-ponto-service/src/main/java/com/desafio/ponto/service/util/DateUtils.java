package com.desafio.ponto.service.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
	public static String readableDateHour(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(date);
	}	
	
	public static String readableHour(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
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
	
	public static boolean isAfterTenPM(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		return c1.after(getCalendarTenPM(date));
	}
	
	public static boolean isBeforeSixAM(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		return c1.before(getCalendarSixAm(date));
	}
	
	public static Calendar getCalendarTenPM(Date date) {
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
		c2.set(Calendar.MONTH, c1.get(Calendar.MONTH));
		c2.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));
		c2.set(Calendar.HOUR, 10);
		c2.set(Calendar.MINUTE, 00);
		c2.set(Calendar.SECOND, 00);
		c2.set(Calendar.AM_PM, Calendar.PM);

		return c2;
	}
	
	
	public static Calendar getCalendarSixAm(Date date) {
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
		c2.set(Calendar.MONTH, c1.get(Calendar.MONTH));
		c2.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));
		c2.set(Calendar.HOUR, 6);
		c2.set(Calendar.MINUTE, 00);
		c2.set(Calendar.SECOND, 00);
		c2.set(Calendar.AM_PM, Calendar.AM);

		return c2;
	}
	
	public static boolean isBetweenTenAndMidnight(Date date) {
		return (DateUtils.isAfterTenPM(date) & date.before(DateUtils.atEndOfDay(date)));
	}
	
	public static boolean isBetweenMidnightAndSix(Date date) {
		return (DateUtils.isBeforeSixAM(date) & date.after(DateUtils.atStartOfDay(date)));
	}
	
	private static LocalDateTime dateToLocalDateTime(Date date) {
	    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	private static Date localDateTimeToDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
