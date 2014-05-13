package com.skyteam.ced.database;

import com.skyteam.ced.database.base.BaseEmployee;



public class Employee extends BaseEmployee {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Employee () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Employee (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Employee (
		java.lang.String id,
		java.lang.String name,
		java.lang.String age,
		java.lang.String remark,
		java.util.Date opDate) {

		super (
			id,
			name,
			age,
			remark,
			opDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}