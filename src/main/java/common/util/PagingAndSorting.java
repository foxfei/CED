package common.util;

import java.io.Serializable;

/**
 * @author wangliang_gz@hotmail.com
 * @version 1.0
 */
public class PagingAndSorting implements Serializable {

	private static final long serialVersionUID = -2330911144263397918L;

	public static final int ALL = -1; // 

	public static final int ROWS_PER_PAGE = 15;

	protected boolean recalculateFirst = false; // enabled by setPageNo or

	private String alias; // 

	private int firstResult = 0; //

	private transient int itemCount = 0; // 

	private int maxResults = ROWS_PER_PAGE; //

	private boolean orderDescending = false; //

	private String orderProperties;

	private int pageNo = 0; // 

	public static String buildOrderBy(PagingAndSorting pas) {
		if (pas != null && org.apache.commons.lang.StringUtils.isNotBlank(pas.getOrderProperties())) {
			StringBuffer orderBy = new StringBuffer(" order by ");
			String[] orderCols = pas.getOrderProperties().split("[,|;]");
			for (int i = 0; i < orderCols.length; i++) {
				if (i > 0) {
					orderBy.append(", ");
				}
				if (pas.getAlias() != null)
					orderBy.append(pas.getAlias() + ".");
				orderBy.append(orderCols[i]);
				if (pas.isOrderDescending()) {
					orderBy.append(" desc");
				}
			}
			return orderBy.toString();
		}
		return "";
	}

	public static String buildOrderBy(String query, PagingAndSorting pas) {
		if (pas != null && org.apache.commons.lang.StringUtils.isNotBlank(pas.getOrderProperties())) {
			StringBuffer orderBy = new StringBuffer();
			int j = query.toLowerCase().indexOf(" order ");
			if (j > 0) {
				int kk = query.toLowerCase().indexOf(" by ", j - 1);
				if (kk >= 0) {
					orderBy.append(query.substring(0, j));
				} else
					orderBy.append(new String(query));
			} else
				orderBy.append(new String(query));
			orderBy.append(" order by ");
			String[] orderCols = pas.getOrderProperties().split("[,|;]");
			for (int i = 0; i < orderCols.length; i++) {
				if (i > 0) {
					orderBy.append(", ");
				}
				if (pas.getAlias() != null)
					orderBy.append(pas.getAlias() + ".");
				orderBy.append(orderCols[i]);
				if (pas.isOrderDescending()) {
					orderBy.append(" desc");
				}
			}
			return orderBy.toString();
		}
		return query;

	}
	
	/**
	 * 
	 */
	public PagingAndSorting() {
	}

	/**
	 * 
	 * @param orderColumn
	 */

	public PagingAndSorting(String orderColumn) {
		setOrderProperties(orderColumn);
	}

	/**
	 * 
	 * @param orderColumn
	 * @param orderDescending
	 */
	public PagingAndSorting(String orderColumn, boolean orderDescending) {
		setOrderProperties(orderColumn);
		setOrderDescending(orderDescending);
	}

	/**
	 * 
	 * @param orderColumn
	 * @param pageNo
	 */
	public PagingAndSorting(String orderColumn, int pageNo) {
		setOrderProperties(orderColumn);
		setPageNo(pageNo);
	}

	/**
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @param orderColumn
	 * @param orderDescending
	 */
	public PagingAndSorting(int firstResult, int maxResults,String orderColumn, boolean orderDescending) {
		setFirstResult(firstResult);
		setMaxResults(maxResults);
		setOrderProperties(orderColumn);
		setOrderDescending(orderDescending);
	}

//	public void changeSortColumn(String sortColumn) {
//		if (sortColumn != null && sortColumn.equals(getOrderProperties())) {
//			// set order desc
//			setOrderDescending(isOrderDescending() == true ? false : true);
//		} else {
//			// set ascending order
//			setOrderDescending(false);
//			setOrderProperties(sortColumn);
//		}
//	}

	public String getAlias() {
		return alias;
	}

	public int getFirstResult() {
		if (this.recalculateFirst == true) {
			if (pageNo != ALL) {
				if (pageNo < 0) {
					pageNo = 0;
				}
				firstResult = pageNo * maxResults;
				if (firstResult >= itemCount) {
					firstResult = pageNo = 0;
				}
			} else {
				firstResult = 0;
			}
			this.recalculateFirst = false;
		}
		return firstResult;
	}

	public int getItemCount() {
		return itemCount;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public String getOrderProperties() {
		return orderProperties;
	}

	public int getPageNo() {
		return pageNo;
	}

	public boolean isAll() {
		return pageNo == ALL;
	}

	public boolean isOrderDescending() {
		return orderDescending;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
		this.recalculateFirst = true;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public void setOrderDescending(boolean sortOrder) {
		this.orderDescending = sortOrder;
	}

	public void setOrderProperties(String sortColumn) {
		this.orderProperties = sortColumn;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.recalculateFirst = true;
	}

}
