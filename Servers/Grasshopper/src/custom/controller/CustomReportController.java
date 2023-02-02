package custom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Report;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class CustomReportController
 */
@WebServlet("/custom/report")
public class CustomReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/report [POST]");
		
		//입력 문자 인코딩 한글처리
		req.setCharacterEncoding("UTF-8");

		//응답페이지 문자 인코딩
		resp.setContentType("text/html; charset=UTF-8");
		
		String referer = req.getHeader("referer");
		String title = (String) req.getParameter("board_title");
		String reply = req.getParameter("reply_content");
		
		System.out.println("report_link : " + referer +", title : " + title + ", reply_content : " + reply);
		
		Report report = new Report();
		report.setReport_link(referer);
		report.setReport_board_title(title);
		if(reply != null && !"".equals(reply)) {
			report.setReport_board_title(reply);
		};
		
		customService.reportContent(report);
		
		resp.sendRedirect(referer);
	}
}
