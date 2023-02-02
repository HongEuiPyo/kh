package free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.Free_board;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;
import free.util.Paging;

/**
 * Servlet implementation class FreeBoardViewController
 */
@WebServlet("/free/list")
public class FreeBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/view [GET]");
		
		Paging paging = boardService.getPaging(req);
		System.out.println("freeboardlistController[GET] - " + paging);
		
		List<Free_board> boardList = boardService.getList(paging);
		System.out.println("---boardList---");
		System.out.println(boardList);
		
		
		
		req.setAttribute("boardList",  boardList);
		
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_list.jsp").forward(req, resp);
		
	}
}
