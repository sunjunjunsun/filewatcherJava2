package com.sunjun.service.impl;

import java.sql.Connection;

import com.sunjun.dao.BorderDaoDbUtils;
import com.sunjun.domain.Border;
import com.sunjun.service.BorderService;
import com.sunjun.util.DbUtil;

public class BorderServiceImpl implements BorderService{
	
	private BorderDaoDbUtils borderDaoDbUtils = new BorderDaoDbUtils();
	private DbUtil cons = new DbUtil();

	@Override
	public int findCount(Connection con, String testerName, String boardType, String startTime, String endTime) {
		
		Border border = new Border();
		border.setTesterName(testerName);
		border.setBoardType(boardType);
		
		try {
			return borderDaoDbUtils.borderCount(cons.getCon(), border, startTime, endTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cons.getCon().close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}

}
