package com.venky.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.venky.common.LoadProperties;

public class UploadNewFileServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -163592115679095317L;
	private ServletFileUpload uploader = null;
	
	public void init()
	{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		Properties prop = LoadProperties.getProperties();
		File file = new File(prop.getProperty("dcoRepository"));
		factory.setRepository(file);
		this.uploader = new ServletFileUpload(factory);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				Properties prop = LoadProperties.getProperties();
				File file = new File(prop.getProperty("dcoRepository")+File.separator+fileItem.getName());
				fileItem.write(file);
				out.write("File "+fileItem.getName()+ " uploaded successfully.");
			}
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}
		out.write("</body></html>");
	}
}
