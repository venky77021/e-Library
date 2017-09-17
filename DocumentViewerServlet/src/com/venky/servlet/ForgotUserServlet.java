package com.venky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.venky.common.SendeMailAPI;
import com.venky.userdb.RegistrationJDBC;


public class ForgotUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ueMail=request.getParameter("ueMail");
		RegistrationJDBC rJDBC=new RegistrationJDBC();
		try {
			String userName=rJDBC.findUserName(ueMail);
			String message="Your UserID is "+userName;
			String subject="forgot UserId";
			SendeMailAPI sAPI=new SendeMailAPI();
			sAPI.sendEmail(userName, ueMail, subject, message);
			out.println("<html><body style=\"background-color:lightblue\" >your UserId \""+userName+"\"</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
