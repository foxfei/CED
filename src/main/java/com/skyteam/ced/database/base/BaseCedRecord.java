package com.skyteam.ced.database.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ced_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ced_record"
 */

public abstract class BaseCedRecord  implements Serializable {

	public static String REF = "CedRecord";
	public static String PROP_RECORD_TYPE = "RecordType";
	public static String PROP_RECORD_NAME = "RecordName";
	public static String PROP_MODIFY_ID = "ModifyId";
	public static String PROP_ID = "Id";
	public static String PROP_CREATE_ID = "CreateId";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_PATIENT_ID = "PatientId";
	public static String PROP_MODIFY_DATE = "ModifyDate";


	// constructors
	public BaseCedRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCedRecord (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String recordName;
	private java.lang.String recordType;
	private java.lang.String patientId;
	private java.lang.String createId;
	private java.lang.String modifyId;
	private java.util.Date createDate;
	private java.util.Date modifyDate;



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
	 * Return the value associated with the column: RECORD_NAME
	 */
	public java.lang.String getRecordName () {
		return recordName;
	}

	/**
	 * Set the value related to the column: RECORD_NAME
	 * @param recordName the RECORD_NAME value
	 */
	public void setRecordName (java.lang.String recordName) {
		this.recordName = recordName;
	}



	/**
	 * Return the value associated with the column: RECORD_TYPE
	 */
	public java.lang.String getRecordType () {
		return recordType;
	}

	/**
	 * Set the value related to the column: RECORD_TYPE
	 * @param recordType the RECORD_TYPE value
	 */
	public void setRecordType (java.lang.String recordType) {
		this.recordType = recordType;
	}



	/**
	 * Return the value associated with the column: PATIENT_ID
	 */
	public java.lang.String getPatientId () {
		return patientId;
	}

	/**
	 * Set the value related to the column: PATIENT_ID
	 * @param patientId the PATIENT_ID value
	 */
	public void setPatientId (java.lang.String patientId) {
		this.patientId = patientId;
	}



	/**
	 * Return the value associated with the column: CREATE_ID
	 */
	public java.lang.String getCreateId () {
		return createId;
	}

	/**
	 * Set the value related to the column: CREATE_ID
	 * @param createId the CREATE_ID value
	 */
	public void setCreateId (java.lang.String createId) {
		this.createId = createId;
	}



	/**
	 * Return the value associated with the column: MODIFY_ID
	 */
	public java.lang.String getModifyId () {
		return modifyId;
	}

	/**
	 * Set the value related to the column: MODIFY_ID
	 * @param modifyId the MODIFY_ID value
	 */
	public void setModifyId (java.lang.String modifyId) {
		this.modifyId = modifyId;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: MODIFY_DATE
	 */
	public java.util.Date getModifyDate () {
		return modifyDate;
	}

	/**
	 * Set the value related to the column: MODIFY_DATE
	 * @param modifyDate the MODIFY_DATE value
	 */
	public void setModifyDate (java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.skyteam.ced.database.CedRecord)) return false;
		else {
			com.skyteam.ced.database.CedRecord cedRecord = (com.skyteam.ced.database.CedRecord) obj;
			if (null == this.getId() || null == cedRecord.getId()) return false;
			else return (this.getId().equals(cedRecord.getId()));
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