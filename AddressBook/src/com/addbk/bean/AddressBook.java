package com.addbk.bean;

public class AddressBook {

	// instance variable
	private Integer addId;
	private String name;
	private String houseName;
	private String locality;
	private String city;
	private String pinCode;
	private String district;
	private String state;
	private String phone;
	private Integer logId;
	private String isActive;

	/**
	 * default constructor
	 */
	public AddressBook() {

	}

	/**
	 * @param name
	 * @param houseName
	 * @param locality
	 * @param city
	 * @param pinCode
	 * @param district
	 * @param state
	 * @param phone
	 * @param logId
	 * @param isActive
	 */
	public AddressBook(String name, String houseName, String locality,
			String city, String pinCode, String district, String state,
			String phone, Integer logId) {

		this.name = name;
		this.houseName = houseName;
		this.locality = locality;
		this.city = city;
		this.pinCode = pinCode;
		this.district = district;
		this.state = state;
		this.phone = phone;
		this.logId = logId;

	}

	/**
	 * @param name
	 * @param houseName
	 * @param locality
	 * @param city
	 * @param pinCode
	 * @param district
	 * @param state
	 * @param phone
	 * @param isActive
	 */
	public AddressBook(String name, String houseName, String locality,
			String city, String pinCode, String district, String state,
			String phone) {

		this.name = name;
		this.houseName = houseName;
		this.locality = locality;
		this.city = city;
		this.pinCode = pinCode;
		this.district = district;
		this.state = state;
		this.phone = phone;

	}

	/**
	 * @param addId
	 * @param name
	 * @param houseName
	 * @param locality
	 * @param city
	 * @param pinCode
	 * @param district
	 * @param state
	 * @param phone
	 * @param isActive
	 */
	public AddressBook(Integer addId, String name, String houseName,
			String locality, String city, String pinCode, String district,
			String state, String phone, String isActive) {
		this.addId = addId;
		this.name = name;
		this.houseName = houseName;
		this.locality = locality;
		this.city = city;
		this.pinCode = pinCode;
		this.district = district;
		this.state = state;
		this.phone = phone;
		this.isActive = isActive;
	}

	// getters and setters
	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	// toString
	public String toString() {
		return "AddressBook [addId=" + addId + ", name=" + name
				+ ", houseName=" + houseName + ", locality=" + locality
				+ ", city=" + city + ", pinCode=" + pinCode + ", district="
				+ district + ", state=" + state + ", phone=" + phone
				+ ", logId=" + logId + ", isActive=" + isActive + "]";
	}

}
