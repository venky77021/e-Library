<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<html>
<head>
<title>PDF Files</title>
<style type="text/css">
body {
	background-color: lightblue;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 70%;
}

th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<table align="center">
		<tr style="background-color: olive;">
			<th>File Name</th>
			<th>Download File</th>
		</tr>
		<%
			File f = new File("J:/jsp");
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				String name = files[i].getName();
				String path = files[i].getPath();
		%>

		<tr style="background-color: white;">
			<td><%=name%></td>
			<td><a href="DownloadServlet?f=<%=path%>">Download File</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>