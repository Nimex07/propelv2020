package com.addbk.dao;

import com.addbk.bean.Login;

public interface ILoginDao {

	// method to insert
	public abstract int insert(Login objLogin);

	// method to search login
	public abstract Login search(String userName, String password);

}