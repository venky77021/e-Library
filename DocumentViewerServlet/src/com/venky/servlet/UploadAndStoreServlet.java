package com.venky.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.venky.common.LoadProperties;

public class UploadAndStoreServlet extends HttpServlet {
	private Logger log = Logger.getLogger(UploadAndStoreServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties prop = LoadProperties.getProperties();
		String saveFile = "";
		DataInputStream in = new DataInputStream(request.getInputStream());
		int formDataLength = request.getContentLength();
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}
		String file = new String(dataBytes);
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		String resultFileName = file.substring(5).replace("+", " ");
		saveFile = prop.getProperty("dcoRepository") + "/" + resultFileName;
		log.debug("saveFile : " + saveFile);
		File f = new File(saveFile);
		FileOutputStream fileOut = new FileOutputStream(f);
		fileOut.write(dataBytes);
		fileOut.flush();
		fileOut.close();
		request.setAttribute("uploadSuccess", "File "+resultFileName+" uploaded successfully");
		RequestDispatcher rd = request.getRequestDispatcher("Upload.jsp");
		rd.forward(request, response);
	}
}
