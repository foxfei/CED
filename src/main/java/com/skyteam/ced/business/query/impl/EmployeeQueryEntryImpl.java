package com.skyteam.ced.business.query.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.business.impl.EmployeeManagerImpl;
import com.skyteam.ced.database.Employee;
/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class EmployeeQueryEntryImpl extends BaseQueryEntryImpl{
	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	private EmployeeManagerImpl employeeManager;
	
	public EmployeeManagerImpl getEmployeeManager() {
		return employeeManager;
	}

	public void setEmployeeManager(EmployeeManagerImpl employeeManager) {
		this.employeeManager = employeeManager;
	}

	@Override
	protected Object cast(Object obj) {
		Employee d = (Employee)obj;
		return employeeManager.castToEmployeeDomain(d);
	}





}
