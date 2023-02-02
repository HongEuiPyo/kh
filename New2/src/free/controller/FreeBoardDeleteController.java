package free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardDeleteController
 */
@WebServlet("/free/delete")
public class FreeBoardDeleteController extends BoardServiceImpl {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/delete [GET]");
		
		boardService.delete(req);
		
		resp.sendRedirect("/free/list");
		
	}

}
