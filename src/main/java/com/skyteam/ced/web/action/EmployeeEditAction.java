package com.skyteam.ced.web.action;

import org.apache.commons.lang.StringUtils;

import com.skyteam.ced.domain.Employee;
import com.skyteam.ced.service.OrderService;
import com.skyteam.ced.web.ActionConstant;

public class EmployeeEditAction extends _BaseAction{

	private static final long serialVersionUID = 3209836041424415023L;
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private Employee item;
	
	public Employee getItem() {
		return item;
	}

	public void setItem(Employee item) {
		this.item = item;
	}
	
	public String execute(){
		if (item!=null && item.getId() != null) {
			item = orderService.findEmployeeById(item.getId());
		} else {
			item = new Employee();
		}
		return ActionConstant.SUCCESS;
	}
	
	


	public String doUpdate(){
		

		boolean isNew = StringUtils.isBlank(item.getId());
		if (isNew) {
			this.item = orderService.createEmployee(item);
		} else {
			orderService.updateEmployee(item);
		}
		String key = (isNew) ? "新增成功" : "更新成功";
		this.setMessage(key);
	
		if (!isNew) {
			return ActionConstant.SUCCESS;
		} else {
			return ActionConstant.SUCCESS;
		}

	}}
