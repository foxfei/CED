package com.skyteam.ced.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skyteam.ced.dao.impl.hibernate3.EmployeeDaoImpl;

public class EmployeeManagerImpl {
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	private EmployeeDaoImpl employeeDao;

	public EmployeeDaoImpl getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public List findAll(){
		List list = new ArrayList();
		com.skyteam.ced.database.Employee[] list1  = employeeDao.findAll();
		
		if(list1!=null){
			for(int i=0;i<list1.length;i++){
				list.add(this.castToEmployeeDomain(list1[i]));
			}
		}
		
		return list;
		
	}
	
	public void deleteById(String id){
		employeeDao.deleteById(id);
	}
	
	public com.skyteam.ced.domain.Employee create(com.skyteam.ced.domain.Employee domain){
		com.skyteam.ced.database.Employee _database = castToEmployeeOrm(domain);
		String id = employeeDao.save(_database);
		domain.setId(id);
		return domain;
	}
	
	public void update(com.skyteam.ced.domain.Employee domain){
		com.skyteam.ced.database.Employee _database = castToEmployeeOrm(domain);
		employeeDao.update(_database);
	}
	
	
	public com.skyteam.ced.domain.Employee findById(String id){
		com.skyteam.ced.database.Employee _database = employeeDao.findById(id);
		return this.castToEmployeeDomain(_database);
	}
	
	
	
	
	public com.skyteam.ced.domain.Employee castToEmployeeDomain(com.skyteam.ced.database.Employee _example){
		 com.skyteam.ced.domain.Employee _domain = new com.skyteam.ced.domain.Employee();
		 if(_example!=null){
			 _domain.setId(_example.getId());
			 _domain.setName(_example.getName());
			 _domain.setRemark(_example.getRemark());
			 _domain.setOpDate(_example.getOpDate());
			 _domain.setAge(_example.getAge());
		 }
		 return _domain;
	}
	

	public com.skyteam.ced.database.Employee castToEmployeeOrm(com.skyteam.ced.domain.Employee _example){
		 com.skyteam.ced.database.Employee _databaseOrm = new com.skyteam.ced.database.Employee();
		 if(_example!=null){
			 _databaseOrm.setId(_example.getId());
			 _databaseOrm.setName(_example.getName());
			 _databaseOrm.setRemark(_example.getRemark());
			 _databaseOrm.setOpDate(_example.getOpDate());
			 _databaseOrm.setAge(_example.getAge());
		 }
		 return _databaseOrm;
	}

	
	
	
	
}
