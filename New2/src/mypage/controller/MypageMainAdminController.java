package mypage.controller;

import mypage.service.impl.MypageServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MypageMainAdminController
 */
@WebServlet("/mypage/main/admin")
public class MypageMainAdminController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.getRequestDispatcher("/WEB-INF/views/my/mypageMainAdmin.jsp").forward(req, resp);
}

	
	
}
