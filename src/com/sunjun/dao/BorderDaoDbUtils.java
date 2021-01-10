package com.sunjun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunjun.domain.Border;
import com.sunjun.util.StringUtil;


public class BorderDaoDbUtils {

	
	public int borderCount(Connection con,Border border,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_borders s where 1 = 1");
		if(StringUtil.isNotEmpty(border.getTesterName())){
			sb.append(" and s.testerName like '%"+border.getTesterName()+"%'");
		}
		if(StringUtil.isNotEmpty(border.getTestStatus())){
			sb.append(" and s.testStatus like '%"+border.getTestStatus()+"%'");
		}
		if(StringUtil.isNotEmpty(border.getBoardType())){
			sb.append(" and s.boardType ='"+border.getBoardType()+"'");
		}
		
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.testTime)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.testTime)<=TO_DAYS('"+ebirthday+"')");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
	
	
}
