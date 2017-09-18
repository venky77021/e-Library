package com.venky.userdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.venky.common.ELibraryHelper;
import com.venky.common.GetConnectionDetails;

public class RegistrationJDBC {
	private Connection con = null;
	private GetConnectionDetails dbConObj = null;
	private PreparedStatement ps = null;
	private ELibraryHelper helper = null;

	/**
	 * This method is used to insert the user data into the database after
	 * verifying the otp
	 * 
	 * @param fName
	 * @param lName
	 * @param uName
	 * @param password
	 * @param branch
	 * @param collegeCode
	 * @param dob
	 * @param email
	 * @param mobileNumber
	 * @param userType
	 * @param gender
	 * @param Regulation
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void registerStudent(String fName, String lName, String uName, String password, String branch,
			String collegeCode, String dob, String email, String mobileNumber, String userType, String gender,
			String Regulation) throws ClassNotFoundException, IOException, SQLException {
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		String insertQuery = "INSERT INTO public.\"USER_REGISTRATION\"(\"FIRST_NAME\", \"LAST_NAME\", \"USER_NAME\", "
				+ "\"EMAIL\", \"GENDER\", \"BRANCH\", \"COLLEGE_CODE\", \"MOBILE_NUMBER\", \"USER_TYPE\", \"PASSWORD\", \"DOB\", \"CREATED_DATE_TIME\" ,\"REGULATION\")	"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		helper = new ELibraryHelper();
		Timestamp ts = new Timestamp(new Date().getTime());
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
		ps.setTimestamp(12, ts);
		ps.setString(13, Regulation);
		ps.execute();
	}

	/**
	 * This method is used to check whether user exist or not
	 * 
	 * @param uName
	 * @param email
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public boolean isUserExist(String uName, String email) throws ClassNotFoundException, IOException, SQLException {
		String selectQuery = "SELECT * from public.\"OTP_TB\" where \"USER_NAME\"=? and \"EMAIL\"=?";
		dbConObj = new GetConnectionDetails();
		helper = new ELibraryHelper();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, uName);
		ps.setString(2, email);
		ResultSet rs = ps.executeQuery();
		boolean queryStatus = false;
		while (rs.next()) {
			queryStatus = true;
		}
		return queryStatus;
	}

	/**
	 * This method is used to forgot the password
	 * 
	 * @param uName
	 * @param email
	 * @param otp
	 * @throws SQLException
	 */
	public void storeOTP(String uName, String email, String otp) throws SQLException {
		String selectQuery = "select * from public.\"OTP_TB\" where \"USER_NAME\"='" + uName + "'";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		boolean selectFlag = false;
		while (rs.next()) {
			selectFlag = true;
		}
		if (!selectFlag) {
			String insertQuery = "INSERT INTO public.\"OTP_TB\"(\"EMAIL\", \"OTP_NUM\", \"USER_NAME\") values (?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, email);
			ps.setString(2, otp);
			ps.setString(3, uName);
			ps.execute();
		} else {
			String updateQuery = "update public.\"OTP_TB\" set \"OTP_NUM\"='" + otp + "' where \"USER_NAME\"='" + uName
					+ "'";
			java.sql.Statement stmt1 = con.createStatement();
			stmt1.executeUpdate(updateQuery);
		}

	}

	/**
	 * This method is used to find the user
	 * 
	 * @param ueMail
	 * @return
	 * @throws SQLException
	 */
	public String findUserName(String ueMail) throws SQLException {
		String selectQuery = "select \"USER_NAME\" from public.\"USER_REGISTRATION\" where \"EMAIL\"='" + ueMail + "'";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		java.sql.Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(selectQuery);
		String uName = "";
		if (rs.next()) {
			uName = rs.getString(1);
		} else {
			uName = "No User Found";
		}
		return uName;
	}

	/**
	 * This method is used in forgotpasswordservlet to find the user email
	 * 
	 * @param uName
	 * @return
	 * @throws SQLException
	 */
	public String findUsereMail(String uName) throws SQLException {
		String selectQuery = "select \"EMAIL\" from public.\"USER_REGISTRATION\" where \"USER_NAME\"='" + uName + "'";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		java.sql.Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(selectQuery);
		String ueMail = "";
		if (rs.next()) {
			ueMail = rs.getString(1);
		} else {
			ueMail = "No eMail Found";
		}
		return ueMail;
	}

	/**
	 * This method is used to verify the otp
	 * 
	 * @param uName
	 * @return
	 * @throws SQLException
	 */
	public String verifyOTP(String uName) throws SQLException {
		String selectQuery = "select \"OTP_NUM\" from public.\"OTP_TB\" where \"USER_NAME\"='" + uName + "'";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		java.sql.Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(selectQuery);
		String Otp = "";
		if (rs.next()) {
			Otp = rs.getString(1);
		} else {
			Otp = "No OTP Found";
		}
		return Otp;

	}

