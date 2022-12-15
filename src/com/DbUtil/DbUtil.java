package com.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	public static Connection ProvideConection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/cwsb101";
		
		try {
			conn= DriverManager.getConnection(url,"root","Adeep");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return conn;
		
	}

}
