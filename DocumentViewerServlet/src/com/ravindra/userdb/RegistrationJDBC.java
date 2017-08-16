package com.ravindra.userdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ravindra.common.ELibraryHelper;
import com.ravindra.common.GetConnectionDetails;

public class RegistrationJDBC {
	private Connection con = null;
	private GetConnectionDetails dbConObj = null;
	private PreparedStatement ps = null;
	private ELibraryHelper helper = null;
	
	public void registerStudent(String fName, String lName, String uName, String password, String branch,
			String collegeCode, String dob, String email, String mobileNumber, String userType, String gender)
			throws ClassNotFoundException, IOException, SQLException {
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		String insertQuery = "INSERT INTO public.\"USER_REGISTRATION\"(\"FIRST_NAME\", \"LAST_NAME\", \"USER_NAME\", "
				+ "\"EMAIL\", \"GENDER\", \"BRANCH\", \"COLLEGE_CODE\", \"MOBILE_NUMBER\", \"USER_TYPE\", \"PASSWORD\", \"DOB\")	"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		helper = new ELibraryHelper();
		
		ps = con.prepareStatement(insertQuery);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setString(3, uName);
		ps.setString(4, email);
		ps.setString(5, gender);
		ps.setString(6, branch);
		ps.setString(7, collegeCode);
		ps.setString(8, mobileNumber);
		ps.setString(9, userType);
		ps.setString(10, helper.generateHash(password));
		ps.setString(11, dob);
		ps.executeQuery();
	}

	public boolean checkRegistration(String uName, String password) throws ClassNotFoundException, IOException, SQLException
	{
		String selectQuery = "SELECT * from public.\"USER_REGISTRATION\" where \"USER_NAME\"=? and \"PASSWORD\"=?";
		dbConObj = new GetConnectionDetails();
		helper = new ELibraryHelper();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, uName);
		ps.setString(2, helper.generateHash(password));
		ResultSet rs = ps.executeQuery();
		boolean queryStatus = false;
		while(rs.next())
		{
			queryStatus = true;
		}
		return queryStatus;
	}
}
