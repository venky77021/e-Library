<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title> -->
<meta charset="ISO-8859-1">
<title>Change Password</title>
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
<script type="text/javascript">
	function inputValidation() {
		var password = document.changePasswordForm.password.value;
		var confirmPassword = document.changePasswordForm.confirmPassword.value;
		if (!(password == confirmPassword)) {
			alert("password and confirm password do not match");
			return false;
		}
	}
</script>
<body>
	<form action="changePassword" method="post"
		onsubmit="return inputValidation()" name="changePasswordForm">
		<br />
		<div style="font-size: 50px; font-weight: bold" align="center">
			Change Password</div>
		<div id="changePasswordId" align="center">
			<fieldset class="changepasswordclass" style="width: 22%">
				<div id="paswdId">
					<fieldset class="inputTextBox">
						<legend>Password(password lenght should be 8 only)</legend>
						<input
							class="input-validation-error form-control text-box single-line"
							data-val="true"
							data-val-required="The Password field is required."
							type="password" name="password" required="required"
							style="width: 100%" />
					</fieldset>
				</div>
				<br>
				<div id="confirmpaswdId">
					<fieldset class="inputTextBox">
						<legend>Confirm Password</legend>
						<input
							class="input-validation-error form-control text-box single-line"
							data-val="true"
							data-val-required="The Password field is required."
							type="password" name="confirmPassword" required="required"
							style="width: 100%" />
					</fieldset>
				</div>
				<input type="submit" value="change password">
			</fieldset>
		</div>
	</form>

</body>
</html>