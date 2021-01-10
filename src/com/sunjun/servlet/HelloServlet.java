package com.sunjun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunjun.dao.BorderDao;
import com.sunjun.dao.BorderDaoDbUtils;
import com.sunjun.dao.impl.BorderDaoImpl;
import com.sunjun.domain.Border;
import com.sunjun.service.BorderService;
import com.sunjun.service.impl.BorderServiceImpl;
import com.sunjun.util.DbUtil;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	private BorderDao borderDao = new BorderDaoImpl();
	private BorderDaoDbUtils borderDaoDbUtils = new BorderDaoDbUtils();
	private DbUtil con = new DbUtil();
	private BorderService borderService = new BorderServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String testerName = request.getParameter("testerName");
			String startTime = request.getParameter("bbirthday");
			String endTime = request.getParameter("ebirthday");
			String boardType = request.getParameter("boardType");
			String testStatus = request.getParameter("testStatus");
			System.out.println(testStatus);
			System.out.println(testerName);
			System.out.println(startTime);
			System.out.println(endTime);
			System.out.println(boardType);
			Border border = new Border();
			border.setTesterName(testerName);
			border.setTestStatus(testStatus);
			border.setBoardType(boardType);
			int failCount = borderDaoDbUtils.borderCount(con.getCon(), border, startTime, endTime);
			System.out.println(failCount);
			int totalCount = borderService.findCount(con.getCon(), testerName, boardType, startTime, endTime);
			System.out.println(totalCount);
			int passTotal = totalCount - failCount;
			HttpSession session = request.getSession();
			session.setAttribute("boardType",boardType);
			session.setAttribute("testerName", testerName);
			session.setAttribute("passTotal", passTotal);
			session.setAttribute("totalCount", totalCount);
			session.setAttribute("failCount", failCount);
			response.sendRedirect(request.getContextPath()+"/chars.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.getCon().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}