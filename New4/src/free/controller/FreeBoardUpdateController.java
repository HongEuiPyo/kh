package free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.Free_board_attachment;
import free.dto.Free_board;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardUpdateController
 */
@WebServlet("/free/update")
public class FreeBoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("/free/update [GET]");
		
		Free_board freeBoard = boardService.getFreeBoardDetail(req);
		
		Free_board_attachment boardFile = new Free_board_attachment();
		
		boardFile.setFree_board_no(freeBoard.getFree_board_no());
		
		boardFile = boardService.getAttachment(boardFile);
		
		req.setAttribute("freeBoard", freeBoard);
		req.setAttribute("boardFile", boardFile);
		
		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/update [POST]");
		
		boardService.update(req);
		
		resp.sendRedirect("/free/list");
	}
}
