package com.sunjun.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil {

	private String dbUrl="jdbc:mysql://172.26.17.49:3306/smtxml?useUnicode=true&characterEncoding=utf8";
	private String dbUserName="root";
	private String dbPassword="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}

