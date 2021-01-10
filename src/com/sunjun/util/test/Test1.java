package com.sunjun.util.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunjun.dao.BorderDaoDbUtils;
import com.sunjun.domain.Border;
import com.sunjun.util.DbUtil;

public class Test1 {

	public static void main(String[] args) {
		BorderDaoDbUtils borderDaoDbUtils = new BorderDaoDbUtils();
		DbUtil db = new DbUtil();
		Connection con = null;
		try {
			
		con = db.getCon();
		Border border = new Border();
	    String bbirthday = "2020-05-22";
	    String ebirthday = "2020-05-22";
//   border.setTestStatus("Reviewed Passed");  //31
	   border.setTestStatus("Repaired"); // 9
		
//	    border.setTesterName("V810-8088S2");  //23
//	    border.setTesterName("V810-8086S2");  //13
//	    border.setTesterName("V810-3325S2EX");//4
	    
	  //  border.setBoardType("LY2A-MB-0150-C3A-DD-01"); //15
	   // border.setBoardType("T6U-MB-00B0-F3H-DD-02");

	 //   border.setTestStatus("Reviewed Passed");
	    
	    
	    
	    int borderCount = borderDaoDbUtils.borderCount(con, border, bbirthday, ebirthday);
			System.out.println(borderCount);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
