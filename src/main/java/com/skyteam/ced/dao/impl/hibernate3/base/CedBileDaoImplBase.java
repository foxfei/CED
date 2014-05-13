package com.skyteam.ced.dao.impl.hibernate3.base;

/**
 * auto created by daobuilder1.1.1 
 * by huyanfei
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * @author huyanfei
 */
public class CedBileDaoImplBase extends com.skyteam.ced.dao.impl.hibernate3.base._RootDao{
	/*[CONSTRUCTOR MARKER END BY DAOBUILDER1.0]*/
	public java.lang.String save(com.skyteam.ced.database.CedBile arg0){
		return (java.lang.String)getGenericDao().save(arg0);
	}
	public void update(com.skyteam.ced.database.CedBile arg0){
		getGenericDao().update(arg0);
	}
	public void saveOrUpdate(com.skyteam.ced.database.CedBile arg0){
		getGenericDao().saveOrUpdate(arg0);
	}
	public void delete(com.skyteam.ced.database.CedBile arg0){
		getGenericDao().delete(arg0);
	}
	public void deleteAll(){
		java.lang.String deleteAllHql = "delete from " + com.skyteam.ced.database.CedBile.REF;
		getGenericDao().execute(deleteAllHql, null);
	}
	public void deleteById(java.lang.String arg0){
		getGenericDao().delete(this.getReferenceClass(),arg0);
	}
	public com.skyteam.ced.database.CedBile findById(java.lang.String arg0){
		return this.cast(getGenericDao().get(this.getReferenceClass(),arg0));
	}
	public com.skyteam.ced.database.CedBile[] findAll(common.util.PagingAndSorting ps){
		java.util.List list = findAllList(ps);
		if(list==null) return new com.skyteam.ced.database.CedBile[]{};
		return (com.skyteam.ced.database.CedBile[])list.toArray(new com.skyteam.ced.database.CedBile[list.size()]);
	}
	public com.skyteam.ced.database.CedBile[] findAll(){
			return findAll(null);
	}
	public java.util.List findAllList(common.util.PagingAndSorting ps){
		String queryString = "select a from " +com.skyteam.ced.database.CedBile.REF+" a ";
		java.util.List _list = getGenericDao().find(queryString,null,ps);
		return _list;
	}
	public java.util.List findAllList(){
		return findAllList(null);
	}
	public com.skyteam.ced.database.CedBile findFirst(java.util.Collection list){
		return (com.skyteam.ced.database.CedBile)common.util.CollectionUtils.firstResult(list,null);
	}
	
	public Class getReferenceClass(){
		return com.skyteam.ced.database.CedBile.class;
	}
	public com.skyteam.ced.database.CedBile cast(Object arg0){
		return (com.skyteam.ced.database.CedBile) arg0;
	}
	/*[CONSTRUCTOR MARKER END BY DAOBUILDER1.0]*/
}