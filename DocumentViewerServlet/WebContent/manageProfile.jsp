<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.venky.userdb.RegistrationJDBC"%>
<%@ page import="java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Profile</title>
</head>
<body>
	<form action="userDetails" method="post">
		<%
			RegistrationJDBC rJDBC = new RegistrationJDBC();
			String uName = (String) session.getAttribute("uName");
			String result[] = rJDBC.getDetails(uName);
		%>
			First Name : <input name="fName" value="<%=result[0]%>"></br>
			Last Name : <input name="lName" value="<%=result[1]%>"></br>
			Email : <input name="email" value="<%=result[2]%>"></br>
			Gender: <input name="gender" value="<%=result[3]%>"></br>
			Branch : <input name="branch" value="<%=result[4]%>"></br>
			Regulation : <input name="regu" value="<%=result[8]%>"></br>
			College Name : <input name="cName" value="<%=result[5]%>"></br>
			Mobile Number : <input name="mobile" value="<%=result[6]%>"></br>
			Date Of Birth : <input name="dob" value="<%=result[7]%>"></br>
		<input type="submit" value="Update" onclick="return confirm('Are you sure you want to update the User Profile data?');">
	</form>
</body>
</html>