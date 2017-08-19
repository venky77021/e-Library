package com.ravindra.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravindra.userdb.RegistrationJDBC;

public class UserRegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3192397722245191645L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		RegistrationJDBC regObj = new RegistrationJDBC();
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");
		String branch = request.getParameter("branch");
		String collegeCode = request.getParameter("collegeCode");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		String userType = request.getParameter("userType");
		String gender = request.getParameter("gender");
		try {
			regObj.registerStudent(fName, lName, uName, password, branch, collegeCode, dob, email, mobileNumber,
					userType, gender);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		boolean checkInserted = false;
		try {
			checkInserted = regObj.isUserExist(uName, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (checkInserted) {
			RequestDispatcher rd = request.getRequestDispatcher("regsuccess");
			rd.forward(request, response);
		}
	}
}
