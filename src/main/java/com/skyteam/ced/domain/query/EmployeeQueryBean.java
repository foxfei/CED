package com.skyteam.ced.domain.query;

import java.util.Date;

/**
 * 
 * @author liang.wang@footmarktech.com
 *
 */
public class EmployeeQueryBean implements java.io.Serializable {
	private static final long serialVersionUID = 5033501554695915389L;
	private String name;
	private String age;
	private Date beginOpDate;
	public Date getBeginOpDate() {
		return beginOpDate;
	}
	public void setBeginOpDate(Date beginOpDate) {
		this.beginOpDate = beginOpDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
