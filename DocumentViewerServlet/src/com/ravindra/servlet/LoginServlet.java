package com.ravindra.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravindra.files.PDFDocuments;
import com.ravindra.userdb.RegistrationJDBC;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -1919937606170088755L;
	private static final int BUFSIZE = 4096;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");
		// request.setAttribute("fileName",
		// files.substring(files.lastIndexOf("\\")+1));
		RegistrationJDBC regObj = new RegistrationJDBC();
		boolean checkInserted = false;
		try {
			checkInserted = regObj.checkRegistration(uName, password);
			PDFDocuments obj = new PDFDocuments();
			List<String> files = Arrays.asList(obj.getFileNames());
			request.setAttribute("files", files);
			/*File file = new File("D://SubjectDocuments/");
			int length = 0;
			ServletOutputStream outStream = response.getOutputStream();
			response.setContentType("text/html");
			response.setContentLength((int) file.length());
			String fileName = (new File("D://SubjectDocuments/")).getName();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			
			byte[] byteBuffer = new byte[BUFSIZE];
			DataInputStream in = new DataInputStream(new FileInputStream(file));

			while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
				outStream.write(byteBuffer, 0, length);
			}
			in.close();
			outStream.close();*/
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (checkInserted) {
			RequestDispatcher rd = request.getRequestDispatcher("DisplayPDFFiles.jsp");
			rd.forward(request, response);
		}
	}
}
