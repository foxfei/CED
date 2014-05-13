package com.skyteam.ced.database.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ced_bile table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ced_bile"
 */

public abstract class BaseCedBile  implements Serializable {

	public static String REF = "CedBile";
	public static String PROP_RECORD_ID = "RecordId";
	public static String PROP_LOCATION = "Location";
	public static String PROP_ID = "Id";
	public static String PROP_PICTURE_TYPE = "PictureType";


	// constructors
	public BaseCedBile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCedBile (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String recordId;
	private java.lang.String location;
	private java.lang.String pictureType;



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
	 * Return the value associated with the column: RECORD_ID
	 */
	public java.lang.String getRecordId () {
		return recordId;
	}

	/**
	 * Set the value related to the column: RECORD_ID
	 * @param recordId the RECORD_ID value
	 */
	public void setRecordId (java.lang.String recordId) {
		this.recordId = recordId;
	}



	/**
	 * Return the value associated with the column: LOCATION
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: LOCATION
	 * @param location the LOCATION value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: PICTURE_TYPE
	 */
	public java.lang.String getPictureType () {
		return pictureType;
	}

	/**
	 * Set the value related to the column: PICTURE_TYPE
	 * @param pictureType the PICTURE_TYPE value
	 */
	public void setPictureType (java.lang.String pictureType) {
		this.pictureType = pictureType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.skyteam.ced.database.CedBile)) return false;
		else {
			com.skyteam.ced.database.CedBile cedBile = (com.skyteam.ced.database.CedBile) obj;
			if (null == this.getId() || null == cedBile.getId()) return false;
			else return (this.getId().equals(cedBile.getId()));
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