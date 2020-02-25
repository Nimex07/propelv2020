package com.addbk.bean;

public class Login {

	// instance variable
	private Integer logId;
	private String userName;
	private String password;

	/**
	 * default constructor
	 */
	public Login() {

	}

	/**
	 * @param logId
	 * @param userName
	 * @param password
	 */
	public Login(Integer logId, String userName, String password) {

		this.logId = logId;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @param userName
	 * @param password
	 */
	public Login(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

	// getters and setters
	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString
	public String toString() {
		return "Login [logId=" + logId + ", userName=" + userName
				+ ", password=" + password + "]";
	}

}
