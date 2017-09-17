<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: lightblue;
}
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
	border: 1px solid #555;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li {
	text-align: center;
	border-bottom: 1px solid #555;
}

li:last-child {
	border-bottom: none;
}

li a.active {
	background-color: #4CAF50;
	color: white;
}

li a:hover:not (.active ) {
	background-color: #555;
	color: white;
}
</style>
</head>
<body>

	<%@ include file="LogOutHeader.jsp"%>

	<ul>
		<li><a  href="">Manage Users</a></li>
		<li><a href="viewFiles.jsp">DownloadFiles</a></li>
		<li><a href="Upload.jsp">Upload</a></li>
	</ul>

</body>
</html>
