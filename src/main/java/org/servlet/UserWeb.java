package org.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.dao.UserDAO;
import org.daoImpl.UserDaoImpl;
import org.model.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/UserWeb")
public class UserWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userdao = new UserDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");

		User user = new User(userName, password, name, email, city);
		boolean success = userdao.saveUser(user);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (success) {
			out.println("<h3>User registered successfully!</h3>");
		} else {
			out.println("<h3>Registration failed!</h3>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		boolean isAuthenticated = userdao.loginUser(userName, password);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (isAuthenticated) {
			out.println("<h2>Welcome, " + userName + "!</h2>");
		} else {
			out.println("<h2>Login failed. Invalid username or password.</h2>");
			out.println("<a href='login.html'>Try Again</a>");
		}
	}
}
