package com.test.webdriver.day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.bcel.generic.NEW;

import com.gargoylesoftware.htmlunit.WebConsole.Formatter;

public class DateFormat {
	
	
	public String formatDate(Date date) {
		//用到最多的是SimpleDateFormat，在构造时 需要传入格式SSS是毫秒
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return format.format(date);
	}
	
	public String formatDate(long date) {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return format.format(date);
	}
	
	public Date formatDate(String date) {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date d=null;
		try {
			d=format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public long formatTimestamp(String date) {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date d=null;
		try {
			d=format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d.getTime();
	}
	
	public static void main(String[] args) {
		DateFormat df=new DateFormat();
		//new Date() 就是当前系统时间，类似System.currentTimeMillis
		System.out.println(new Date());
		System.out.println(System.currentTimeMillis());
		
		System.out.println(df.formatDate(new Date()));
		System.out.println(df.formatDate(System.currentTimeMillis()));
		System.out.println(df.formatDate("2018-02-01 15:32:11.860"));
		System.out.println(df.formatTimestamp("2018-02-01 15:32:12.860"));
		System.out.println(System.currentTimeMillis());
	}

}
