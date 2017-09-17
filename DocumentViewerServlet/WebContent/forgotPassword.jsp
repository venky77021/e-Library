<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgotPassword</title>
</head>
<body>
	<form action="forgotPassword" method="post">
		<c:if test="${empty OTPMessage}">
		Please enter user name to retrieve the password <input type="text"
				name="uName">
			<input type="submit" value="submit">
		</c:if>


		<c:if test="${not empty OTPMessage}">
			<c:out value="${OTPMessage}"/>
			<br />
			OTP:<input type="text" name="otp">
			<input type="submit" value="Verify OTP">
		</c:if>

	</form>
</body>
</html>