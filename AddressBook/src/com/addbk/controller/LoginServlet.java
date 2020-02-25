package com.addbk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addbk.bean.Login;
import com.addbk.dao.ILoginDao;
import com.addbk.dao.LoginDaoService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reading action
		String action = request.getParameter("action");

		// passing action into switch case
		switch (action) {
		case "login":
			logInAddress(request, response);
			break;

		default:
			break;
		}
	}

	private void logInAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reading username and password
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// creating object for LoginDao
		ILoginDao loginDao = new LoginDaoService();

		// creating object for Login and calling search method
		Login login = loginDao.search(userName, password);

		System.out.println("Login: " + login);

		if (login == null) {
			// no record found
			request.setAttribute("errMessage",
					"Invalid Username and Password. Click on Register");
			request.getRequestDispatcher("/JSP/index.jsp").forward(request,
					response);
		} else {

			// creating session
			HttpSession session = request.getSession();

			// setting session
			session.setAttribute("logId", login.getLogId());
			session.setAttribute("name", userName);
			session.setAttribute("log", "logged");

			// redirecting
			response.sendRedirect("AddressBookServlet?action=edit");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
