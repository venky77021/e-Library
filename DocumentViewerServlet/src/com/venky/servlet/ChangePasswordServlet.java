package com.venky.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.venky.common.ELibraryHelper;
import com.venky.userdb.RegistrationJDBC;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ELibraryHelper elh = new ELibraryHelper();
		String password = elh.generateHash(request.getParameter("password"));
		RegistrationJDBC rJDBC = new RegistrationJDBC();
		Timestamp timeStamp = new Timestamp(new Date().getTime());
		HttpSession session = request.getSession();
		String uName = (String) session.getAttribute("forgotSessionUser");
		Integer passwordFlag = null;
		try {
			passwordFlag = rJDBC.changePassword(password, uName, timeStamp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(passwordFlag.equals(1)){
			String message="password has been changed";
			request.setAttribute("Message", message);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}
	}

}