	/**
	 * This method is used to update the password
	 * 
	 * @param passWord
	 * @param uName
	 * @param timestamp
	 * @return
	 * @throws SQLException
	 */
	public Integer changePassword(String passWord, String uName, Timestamp timestamp) throws SQLException {
		String updateQuery = "update public.\"USER_REGISTRATION\" set \"PASSWORD\"='" + passWord
				+ "' , \"UPDATED_DATE_TIME\"='" + timestamp + "' where  \"USER_NAME\"='" + uName + "'";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		Statement stmt = con.createStatement();
		Integer resultFlag = stmt.executeUpdate(updateQuery);
		return resultFlag;

	}

	/**
	 * This method is used to check whether user exist in the data base or not
	 * to login
	 * 
	 * @param uName
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public boolean loginUserExist(String uName, String password)
			throws ClassNotFoundException, IOException, SQLException {
		String selectQuery = "SELECT * from public.\"USER_REGISTRATION\" where \"USER_NAME\"=? and \"PASSWORD\"=?";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		helper = new ELibraryHelper();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, uName);
		String result = helper.generateHash(password);
		ps.setString(2, result);
		ResultSet rs = ps.executeQuery();
		boolean queryStatus = false;
		while (rs.next()) {
			queryStatus = true;
		}
		return queryStatus;
	}

	/**
	 * This method is used to enter the data into the OTP_TB table
	 * 
	 * @param email
	 * @param otp
	 * @param uName
	 * @throws SQLException
	 */
	public void OtpVerification(String email, String otp, String uName) throws SQLException {
		String insertQuery = "INSERT into public.\"OTP_TB\"(\"EMAIL\",\"OTP_NUM\",\"USER_NAME\") values(?,?,?)";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(insertQuery);
		ps.setString(1, email);
		ps.setString(2, otp);
		ps.setString(3, uName);
		ps.execute();
	}

	/**
	 * This method is used to check the otp
	 * 
	 * @param otp
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean checkOtp(String otp, String email) throws SQLException {
		String selectQuery = "SELECT \"OTP_NUM\" from public.\"OTP_TB\" where \"EMAIL\"=?";
		boolean queryStatus = false;
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Otp matched....1 " + rs.getString("OTP_NUM"));
			if (rs.getString("OTP_NUM").equals(otp)) {
				queryStatus = true;
			} else {
				queryStatus = false;
			}
		}
		return queryStatus;

	}

	/**
	 * This method is used to check the user type
	 * 
	 * @param uName
	 * @return
	 * @throws SQLException
	 */
	public String checkUserType(String uName) throws SQLException {
		String result = "";
		String selectQuery = "select \"USER_TYPE\" from public.\"USER_REGISTRATION\" where \"USER_NAME\"=?";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, uName);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			result = rs.getString("USER_TYPE");
		}
		return result;
	}

	public String[] getDetails(String uName) throws SQLException {
		String result[] = new String[9];
		String selectQuery = "select * from public.\"USER_REGISTRATION\" where \"USER_NAME\"=?";
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(selectQuery);
		ps.setString(1, uName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			result[0] = rs.getString("FIRST_NAME");
			result[1] = rs.getString("LAST_NAME");
			result[2] = rs.getString("EMAIL");
			result[3] = rs.getString("GENDER");
			result[4] = rs.getString("BRANCH");
			result[5] = rs.getString("COLLEGE_CODE");
			result[6] = rs.getString("MOBILE_NUMBER");
			result[7] = rs.getString("DOB");
			result[8] = rs.getString("REGULATION");
		}
		return result;

	}

	public int updateUserProfile(String fName, String lName, String email, String gender, String branch,
			String regu, String cName, String mobile, String dob, String uName) throws SQLException {
		// TODO Auto-generated method stub
		String updateQuery = "update public.\"USER_REGISTRATION\" SET \"FIRST_NAME\"=?, \"LAST_NAME\"=?, \"EMAIL\"=?, \"GENDER\"=?, \"BRANCH\"=?, \"COLLEGE_CODE\"=?, \"MOBILE_NUMBER\"=?,  \"DOB\"=?,  \"REGULATION\"=? "
				+ " where \"USER_NAME\"=?";
		int rs = 0;
		dbConObj = new GetConnectionDetails();
		con = dbConObj.getConnection();
		ps = con.prepareStatement(updateQuery);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setString(3, email);
		ps.setString(4, gender);
		ps.setString(5, branch);
		ps.setString(6, cName);
		ps.setString(7, mobile);
		ps.setString(8, dob);
		ps.setString(9, regu);
		ps.setString(10, uName);
		rs = ps.executeUpdate();
		return rs;
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		RegistrationJDBC rJDBC = new RegistrationJDBC();
		String[] result=rJDBC.getDetails("venky");
		for (String r : result) {
			System.out.println(r);
		}
	}

}
