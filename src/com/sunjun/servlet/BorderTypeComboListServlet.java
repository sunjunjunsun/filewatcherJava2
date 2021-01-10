package com.sunjun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sunjun.dao.BorderDao;
import com.sunjun.dao.impl.BorderDaoImpl;
import com.sunjun.domain.Border;
import com.sunjun.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet(urlPatterns = "/index")
public class BorderTypeComboListServlet extends HttpServlet{

	private BorderDao borderDao = new BorderDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Border> list = borderDao.findBorderTypesAll();
		Set<String> list2 = new HashSet<String>();
		for (Border border : list) {
			//System.out.println(border.getBoardType());
			list2.add(border.getBoardType());
		}
		
		request.setAttribute("list2", list2);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}
}