<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTP Verification</title> -->
<meta charset="ISO-8859-1">
<title>OTP Verification</title>
<style type="text/css">
body {
	background-color: lightblue;
}

fieldset.inputTextBox {
	margin: 0;
	padding: 0;
	border: 0;
	font-weight: bold;
	width: 330px;
	font-weight: 30;
}

fieldset.mainFieldSetClass {
	background-color: gray;
	text-align: left;
}
</style>
</head>
<body>
	<img alt="" src="Images\logo.png" />

	<form action="otpVerification" method="post">
		<c:if test="${not empty ErrorMessage}">
			<output style="font-weight: bold; color: red">
			${ErrorMessage} </output>
		</c:if>
		<div align="center">
			<h1>VERIFICATION</h1>
			<fieldset class="mainFieldSetClass" style="width: 330px">
				<div id="verificationId">
					<fieldset class="inputTextBox">
						Enter OTP Send To Your Mail:<input type="text" name="otp"
							placeholder="#####" size="6" />
					</fieldset>
					<br /> <br />
				</div>
			</fieldset>
		</div>
		<div align="center">
			<input type="submit" value="submit" style="font-weight: bold" />
		</div>
	</form>
</body>
</html>