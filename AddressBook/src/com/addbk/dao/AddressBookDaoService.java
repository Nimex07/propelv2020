package com.addbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.addbk.bean.AddressBook;
import com.addbk.helper.ConnectionFactory;

public class AddressBookDaoService implements IAddressBookDao {

	// query for inserting data into table
	private static String CREATE_ADDBOOK = "INSERT INTO addressbook (name,housename,locality,city,pincode,district,state,phone,isactive,logid) VALUES (?,?,?,?,?,?,?,?,?,?)";

	// query for view all
	private static String VIEW_ALL = "SELECT * FROM addressbook WHERE isactive='Y' ORDER BY name ASC";

	// query for search by name and phone
	private static String SEARCH_ADD = "SELECT * FROM addressbook WHERE name LIKE ? "
			+ " '%'  AND isactive='Y'";

	// query for update
	private static String UPDATE_ADD = "UPDATE addressbook SET name=?,housename=?,locality=?,city=?,pincode=?,district=?,state=?,phone=?,isactive='Y' WHERE logid=?";

	// query for delete by changing isactive value
	private static String DEACTIVATE_ADD = "UPDATE addressbook SET isactive= 'N' WHERE logid=?";

	// query for delete by changing isactive value
	private static String ACTIVATE_ADD = "UPDATE addressbook SET isactive= 'Y' WHERE logid=?";

	// query for search by logID in addressbook
	private static String SEARCH_BY_ID = "SELECT * FROM addressbook WHERE logid=?";

	// creating object for Connection
	private Connection connection = null;

	// creating object for PreparedStatement
	private PreparedStatement statement = null;

	// creating object for ResultSet
	private ResultSet resultSet = null;

	// method for insert
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#insert(com.addbk.bean.AddressBook)
	 */
	@Override
	public boolean insert(AddressBook addBook) {

		// local variable
		boolean result = false;

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing insert query
			statement = connection.prepareStatement(CREATE_ADDBOOK,
					Statement.RETURN_GENERATED_KEYS);

			// setting values
			statement.setString(1, addBook.getName());
			statement.setString(2, addBook.getHouseName());
			statement.setString(3, addBook.getLocality());
			statement.setString(4, addBook.getCity());
			statement.setString(5, addBook.getPinCode());
			statement.setString(6, addBook.getDistrict());
			statement.setString(7, addBook.getState());
			statement.setString(8, addBook.getPhone());
			statement.setString(9, "Y");
			statement.setInt(10, addBook.getLogId());

			// executing query
			if (1 == statement.executeUpdate()) {
				result = true;
			}
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				System.out.println("Generated ADD Id: " + resultSet.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// close
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return result;
	}

	// method to display all address
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#viewAll()
	 */
	@Override
	public List<AddressBook> viewAll() {

		// creating List
		List<AddressBook> addList = new ArrayList<AddressBook>();

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing viewall query
			statement = connection.prepareStatement(VIEW_ALL);

			// executing query
			resultSet = statement.executeQuery();

			// reading data from resultSet
			while (resultSet.next()) {

				// reading each row
				String name = resultSet.getString("name");
				String houseName = resultSet.getString("housename");
				String locality = resultSet.getString("locality");
				String city = resultSet.getString("city");
				String pinCode = resultSet.getString("pinCode");
				String district = resultSet.getString("district");
				String state = resultSet.getString("state");
				String phone = resultSet.getString("phone");

				// adding data into ArrayList
				addList.add(new AddressBook(name, houseName, locality, city,
						pinCode, district, state, phone));

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				// close
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return addList;
	}

	// method to search by name and phone
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#searchAdd(java.lang.String)
	 */
	@Override
	public List<AddressBook> searchAdd(String name) {

		// creating List
		List<AddressBook> addList = new ArrayList<AddressBook>();

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing search query
			statement = connection.prepareStatement(SEARCH_ADD);
			statement.setString(1, name);

			// executing query
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				// reading each row

				String persName = resultSet.getString("name");
				String houseName = resultSet.getString("housename");
				String locality = resultSet.getString("locality");
				String city = resultSet.getString("city");
				String pinCode = resultSet.getString("pinCode");
				String district = resultSet.getString("district");
				String state = resultSet.getString("state");
				String addPhone = resultSet.getString("phone");

				// initializing AddressBook object
				addList.add(new AddressBook(persName, houseName, locality,
						city, pinCode, district, state, addPhone));

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				// close
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return addList;

	}

	// method to update address
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#update(com.addbk.bean.AddressBook)
	 */
	@Override
	public boolean update(AddressBook addBook) {

		// local variable
		boolean result = false;

		try {
			// connection
			connection = ConnectionFactory.getConnection();

			// passing update query
			statement = connection.prepareStatement(UPDATE_ADD);

			// setting values
			statement.setString(1, addBook.getName());
			statement.setString(2, addBook.getHouseName());
			statement.setString(3, addBook.getLocality());
			statement.setString(4, addBook.getCity());
			statement.setString(5, addBook.getPinCode());
			statement.setString(6, addBook.getDistrict());
			statement.setString(7, addBook.getState());
			statement.setString(8, addBook.getPhone());
			statement.setInt(9, addBook.getLogId());

			// execute query
			if (1 == statement.executeUpdate()) {
				result = true;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				// close
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return result;
	}

	// method to delete addressbook
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#deActivate(int)
	 */
	@Override
	public boolean deActivate(int logId) {

		// local variable
		boolean result = false;

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing delete query
			statement = connection.prepareStatement(DEACTIVATE_ADD);
			statement.setInt(1, logId);

			if (1 == statement.executeUpdate())
				result = true;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// close
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return result;
	}

	// method to delete addressbook
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#activate(int)
	 */
	@Override
	public boolean activate(int logId) {

		// local variable
		boolean result = false;

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing delete query
			statement = connection.prepareStatement(ACTIVATE_ADD);
			statement.setInt(1, logId);

			if (1 == statement.executeUpdate())
				result = true;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// close
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.addbk.dao.IAddressBookDao#searchByLogID(int)
	 */
	@Override
	public AddressBook searchByLogID(int logId) {

		// creating object for AddressBook
		AddressBook objAdd = null;

		try {

			// connection
			connection = ConnectionFactory.getConnection();

			// passing query
			statement = connection.prepareStatement(SEARCH_BY_ID);
			statement.setInt(1, logId);

			// executing query
			resultSet = statement.executeQuery();

			// reading resultSet
			if (resultSet.next()) {

				// reading row
				int addId = resultSet.getInt("addid");
				String persName = resultSet.getString("name");
				String houseName = resultSet.getString("housename");
				String locality = resultSet.getString("locality");
				String city = resultSet.getString("city");
				String pinCode = resultSet.getString("pinCode");
				String district = resultSet.getString("district");
				String state = resultSet.getString("state");
				String addPhone = resultSet.getString("phone");
				String isActive = resultSet.getString("isactive");
				// initializing object of AddressBook
				objAdd = new AddressBook(addId, persName, houseName, locality,
						city, pinCode, district, state, addPhone, isActive);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// close
				resultSet.close();
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		return objAdd;
	}

}
