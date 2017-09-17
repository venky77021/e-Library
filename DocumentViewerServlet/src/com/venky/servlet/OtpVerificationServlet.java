package com.venky.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.venky.common.ELibraryHelper;
import com.venky.userdb.RegistrationJDBC;

public class OtpVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String otp = request.getParameter("otp");
		String fName = (String) session.getAttribute("firstName");
		String lName = (String) session.getAttribute("lastName");
		String uName = (String) session.getAttribute("userName");
		String password = (String) session.getAttribute("password");
		String branch = (String) session.getAttribute("branch");
		String collegeCode = (String) session.getAttribute("collegeCode");
		String dob = (String) session.getAttribute("dob");
		String email = (String) session.getAttribute("email");
		String mobileNumber = (String) session.getAttribute("mobileNumber");
		String userType = (String) session.getAttribute("userType");
		String gender = (String) session.getAttribute("gender");
		String regulation = (String) session.getAttribute("regulation");

		ELibraryHelper elh = new ELibraryHelper();
		elh.generateOtp();
		RegistrationJDBC rJDBC = new RegistrationJDBC();
		try {
			System.out.println("Email : "+email);
			if (rJDBC.checkOtp(otp, email)) {
				rJDBC.registerStudent(fName, lName, uName, password, branch, collegeCode, dob, email, mobileNumber,
						userType, gender, regulation);
				request.setAttribute("displayname", "Hello " + uName + " Thanks for Registering e-Library");

				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("ErrorMessage", "Enter Correct Otp");
				rd = request.getRequestDispatcher("OtpVerification.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
