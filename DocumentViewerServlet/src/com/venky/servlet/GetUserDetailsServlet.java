package com.venky.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.venky.userdb.RegistrationJDBC;

public class GetUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uName = (String) session.getAttribute("uName");
		RegistrationJDBC rJDBC = new RegistrationJDBC();
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String branch = request.getParameter("branch");
		String regu = request.getParameter("regu");
		String cName = request.getParameter("cName");
		String mobile = request.getParameter("mobile");
		String dob = request.getParameter("dob");

		int result=0;
		try {
			result = rJDBC.updateUserProfile(fName, lName, email, gender, branch, regu, cName, mobile, dob, uName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==1) {
			// forward to same and display user profile updated successfully...
			// just put that in that request attribute
			RequestDispatcher rd=request.getRequestDispatcher("manageProfile.jsp");
			rd.forward(request, response);
		}
	}

}
