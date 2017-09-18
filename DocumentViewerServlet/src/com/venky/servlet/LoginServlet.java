package com.venky.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.venky.userdb.RegistrationJDBC;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4509079337286629364L;
	private Logger log = Logger.getLogger(LoginServlet.class);
	private RequestDispatcher rd = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.info("begin loginservlet doPost method");
		response.setContentType("text/html");
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");
		RegistrationJDBC regObj = new RegistrationJDBC();

		boolean isUserExist = false;
		try {
			isUserExist = regObj.loginUserExist(uName, password);

		} catch (ClassNotFoundException | SQLException e) {
			log.error("exception occured in loginservlet" + e);
		}
		if (isUserExist) {
			try {
				if (regObj.checkUserType(uName).equals("student")) {
					/*ELibraryHelper elh = new ELibraryHelper();
					List<String> files = Arrays.asList(elh.getFileNames());
					request.setAttribute("files", files);*/
					HttpSession session = request.getSession();
					session.setAttribute("uName", uName);
//					rd = request.getRequestDispatcher("viewFiles.jsp");
					rd = request.getRequestDispatcher("AfterLoginMenu.jsp");
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("AdminManage.jsp");
					rd.forward(request, response);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String errorMessage = "please enter valid credentials to login";
			request.setAttribute("loginErrorMessage", errorMessage);
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		log.info("end of the loginservlet doPost method");
	}
}
