package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/insert")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/insert [GET]");
			
		req.getRequestDispatcher("/WEP-INF/views/board/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/insert [POST}");
		
		//한글 인코딩 설정
		//	-> 서블릿 필터를 통해서 설정한다	
//		req.setCharacterEncoding("UTF-8");
		
		System.out.println("title : " + req.getParameter("title"));
		System.out.println("content : " + req.getParameter("content"));
	}
	
	
	
	
}
