package com.test.webdriver.day4;

public class Person {

	Person person1=new Person();
	Person person2=new Person();
	
	/*
	 * person.getClass 得到的Class 类型是person对象的字节码文件对象（Person.class）
	 * 
	 */
	Class clazz1=person1.getClass();
	Class clazz2=person2.getClass();
	
}
