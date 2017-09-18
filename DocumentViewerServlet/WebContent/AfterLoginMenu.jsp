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
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
</head>
<body>
	<%@ include file="LogOutHeader.jsp"%>
	<ul>
		<li><a href="/DocumentViewerServlet/viewFiles.jsp">DownloadFiles</a></li>
		<li><a href="/DocumentViewerServlet/contactAdmin.jsp">Contact Admin</a></li>
		<li><a href="/DocumentViewerServlet/aboutUs.jsp">About us</a></li>
		<li><a href="/DocumentViewerServlet/manageProfile.jsp">Manage Profile</a></li>
	</ul>
</body>
</html>