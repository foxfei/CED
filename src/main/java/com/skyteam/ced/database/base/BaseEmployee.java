package com.skyteam.ced.database.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee"
 */

public abstract class BaseEmployee  implements Serializable {

	public static String REF = "Employee";
	public static String PROP_NAME = "Name";
	public static String PROP_AGE = "Age";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_OP_DATE = "OpDate";


	// constructors
	public BaseEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployee (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmployee (
		java.lang.String id,
		java.lang.String name,
		java.lang.String age,
		java.lang.String remark,
		java.util.Date opDate) {

		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setRemark(remark);
		this.setOpDate(opDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String age;
	private java.lang.String remark;
	private java.util.Date opDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="id"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: op_date
	 */
	public java.util.Date getOpDate () {
		return opDate;
	}

	/**
	 * Set the value related to the column: op_date
	 * @param opDate the op_date value
	 */
	public void setOpDate (java.util.Date opDate) {
		this.opDate = opDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.skyteam.ced.database.Employee)) return false;
		else {
			com.skyteam.ced.database.Employee employee = (com.skyteam.ced.database.Employee) obj;
			if (null == this.getId() || null == employee.getId()) return false;
			else return (this.getId().equals(employee.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}