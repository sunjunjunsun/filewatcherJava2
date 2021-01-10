package com.sunjun.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sunjun.dao.BorderDao;
import com.sunjun.dao.impl.BorderDaoImpl;
import com.sunjun.domain.Border;
import com.sunjun.util.ResponseUtil;

import net.sf.json.JSONObject;

@WebServlet(urlPatterns = "/borderList")
public class QueryList extends HttpServlet{
	
	private BorderDao borderDao = new BorderDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  testerName= request.getParameter("testerName");
		String startTime = request.getParameter("bbirthday");
		String endTime = request.getParameter("ebirthday");
		String boardType = request.getParameter("boardType");
		
		System.out.println(boardType);
		
		//Map<String, String[]> condition = request.getParameterMap();
		
		Map<String, String[]> condition = new HashMap<String, String[]>();
		
		String[] aa= {"testerName"};
		String[] bb= {"startTime"};
		String[] cc= {"endTime"};
		String[] dd= {"boardType"};
	
		
		condition.put("testerName",aa);
		condition.put("startTime", bb);
		condition.put("endTime", cc);
		condition.put("boardType", dd);
		
		int findTotalCount = borderDao.findTotalCount(condition);
		System.out.println(findTotalCount);
		
		System.out.println(testerName);
		System.out.println(startTime);
		System.out.println(endTime);
	
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

}
