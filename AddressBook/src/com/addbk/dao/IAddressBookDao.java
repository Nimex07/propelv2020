package com.addbk.dao;

import java.util.List;

import com.addbk.bean.AddressBook;

public interface IAddressBookDao {

	// method for insert
	public abstract boolean insert(AddressBook addBook);

	// method to display all address
	public abstract List<AddressBook> viewAll();

	// method to search by name and phone
	public abstract List<AddressBook> searchAdd(String name);

	// method to update address
	public abstract boolean update(AddressBook addBook);

	// method to delete addressbook
	public abstract boolean deActivate(int logId);

	// method to delete addressbook
	public abstract boolean activate(int logId);

	public abstract AddressBook searchByLogID(int logId);

}