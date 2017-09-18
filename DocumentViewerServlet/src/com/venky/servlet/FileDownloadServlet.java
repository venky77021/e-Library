package com.venky.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String file = request.getParameter("f");
		System.out.println(file);
		File f = new File(file);
		String filename = f.getName();
		String type = getMimeType("file:" + file);

		response.setContentType(type);
		response.setHeader("Content-Disposition", "attachment;     filename=\"" + filename + "\"");

		String name = f.getName().substring(f.getName().lastIndexOf("/") + 1, f.getName().length());
		InputStream in = new FileInputStream(f);
		ServletOutputStream outs = response.getOutputStream();

		int bit = 256;
		try {
			while ((bit) >= 0) {
				bit = in.read();
				outs.write(bit);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace(System.out);
		}
		outs.flush();
		outs.close();
		in.close();

	}

	
	public static String getMimeType(String fileUrl) throws java.io.IOException, MalformedURLException {
		String type = null;
		URL u = new URL(fileUrl);
		URLConnection uc = null;
		uc = u.openConnection();
		type = uc.getContentType();
		return type;
	}

}
