package free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.Member;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardWriteController
 */
@WebServlet("/free/write")
public class FreeBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/write [GET]");
		req.setCharacterEncoding("utf-8");
		
		Member member = boardService.getuser_nickname(req);
		
		req.setAttribute("usernick", member.getUser_nickname());
		
		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boardService.write(req);
		
		resp.sendRedirect("/free/list");
	}
}
