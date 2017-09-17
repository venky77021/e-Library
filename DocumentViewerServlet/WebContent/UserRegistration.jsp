<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Page</title>
<style type="text/css">
fieldset.inputTextBox {
	margin: 0;
	padding: 0;
	border: 0;
	font-weight: bold;
	width: 330px;
	font-weight: 30;
}

fieldset.mainFieldSetClass {
	border: 10px dotted black;
	padding: 35px;
	background: lightgreen; #
	p6 {background-color: rgba(255, 0, 255, 0.3);
	text-align: left;
}

/* background-color: gray; */
}
</style>
<meta charset="utf-8">


</head>

<script type="text/javascript">
	function inputValidations() {
		var password = document.userRegistration.password.value;
		var confirmPassword = document.userRegistration.confirmPassword.value;
		if (!(password == confirmPassword)) {
			alert("Password and Confirm Password don't match.")
			return false;
		}
	}
</script>

<body>
	<img alt="" src="Images\logo.png" />

	<form action="userRegistration" method="post"
		onsubmit="return inputValidations()">
		<input name="__RequestVerificationToken" type="hidden"
			value="UZ9ixuhH-isbtARCy7pQ5MavZIyGVXxM3ZBFB-qV-F0URY7gDYGb8rQa13j6WorkY78jC1GBweqTTzWwUpySpXbMZJ41" />
		<div class="form-horizontal text-left">
			<div class="validation-summary-errors text-danger">
				<ul>
					<li style="display: none"></li>
				</ul>
			</div>
			</br>
			<div style="font-size: 50px; font-weight: bold" align="center">User
				Registration</div>

			<div id="mainRegisterDivId" align="center">
				<fieldset class="mainFieldSetClass" style="width: 22%">
					<div id="userRegisterId">
						<div id="nameId">
							<c:if test="${not empty UserErrorMessage}">
								<output style="font-weight: bold; color: red">
									${UserErrorMessage} </output>
							</c:if>
							<fieldset class="inputTextBox">
								Name
								<output style="color: red">*</output></br>
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The FirstName field is required."
									name="fName" placeholder="First Name" required="required"
									type="text" value="" style="width: 48%" /> <input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The LastName field is required."
									name="lName" placeholder="Last Name" required="required"
									type="text" value="" style="width: 48%" />


							</fieldset>
						</div>
						</br>
						<div id="genderId">
							<fieldset class="inputTextBox">
								Gender
								<output style="color: red">*</output></br>
								<select name="gender" style="width: 100%">
									<option selected disabled>Choose here</option>
									<option>Male</option>
									<option>Female</option>
								</select>
							</fieldset>
						</div>
						
						</br>
						<div id="emailId">
							<fieldset class="inputTextBox">
								Email
								<output style="color: red">*</output></br>
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The Email field is required." name="email"
									required="required" type="text" style="width: 100%" />
							</fieldset>
						</div>
						<c:if test="${not empty emailNotCorrect }">
							<output style="font-weight: bold; color: red">
								${emailNotCorrect } </output>
						</c:if>
						</br>
						<div id="uNameId">
							<fieldset class="inputTextBox">
								User Name
								<output style="color: red">*</output></br>
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The User Name field is required."
									name="uName" required="required" type="text"
									style="width: 100%" />
							</fieldset>
						</div>
						<br>
						<div id="paswdId">
							<fieldset class="inputTextBox">
								Password(password lenght should be 8 only)
								<output style="color: red">*</output></br>
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
								Confirm Password
								<output style="color: red">*</output></br>
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The Password field is required."
									type="password" name="confirmPassword" required="required"
									style="width: 100%" />
							</fieldset>
						</div>
						<br>

						<div id="branchId">
							<fieldset class="inputTextBox">
								Branch
								<output style="color: red">*</output></br>
								<select name="branch" style="width: 100%">
									<option selected disabled>Choose here</option>
									<option>CSE</option>
									<option>ECE</option>
									<option>EEE</option>
									<option>MECH</option>
									<option>CIVIL</option>
								</select>
							</fieldset>
						</div>
						</br>
						<div id="RegulationId">
							<fieldset class="inputTextBox">
								Regulation
								<output style="color: red">*</output></br>
								<select name="regulation" style="width: 100%">
									<option selected disabled>Choose here</option>
									<option>R13</option>
									<option>R16</option>
								</select>
							</fieldset>
						</div>
						<br />
						<div id="collegeId">
							<fieldset class="inputTextBox">
								College Name
								<output style="color: red">*</output></br>
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The College Name field is required."
									type="text" name="collegeName" required="required"
									style="width: 100%" />
							</fieldset>
						</div>
						<br />
						<div id="dobId">
							<fieldset class="inputTextBox">
								<legend>Date Of Birth</legend>
								<input id="date" type="date">
								<!-- <input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The Date of Birth field is required." id="datepicker"
									type="text" name="dob" required="required" style="width: 100%" /> -->
							</fieldset>
						</div>
						<br />
						<div id="mobId">
							<fieldset class="inputTextBox">
								Mobile Number
								<input
									class="input-validation-error form-control text-box single-line"
									data-val="true"
									data-val-required="The Date of Birth field is required."
									type="text" name="mobileNumber" required="required"
									style="width: 100%" />
							</fieldset>
						</div>
						<br>
						<div id="registerSubmitId" align="center">
							<input type="submit" value="Registration"
								style="font-weight: bold"> <br> <a
								href="Welcome.jsp" style="font-weight: bold">Home</a> | <a
								href="Login.jsp" style="font-weight: bold">Login</a>
						</div>
					</div>
				</fieldset>
			</div>
	</form>
</body>
</html>