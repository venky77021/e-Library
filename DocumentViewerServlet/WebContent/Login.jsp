<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
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

	<form action="login" method="post">
		<div style="font-size: 50px; font-weight: bold;" align="center">User
			Login</div>
		<c:if test="${not empty Message}">
			<output style="font-weight: bold; color: purple"> ${Message}
			</output>
		</c:if>
		<c:if test="${not empty displayname}">
			<output style="font-weight: bold">${displayname} </output>
		</c:if>
		<br/>
		<div id="mainLoginDivId" align="center">
			<fieldset class="mainFieldSetClass" style="width: 330px">
				<div id="genderId">
					<fieldset class="inputTextBox">
						<legend>User Name</legend>
						<input type="text" name="uName" size="30" />
					</fieldset>
				</div>
				<br/>
				<div id="userLoginPswdId">
					<fieldset class="inputTextBox">
						<legend>Password</legend>
						<input type="password" name="password" size="30" />
					</fieldset>
				</div>
				<c:if test="${not empty loginErrorMessage}">
					<output style="font-weight: bold; color: purple">
						${loginErrorMessage} </output>
				</c:if>

				<div id="loginButtonsId" align="center">
					<input type="submit" value="Login" style="font-weight: bold" /> <br />
					<a href="UserRegistration.jsp" style="font-weight: bold">Registration</a>
					| <a href="Welcome.jsp" style="font-weight: bold">Home</a> <br />
					<a href="forgotUser.jsp" style="font-weight: bold">Forgot
						UserName</a>| <a href="forgotPassword.jsp" style="font-weight: bold">Forgot
						Password</a>
				</div>
			</fieldset>
		</div>
	</form>
</body>
</html>