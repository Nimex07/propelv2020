package com.addbk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// opening existing session
		HttpSession session = request.getSession();
		session.removeAttribute("log");
		// removing all session attributes
		session.invalidate();

		// creating object and setting login.jsp page
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/JSP/index.jsp");

		requestDispatcher.forward(request, response);

		// method to remove values in cookie
		eraseCookie(request, response);
	}

	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
		// reading values in cookie
		Cookie[] cookies = req.getCookies();
		// check if cookie is null
		if (cookies != null)
			// removing all cookies
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
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
