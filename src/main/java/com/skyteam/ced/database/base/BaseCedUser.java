package com.skyteam.ced.database.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ced_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ced_user"
 */

public abstract class BaseCedUser  implements Serializable {

	public static String REF = "CedUser";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_MAJOR = "Major";
	public static String PROP_AGE = "Age";
	public static String PROP_WORK_PHONE = "WorkPhone";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_MODIFY_DATE = "ModifyDate";
	public static String PROP_TITLE = "Title";
	public static String PROP_HOME_PHONE = "HomePhone";
	public static String PROP_CARD_NO = "CardNo";
	public static String PROP_NAME = "Name";
	public static String PROP_BIRTHPLACE = "Birthplace";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_BIRTHDAY = "Birthday";
	public static String PROP_POLITICAL = "Political";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_EMAIL = "Email";
	public static String PROP_USERNAME = "Username";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_CARD_TYPE = "CardType";
	public static String PROP_MOBILE_PHONE = "MobilePhone";


	// constructors
	public BaseCedUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCedUser (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.String name;
	private java.lang.String age;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String address;
	private java.lang.String homePhone;
	private java.lang.String workPhone;
	private java.lang.String mobilePhone;
	private java.lang.String email;
	private java.lang.String birthplace;
	private java.util.Date birthday;
	private java.lang.String political;
	private java.lang.String major;
	private java.lang.String education;
	private java.lang.String title;
	private java.lang.String cardType;
	private java.lang.String cardNo;
	private java.lang.String userType;
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
	 * Return the value associated with the column: USERNAME
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: USERNAME
	 * @param username the USERNAME value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}



	/**
	 * Return the value associated with the column: PASSWORD
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: HEIGHT
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: HEIGHT
	 * @param height the HEIGHT value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: WEIGHT
	 * @param weight the WEIGHT value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: HOME_PHONE
	 */
	public java.lang.String getHomePhone () {
		return homePhone;
	}

	/**
	 * Set the value related to the column: HOME_PHONE
	 * @param homePhone the HOME_PHONE value
	 */
	public void setHomePhone (java.lang.String homePhone) {
		this.homePhone = homePhone;
	}



	/**
	 * Return the value associated with the column: WORK_PHONE
	 */
	public java.lang.String getWorkPhone () {
		return workPhone;
	}

	/**
	 * Set the value related to the column: WORK_PHONE
	 * @param workPhone the WORK_PHONE value
	 */
	public void setWorkPhone (java.lang.String workPhone) {
		this.workPhone = workPhone;
	}



	/**
	 * Return the value associated with the column: MOBILE_PHONE
	 */
	public java.lang.String getMobilePhone () {
		return mobilePhone;
	}

	/**
	 * Set the value related to the column: MOBILE_PHONE
	 * @param mobilePhone the MOBILE_PHONE value
	 */
	public void setMobilePhone (java.lang.String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: BIRTHPLACE
	 */
	public java.lang.String getBirthplace () {
		return birthplace;
	}

	/**
	 * Set the value related to the column: BIRTHPLACE
	 * @param birthplace the BIRTHPLACE value
	 */
	public void setBirthplace (java.lang.String birthplace) {
		this.birthplace = birthplace;
	}



	/**
	 * Return the value associated with the column: BIRTHDAY
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: BIRTHDAY
	 * @param birthday the BIRTHDAY value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
	}



	/**
	 * Return the value associated with the column: POLITICAL
	 */
	public java.lang.String getPolitical () {
		return political;
	}

	/**
	 * Set the value related to the column: POLITICAL
	 * @param political the POLITICAL value
	 */
	public void setPolitical (java.lang.String political) {
		this.political = political;
	}



	/**
	 * Return the value associated with the column: MAJOR
	 */
	public java.lang.String getMajor () {
		return major;
	}

	/**
	 * Set the value related to the column: MAJOR
	 * @param major the MAJOR value
	 */
	public void setMajor (java.lang.String major) {
		this.major = major;
	}



	/**
	 * Return the value associated with the column: EDUCATION
	 */
	public java.lang.String getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: EDUCATION
	 * @param education the EDUCATION value
	 */
	public void setEducation (java.lang.String education) {
		this.education = education;
	}



	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: CARD_TYPE
	 */
	public java.lang.String getCardType () {
		return cardType;
	}

	/**
	 * Set the value related to the column: CARD_TYPE
	 * @param cardType the CARD_TYPE value
	 */
	public void setCardType (java.lang.String cardType) {
		this.cardType = cardType;
	}



	/**
	 * Return the value associated with the column: CARD_NO
	 */
	public java.lang.String getCardNo () {
		return cardNo;
	}

	/**
	 * Set the value related to the column: CARD_NO
	 * @param cardNo the CARD_NO value
	 */
	public void setCardNo (java.lang.String cardNo) {
		this.cardNo = cardNo;
	}



	/**
	 * Return the value associated with the column: USER_TYPE
	 */
	public java.lang.String getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: USER_TYPE
	 * @param userType the USER_TYPE value
	 */
	public void setUserType (java.lang.String userType) {
		this.userType = userType;
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
		if (!(obj instanceof com.skyteam.ced.database.CedUser)) return false;
		else {
			com.skyteam.ced.database.CedUser cedUser = (com.skyteam.ced.database.CedUser) obj;
			if (null == this.getId() || null == cedUser.getId()) return false;
			else return (this.getId().equals(cedUser.getId()));
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