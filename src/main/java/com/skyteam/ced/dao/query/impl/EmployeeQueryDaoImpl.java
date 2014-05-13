package com.skyteam.ced.dao.query.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.database.Employee;

import common.query.Query;
import common.query.QueryUtils;

public class EmployeeQueryDaoImpl extends BaseQueryDao{
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unchecked")
	@Override
	protected Query createQuery(Map map) {
		
	
		StringBuffer buf = new StringBuffer();
		buf.append(" from " + Employee.class.getName() + " a ");
		buf.append(" where 1=1 ");
		buf.append("  /~ and a." + Employee.PROP_NAME + " = {name} ~/");
		buf.append("  /~ and a." + Employee.PROP_AGE + " = {age} ~/");
		buf.append("  /~ and a." + Employee.PROP_OP_DATE + " >= {beginOpDate} ~/");
		Query query = QueryUtils.filterQuery(buf.toString(), map);
		return query;
	}

	@Override
	protected String createSelect(String temp) {
		return "select a " +temp;
	}
	

}
