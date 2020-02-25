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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reading action
		String action = request.getParameter("action");

		// passing action in switch case
		switch (action) {
		case "register":
			registerUser(request, response);
			break;

		default:
			break;
		}
	}

	private void registerUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reading data from register.jsp
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// creating object for Login bean class and initializing values
		Login login = new Login(userName, password);

		// creating object for LoginDao
		ILoginDao loginDao = new LoginDaoService();

		// calling insert method
		Integer logId = loginDao.insert(login);

		// creating session
		HttpSession session = request.getSession();

		// setting session
		session.setAttribute("logId", logId);
		session.setAttribute("name", userName);
		session.setAttribute("log", "logged");

		request.getRequestDispatcher("/JSP/AddAddress.jsp").forward(request,
				response);

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
