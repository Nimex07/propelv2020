package com.addbk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addbk.bean.AddressBook;
import com.addbk.dao.AddressBookDaoService;
import com.addbk.dao.IAddressBookDao;

/**
 * Servlet implementation class AddressBookServlet
 */
@WebServlet("/AddressBookServlet")
public class AddressBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * Made Changes to see in GIT
		 */
		
		
		// reading action
		String action = request.getParameter("action");

		switch (action) {
		case "insert":
			addAddress(request, response);
			break;
		case "list":
			viewAddress(request, response);
			break;
		case "update":
			updateAddress(request, response);
			break;
		case "search":
			searchAddress(request, response);
			break;
		case "activate":
			activateAddress(request, response);
			break;
		case "deactivate":
			deActivateAddress(request, response);
			break;
		default:
			editAddress(request, response);
			break;
		}
	}

	private void updateAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// reading values from jsp
		String name = request.getParameter("name").toLowerCase();
		String houseName = request.getParameter("houseName").toLowerCase();
		String locality = request.getParameter("locality").toLowerCase();
		String city = request.getParameter("city").toLowerCase();
		String pinCode = request.getParameter("pinCode");
		String district = request.getParameter("district").toLowerCase();
		String state = request.getParameter("state").toLowerCase();
		String phone = request.getParameter("phone");
		// Integer logId = Integer.parseInt(request.getParameter("logId"));

		// opening session and getting logid
		HttpSession session = request.getSession(false);
		Integer logId = (Integer) session.getAttribute("logId");

		// creating object for AddressBook
		AddressBook addressBook = new AddressBook(name, houseName, locality,
				city, pinCode, district, state, phone, logId);

		// creating object for AddressBookDao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling update method
		addressBookDao.update(addressBook);

		// redirecting
		response.sendRedirect("AddressBookServlet?action=edit");
	}

	private void deActivateAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// opening session and getting logid
		HttpSession session = request.getSession(false);
		Integer logId = (Integer) session.getAttribute("logId");

		// creating object for AddressBookDao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling method to deactivate
		addressBookDao.deActivate(logId);

		// redirecting
		response.sendRedirect("AddressBookServlet?action=edit");

	}

	private void activateAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// opening session and getting logid
		HttpSession session = request.getSession(false);
		Integer logId = (Integer) session.getAttribute("logId");

		// creating object for AddressBookDao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling method to deactivate
		addressBookDao.activate(logId);

		// redirecting
		response.sendRedirect("AddressBookServlet?action=edit");
	}

	private void searchAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// getting name to search
		String scrhName = request.getParameter("searchName");

		// creating object for AddressBookDao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling method to search
		List<AddressBook> listAddressBook = addressBookDao.searchAdd(scrhName);

		if (listAddressBook.isEmpty()) {
			// no record found
			request.setAttribute("errMessage", "No Record Found");
		} else {
			// setting records
			request.setAttribute("listAddressBook", listAddressBook);
		}

		// calling page
		request.getRequestDispatcher("/JSP/ViewAddress.jsp").forward(request,
				response);
	}

	private void viewAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// creating object for AddressBookDao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling method to view all address
		List<AddressBook> listAddressBook = addressBookDao.viewAll();

		if (listAddressBook.isEmpty()) {
			// no record found
			request.setAttribute("errMessage", "No Record Found");
		} else {
			// setting records
			request.setAttribute("listAddressBook", listAddressBook);
		}

		// calling page
		request.getRequestDispatcher("/JSP/ViewAddress.jsp").forward(request,
				response);
	}

	private void editAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// opening session and getting logid
		HttpSession session = request.getSession(false);
		Integer logId = (Integer) session.getAttribute("logId");

		// creating object for addressbookdao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// searching address
		AddressBook addressBook = addressBookDao.searchByLogID(logId);

		System.out.println(addressBook);
		if (addressBook != null) {
			// setting value into request
			request.setAttribute("address", addressBook);

		}
		// calling page
		request.getRequestDispatcher("JSP/AddAddress.jsp").forward(request,
				response);
	}

	private void addAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reading values from jsp
		String name = request.getParameter("name").toLowerCase();
		String houseName = request.getParameter("houseName").toLowerCase();
		String locality = request.getParameter("locality").toLowerCase();
		String city = request.getParameter("city").toLowerCase();
		String pinCode = request.getParameter("pinCode");
		String district = request.getParameter("district").toLowerCase();
		String state = request.getParameter("state").toLowerCase();
		String phone = request.getParameter("phone");
		// Integer logId = Integer.parseInt(request.getParameter("logId"));

		// opening session and getting logid
		HttpSession session = request.getSession(false);
		Integer logId = (Integer) session.getAttribute("logId");

		// creating object for AddressBook
		AddressBook addressBook = new AddressBook(name, houseName, locality,
				city, pinCode, district, state, phone, logId);

		// creating object for Addressbookdao
		IAddressBookDao addressBookDao = new AddressBookDaoService();

		// calling insert method
		addressBookDao.insert(addressBook);

		// redirecting
		response.sendRedirect("AddressBookServlet?action=edit");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
