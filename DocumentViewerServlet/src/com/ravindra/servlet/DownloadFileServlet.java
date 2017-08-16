package com.ravindra.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravindra.files.PDFDocuments;

public class DownloadFileServlet extends HttpServlet {

	private static final long serialVersionUID = -4425085731312226407L;
	private static final int BUFSIZE = 4096;
	String filePath;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PDFDocuments obj = new PDFDocuments();
		List<String> files = Arrays.asList(obj.getFileNames());
//		for (String fileName : files) {
//			filePath = "D://SubjectDocuments" + File.separator + fileName.substring(fileName.lastIndexOf("\\")+1);
//		}
		File file = new File(filePath);
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		response.setContentType("text/html");
		response.setContentLength((int) file.length());
		String fileName = (new File(filePath)).getName();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		byte[] byteBuffer = new byte[BUFSIZE];
		DataInputStream in = new DataInputStream(new FileInputStream(file));

		while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
			outStream.write(byteBuffer, 0, length);
		}
		RequestDispatcher rd = request.getRequestDispatcher("downloadfile.jsp");
		rd.forward(request, response);
		in.close();
		outStream.close();
	}
}
