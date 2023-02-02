package custom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class CustomDeleteController
 */
@WebServlet("/custom/delete")
public class CustomDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//CustomService 객체 생성
	private CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Custom custom = customService.getCustom_no(req);
		
		customService.delete(custom);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/custom/list");	

	}
}
