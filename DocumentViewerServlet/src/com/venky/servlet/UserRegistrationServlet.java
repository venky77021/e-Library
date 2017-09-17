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
import com.venky.common.SendeMailAPI;
import com.venky.userdb.RegistrationJDBC;

public class UserRegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3192397722245191645L;
	private RequestDispatcher rd = null;
	private String errorMessage = null;
	private boolean isUserExist = false;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		RegistrationJDBC regObj = new RegistrationJDBC();
		ELibraryHelper elh = new ELibraryHelper();
		String fName = request.getParameter("fName");
		session.setAttribute("firstName", fName);
		String lName = request.getParameter("lName");
		session.setAttribute("lastName", lName);
		String uName = request.getParameter("uName");
		session.setAttribute("userName", uName);
		String password = request.getParameter("password");
		session.setAttribute("password", password);
		String confirmPassword = request.getParameter("confirmPassword");
		String branch = request.getParameter("branch");
		session.setAttribute("branch", branch);
		String regulation = request.getParameter("regulation");
		session.setAttribute("regulation", regulation);
		String collegeCode = request.getParameter("collegeName");
		session.setAttribute("collegeCode", collegeCode);
		String dob = request.getParameter("dob");
		session.setAttribute("dob", dob);
		String email = request.getParameter("email");
		session.setAttribute("email", email);
		String mobileNumber = request.getParameter("mobileNumber");
		session.setAttribute("mobileNumber", mobileNumber);
		String userType = "Student";
		session.setAttribute("userType", userType);
		String gender = request.getParameter("gender");
		session.setAttribute("gender", gender);
		ELibraryHelper eLh = new ELibraryHelper();
		String otp = eLh.generateOtp();
		try {
			isUserExist = regObj.isUserExist(uName, email);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (elh.CheckEmail(email)) {
				if (!isUserExist) {
					regObj.OtpVerification(email, otp, uName);
					String subject = "Welcome to e-Library";
					String regSuccess = "otp to register e-Library" + otp;
					SendeMailAPI sendemail = new SendeMailAPI();
					sendemail.sendEmail(uName, email, subject, regSuccess);
					rd = request.getRequestDispatcher("OtpVerification.jsp");
					rd.forward(request, response);

				} else {
					errorMessage = "User Already Exists";
					request.setAttribute("UserErrorMessage", errorMessage);
					rd = request.getRequestDispatcher("UserRegistration.jsp");
					rd.forward(request, response);
				}

			} else {
				errorMessage = "Enter Correct Mail ID";
				request.setAttribute("emailNotCorrect", errorMessage);
				rd = request.getRequestDispatcher("UserRegistration.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
