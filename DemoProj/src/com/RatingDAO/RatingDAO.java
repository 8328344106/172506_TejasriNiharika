package com.RatingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DataBaseConnection.ConnectionData;
import com.ratingpojo.RatingPojo;

public class RatingDAO 
{
	public int insert(RatingPojo  registration ) throws SQLException
	 {
		 Connection conn = ConnectionData.getConnection();
		 String query = "insert into rating values(?,?,?,?)";
		 PreparedStatement pStatement=  conn.prepareStatement(query);
		 pStatement.setString(1, registration.getUsername());
		 pStatement.setString(2, registration.getPassword());
		 pStatement.setString(3, registration.getRating());
		 pStatement.setString(4, registration.getComent());
		 int output=pStatement.executeUpdate();
		 return output;
	 }
}
