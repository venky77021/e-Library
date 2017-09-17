package com.venky.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import com.venky.common.ELibraryHelper;
import com.venky.common.SendeMailAPI;
import com.venky.userdb.RegistrationJDBC;

public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName = request.getParameter("uName");
		RegistrationJDBC rJDBC = new RegistrationJDBC();
		HttpSession hs = request.getSession();
		try {
			if (StringUtils.isNotBlank(uName)) {

				hs.setAttribute("forgotSessionUser", uName);
				String eMail = rJDBC.findUsereMail(uName);
				ELibraryHelper eLh = new ELibraryHelper();
				String Otp = eLh.generateOtp();
				String otpMessage = "please enter this otp :" + Otp;
				String subject = "forgot password otp";
				String resetPasswordMessage = "OTP has sent to your eMail";
				request.setAttribute("OTPMessage", resetPasswordMessage);
				rJDBC.storeOTP(uName, eMail, Otp);
				SendeMailAPI sAPI = new SendeMailAPI();
				sAPI.sendEmail(uName, eMail, subject, otpMessage);
				rd = request.getRequestDispatcher("forgotPassword.jsp");
				rd.forward(request, response);
			}
			String OTP = request.getParameter("otp");
			if (StringUtils.isNotBlank(OTP)
					&& rJDBC.verifyOTP((String) hs.getAttribute("forgotSessionUser")).equals(OTP)) {
				rd = request.getRequestDispatcher("ChangePassword.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
