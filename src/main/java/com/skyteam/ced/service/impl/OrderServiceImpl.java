package com.skyteam.ced.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.business.exception.BusinessException;
import com.skyteam.ced.business.impl.EmployeeManagerImpl;
import com.skyteam.ced.domain.Employee;
import com.skyteam.ced.service.OrderService;

public class OrderServiceImpl implements OrderService {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private EmployeeManagerImpl employeeManager;

	public void setEmployeeManager(EmployeeManagerImpl employeeManager) {
		this.employeeManager = employeeManager;
	}

	public Employee createEmployee(Employee example) {
		return employeeManager.create(example);
	}

	public Employee findEmployeeById(String id) {
		return employeeManager.findById(id);
	}

	public void updateEmployee(Employee example) {
		if (true) {
			throw new BusinessException("XXXX");
		}
		employeeManager.update(example);

	}

	public void deleteEmployeeById(String id) {
		employeeManager.deleteById(id);
	}

	public List findAllEmployee() {
		return employeeManager.findAll();
	}
}
