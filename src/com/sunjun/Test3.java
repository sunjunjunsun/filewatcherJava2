package com.sunjun;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test3 {
	public static void main(String[] args) throws ParseException {
		String timers = "2020-05-22T19:01:55.000+08:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date = df.parse(timers);
		SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		Date date1 = df1.parse(date.toString());
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String value = df2.format(date1);
		// String value = df2.format(date);
		System.out.println(value); //2020-05-22 19:01:55

	}
}
