package com.dbCon;

import java.sql.*;

public class MySQLDBCon 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/job??useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	static final String USER = "root";
	static final String PASSWORD = "123456";
	
	private static Connection conn = null;
	
	public static Connection getCon() 
	{
        	try 
		{
            		Class.forName(JDBC_DRIVER);
            		String user = USER;
            		String pwd = PASSWORD;
            		String url = DB_URL;
            		conn = DriverManager.getConnection(url, user, pwd);
        	} 
		catch (Exception e) 
		{
            		e.printStackTrace();
        	}
        	return conn;
	}
}
