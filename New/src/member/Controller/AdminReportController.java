package member.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminReportController
 */
@WebServlet("/kh1/admin/report")
public class AdminReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/reportList.jsp").forward(req, resp);
		
		}
	

}
