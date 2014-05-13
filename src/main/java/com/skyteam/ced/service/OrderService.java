
package com.skyteam.ced.service;
/**
 * 订单管理,包括工单管理,服务单管理的接口暴露
 */
import java.io.File;
import java.util.List;
import java.util.Map;

import com.skyteam.ced.domain.Employee;
/**
 * 
 * @author liang.wang@footmarktech.com
 *
 */
public interface OrderService {
	
	Employee createEmployee(Employee item);
	void updateEmployee(Employee item);
	Employee findEmployeeById(String id);
	void deleteEmployeeById(String id);
	List findAllEmployee();
}
