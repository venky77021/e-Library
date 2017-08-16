package com.ravindra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravindra.files.PDFDocuments;

public class PDFDisplayServlet extends HttpServlet {

	private static final long serialVersionUID = -1473087451496644101L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PDFDocuments docs = new PDFDocuments();
		out.println("<html><body>");
		String[] fileArray = docs.getFileNames();
		for(String file : fileArray)
		{
			out.println("File Name : "+file+"</br>");
		}
		out.println("</body></html>");
	}
}
