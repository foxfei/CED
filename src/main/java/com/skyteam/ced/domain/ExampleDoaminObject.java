/**
 * 
 */
package com.skyteam.ced.domain;

/**
 * domain对象， 一般用于前台页面显示与hibernate实体之间相互转化
 * 
 * @author mickey
 *
 */
public class ExampleDoaminObject {
	private String name;
	private int age;
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
