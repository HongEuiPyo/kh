package member.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Report;
import member.service.face.ReportService;
import member.service.impl.ReportServiceImpl;
import member.util.Paging;

@WebServlet("/kh1/admin/report")
public class AdminReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReportService reportService = new ReportServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	//요청파라미터를 전달하여 Paging객체 생성하기
	Paging paging = reportService.getPaging(req);
	System.out.println("AdminReportController [GET] - " + paging);
	
	//멤버 전체 조회
	List<Report> reportList = reportService.getList(paging);
	
	//조회결과 MODEL값 전달
	req.setAttribute("reportList", reportList);
	
	//페이징 정보 MODEL값 전달
	req.setAttribute("paging", paging);
	
	//VIEW 지정 및 응답 - forward
	req.getRequestDispatcher("/WEB-INF/views/admin/reportList.jsp").forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	

}
