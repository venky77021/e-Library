<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
<style type="text/css">
body {
	background-color: lightblue;
}
</style>
</head>
<body>
	<form action="upload" method="post">
		<center>
			<c:if test="${not empty uploadSuccess}">
				<output style="font-weight: bold">${uploadSuccess} </output>
			</c:if>
			<table border="0" bgcolor=#ccFDDEE>
				<tr>
					<td colspan="2" align="center"><b>UPLOAD THE FILE</b></td>
				</tr>
				<tr>
					<td colspan="2" align="center"></td>
				</tr>
				<tr>
					<td><b>Choose the file To Upload:</b></td>
					<td><input name="file" TYPE="file"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Upload File"></td>
					<td align="center"><a href="AdminManage.jsp">Admin Home</a></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>