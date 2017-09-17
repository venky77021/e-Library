<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%@ include file="LogOutHeader.jsp"%>
	<table align="center">
		<tr style="background-color: olive;">
			<th>File Name</th>
			<th>Download File</th>
		</tr>
		<c:forEach items="${files}" var="file">
			<tr style="background-color: white;">
				<td>${file}</td>
				<td><a href="DownloadServlet?f=${file}">Download File</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>