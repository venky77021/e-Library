<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Page</title>
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
	<form action="userRegistration" method="post">
		</br>
		<div style="font-size: 50px; font-weight: bold" align="center">User
			Registration</div>
		<div id="mainRegisterDivId" align="center">
			<fieldset class="mainFieldSetClass" style="width: 330px">
				<div id="userRegisterId">
					<div id="nameId">
						<fieldset class="inputTextBox">
							<legend>Name</legend>
							<input type="text" name="fName" placeholder="First Name" /> <input
								type="text" name="lName" placeholder="Last Name" />
						</fieldset>
					</div>
					</br>
					<div id="genderId">
						<fieldset class="inputTextBox">
							<legend>Gender</legend>
							<select name="gender" style="width:330px">
								<option selected disabled>Choose here</option>
								<option>Male</option>
								<option>Female</option>
							</select>
						</fieldset>
					</div>
					</br>
					<div id="emailId">
						<fieldset class="inputTextBox">
							<legend>Email</legend>
							<input type="text" name="email" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="uNameId">
						<fieldset class="inputTextBox">
							<legend>User Name</legend>
							<input type="text" name="uName" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="paswdId">
						<fieldset class="inputTextBox">
							<legend>Password</legend>
							<input type="password" name="password" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="branchId">
						<fieldset class="inputTextBox">
							<legend>Branch</legend>
							<input type="text" name="branch" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="collegeId">
						<fieldset class="inputTextBox">
							<legend>College Code</legend>
							<input type="text" name="collegeCode" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="dobId">
						<fieldset class="inputTextBox">
							<legend>Date Of Birth</legend>
							<input type="text" name="dob" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="mobId">
						<fieldset class="inputTextBox">
							<legend>Mobile Number</legend>
							<input type="text" name="mobileNumber" size="46" />
						</fieldset>
					</div>
					</br>
					<div id="uTypeId">
						<fieldset class="inputTextBox">
							<legend>User Type</legend>
							<select name="userType">
								<option selected disabled>Choose here</option>
								<option>Student</option>
								<option>Admin</option>
							</select>
						</fieldset>
					</div>
					</br>
					<div id="registerSubmitId" align="center">
						<input type="submit" value="Registration"
							style="font-weight: bold"> <a href="Welcome.jsp"
							style="font-weight: bold">Home</a> | <a href="Login.jsp"
							style="font-weight: bold">Login</a>
					</div>
				</div>
			</fieldset>
		</div>
	</form>
</body>
</html>