package com.skyteam.ced.dao.impl.hibernate3.base;

import java.util.Map;
import java.util.HashMap;

/**
 * auto created by daobuilder1.1.1 
 * by wangliang
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * @author liang.wang@footmarktech.com
 */
public class EmployeeDaoImplBase extends com.skyteam.ced.dao.impl.hibernate3.base._RootDao{
	
	public java.lang.String save(com.skyteam.ced.database.Employee arg0){
		return (java.lang.String)getGenericDao().save(arg0);
	}
	public void update(com.skyteam.ced.database.Employee arg0){
		getGenericDao().update(arg0);
	}
	public void saveOrUpdate(com.skyteam.ced.database.Employee arg0){
		getGenericDao().saveOrUpdate(arg0);
	}
	public void delete(com.skyteam.ced.database.Employee arg0){
		getGenericDao().delete(arg0);
	}
	public void deleteAll(){
		java.lang.String deleteAllHql = "delete from " + com.skyteam.ced.database.Employee.REF;
		getGenericDao().execute(deleteAllHql, null);
	}
	public void deleteById(java.lang.String arg0){
		getGenericDao().delete(this.getReferenceClass(),arg0);
	}
	public Class getReferenceClass(){
		return com.skyteam.ced.database.Employee.class;
	}
	public com.skyteam.ced.database.Employee cast(Object arg0){
		return (com.skyteam.ced.database.Employee) arg0;
	}
	public com.skyteam.ced.database.Employee findById(java.lang.String arg0){
		return this.cast(getGenericDao().get(this.getReferenceClass(),arg0));
	}
	
	
	public boolean isExistData(com.skyteam.ced.database.Employee arg0){
		if(arg0 == null) return false;
		java.lang.String arg0_id = arg0.getId();
		if(arg0_id==null) return false;
		java.lang.String hql = "select a.Id from "+com.skyteam.ced.database.Employee.REF+" a where 1=1";
		Map map = new HashMap();
		hql = hql +" and a.Id =:Id";
		map.put("Id",arg0_id);

		java.util.List _list = getGenericDao().find(hql,map,null);
		if(_list==null){
			return false;
		}else{
			return _list.size()>0;
		}
		
	}	
	
	
	public com.skyteam.ced.database.Employee[] findAll(common.util.PagingAndSorting ps){
		java.util.List list = findAll1(ps);
		if(list==null) return new com.skyteam.ced.database.Employee[]{};
		return (com.skyteam.ced.database.Employee[])list.toArray(new com.skyteam.ced.database.Employee[list.size()]);
	}
	public com.skyteam.ced.database.Employee[] findAll(){
			return findAll(null);
	}
	public java.util.List findAll1(common.util.PagingAndSorting ps){
		String queryString = "select a from " +com.skyteam.ced.database.Employee.REF+" a ";
		java.util.List _list = getGenericDao().find(queryString,null,ps);
		return _list;
	}
	public java.util.List findAll1(){
		return findAll1(null);
	}
	public com.skyteam.ced.database.Employee findFirst(java.util.Collection list){
		return (com.skyteam.ced.database.Employee)common.util.CollectionUtils.firstResult(list,null);
	}
}