<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
body {
	background-color: lightblue;
}
</style>
</head>
<body>

	<img alt="" src="Images\logo.png" />
	<div style="font-size: 50px; font-weight: bold;" align="center">
		Welcome to Venki e-Library</div>
	<br/>
	
	<div style="font-size: 20px;">
		If you are new user click here to Register <a
			href="UserRegistration.jsp" style="font-weight: bold">Register</a><br/> If
		you are a existing user click here to <a href="Login.jsp"
			style="font-weight: bold">Login</a>
	</div>
</body>
</html>