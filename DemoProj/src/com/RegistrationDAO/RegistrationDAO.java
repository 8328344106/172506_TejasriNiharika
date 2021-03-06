package com.RegistrationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.DataBaseConnection.ConnectionData;

import com.DataPojo.IMDBRegisterPojo;
public class RegistrationDAO 
{
	

	 public int insert(IMDBRegisterPojo  registration ) throws SQLException
	 {
		 Connection conn = ConnectionData.getConnection();
		 String query = "insert into reg values(?,?,?)";
		 PreparedStatement pStatement=  conn.prepareStatement(query);
		 pStatement.setString(1, registration.getUsername());
		 pStatement.setString(2, registration.getPassword());
		 pStatement.setString(3, registration.getReenterpassword());
		 int output=pStatement.executeUpdate();
		 return output;
	 }
}
