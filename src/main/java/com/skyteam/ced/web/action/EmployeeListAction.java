package com.skyteam.ced.web.action;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.skyteam.ced.domain.query.EmployeeQueryBean;
import com.skyteam.ced.domain.query.QueryParam;
import com.skyteam.ced.domain.query.QueryResult;
import com.skyteam.ced.service.OrderService;
import com.skyteam.ced.service.QueryFactory;

/**
 * 
 * @author liang.wang@footmarktech.com
 * @version 1.1.0
 * 
 */
public class EmployeeListAction extends _BaseAction {
	private static final long serialVersionUID = -29083760737688412L;

	private QueryResult queryResult;

	private QueryFactory queryFactory;

	private QueryParam queryParam;

	private EmployeeQueryBean queryBean;

	public QueryParam getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(QueryParam queryParam) {
		this.queryParam = queryParam;
	}

	public EmployeeQueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(EmployeeQueryBean queryBean) {
		this.queryBean = queryBean;
	}

	public QueryFactory getQueryFactory() {
		return queryFactory;
	}

	public void setQueryFactory(QueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}

	public QueryResult getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult queryResult) {
		this.queryResult = queryResult;
	}

	/**
	 * delete Entry Event
	 * 
	 * @return
	 */
	public String doDelete() {
		resetStoredQueryBean();
		try {
			String xxx = getQueryParam().getDeleteIds();
			if (StringUtils.isNotBlank(xxx)) {
				orderService.deleteEmployeeById(xxx);
				this.setMessage("删除成功");
			}
		} catch (Exception e) {

		}
		doList();

		return INPUT;
	}

	public String doPage() {
		resetStoredQueryBean();
		doList();
		return INPUT;
	}

	/**
	 * 根据保存的hiddenjson数据重新设定查询参数
	 */
	private void resetStoredQueryBean() {
		String queryBeanJson = this.getQueryParam().getQueryBeanJson();
		if (org.apache.commons.lang.StringUtils.isNotBlank(queryBeanJson)) {
			JSONObject jsonObject = JSONObject.fromObject(queryBeanJson);
			EmployeeQueryBean obj = (EmployeeQueryBean) JSONObject.toBean(
					jsonObject, EmployeeQueryBean.class);
			setQueryBean(obj);
		}
	}

	public String doSortColumn() {
		resetStoredQueryBean();
		getQueryParam().getPageBean().initializePageNo();
		doList();
		return INPUT;
	}

	public void doList() {
		getQueryParam().setQuery(true);
		setQueryResult(queryFactory.queryForResult("employeeQueryEntry",
				getQueryBean(), getQueryParam().getPageBean()));
	}

	/**
	 * 查询事件
	 * 
	 * @return
	 */
	public String doQuery() {
		getQueryParam().getPageBean().initialize();// 重置查询排序和页数
		String jsonString = JSONObject.fromObject(getQueryBean()).toString();
		getQueryParam().setQueryBeanJson(jsonString);
		doList();
		return INPUT;
	}

	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String execute() {
		getQueryParam().setQuery(false);
		return SUCCESS;
	}

	public void prepare() throws Exception {
		this.setQueryParam(new QueryParam());
		this.setQueryBean(new EmployeeQueryBean());
	}

}
