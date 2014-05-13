package com.skyteam.ced.database.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ced_log table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ced_log"
 */

public abstract class BaseCedLog  implements Serializable {

	public static String REF = "CedLog";
	public static String PROP_BIZ_TYPE = "BizType";
	public static String PROP_OP_ID = "OpId";
	public static String PROP_BIZ_SECOND_ID = "BizSecondId";
	public static String PROP_OP_TYPE = "OpType";
	public static String PROP_BIZ_SECOND_TYPE = "BizSecondType";
	public static String PROP_ID = "Id";
	public static String PROP_OP_DETAIL = "OpDetail";
	public static String PROP_BIZ_ID = "BizId";
	public static String PROP_OP_DATE = "OpDate";


	// constructors
	public BaseCedLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCedLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bizType;
	private java.lang.String bizId;
	private java.lang.String bizSecondType;
	private java.lang.String bizSecondId;
	private java.lang.String opDetail;
	private java.lang.String opType;
	private java.lang.String opId;
	private java.util.Date opDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BIZ_TYPE
	 */
	public java.lang.String getBizType () {
		return bizType;
	}

	/**
	 * Set the value related to the column: BIZ_TYPE
	 * @param bizType the BIZ_TYPE value
	 */
	public void setBizType (java.lang.String bizType) {
		this.bizType = bizType;
	}



	/**
	 * Return the value associated with the column: BIZ_ID
	 */
	public java.lang.String getBizId () {
		return bizId;
	}

	/**
	 * Set the value related to the column: BIZ_ID
	 * @param bizId the BIZ_ID value
	 */
	public void setBizId (java.lang.String bizId) {
		this.bizId = bizId;
	}



	/**
	 * Return the value associated with the column: BIZ_SECOND_TYPE
	 */
	public java.lang.String getBizSecondType () {
		return bizSecondType;
	}

	/**
	 * Set the value related to the column: BIZ_SECOND_TYPE
	 * @param bizSecondType the BIZ_SECOND_TYPE value
	 */
	public void setBizSecondType (java.lang.String bizSecondType) {
		this.bizSecondType = bizSecondType;
	}



	/**
	 * Return the value associated with the column: BIZ_SECOND_ID
	 */
	public java.lang.String getBizSecondId () {
		return bizSecondId;
	}

	/**
	 * Set the value related to the column: BIZ_SECOND_ID
	 * @param bizSecondId the BIZ_SECOND_ID value
	 */
	public void setBizSecondId (java.lang.String bizSecondId) {
		this.bizSecondId = bizSecondId;
	}



	/**
	 * Return the value associated with the column: OP_DETAIL
	 */
	public java.lang.String getOpDetail () {
		return opDetail;
	}

	/**
	 * Set the value related to the column: OP_DETAIL
	 * @param opDetail the OP_DETAIL value
	 */
	public void setOpDetail (java.lang.String opDetail) {
		this.opDetail = opDetail;
	}



	/**
	 * Return the value associated with the column: OP_TYPE
	 */
	public java.lang.String getOpType () {
		return opType;
	}

	/**
	 * Set the value related to the column: OP_TYPE
	 * @param opType the OP_TYPE value
	 */
	public void setOpType (java.lang.String opType) {
		this.opType = opType;
	}



	/**
	 * Return the value associated with the column: OP_ID
	 */
	public java.lang.String getOpId () {
		return opId;
	}

	/**
	 * Set the value related to the column: OP_ID
	 * @param opId the OP_ID value
	 */
	public void setOpId (java.lang.String opId) {
		this.opId = opId;
	}



	/**
	 * Return the value associated with the column: OP_DATE
	 */
	public java.util.Date getOpDate () {
		return opDate;
	}

	/**
	 * Set the value related to the column: OP_DATE
	 * @param opDate the OP_DATE value
	 */
	public void setOpDate (java.util.Date opDate) {
		this.opDate = opDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.skyteam.ced.database.CedLog)) return false;
		else {
			com.skyteam.ced.database.CedLog cedLog = (com.skyteam.ced.database.CedLog) obj;
			if (null == this.getId() || null == cedLog.getId()) return false;
			else return (this.getId().equals(cedLog.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}