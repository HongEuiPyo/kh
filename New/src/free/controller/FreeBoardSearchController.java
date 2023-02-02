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
 * Servlet implementation class FreeBoardSearchController
 */
@WebServlet("/free/search")
public class FreeBoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/search [GET]");
		req.setCharacterEncoding("utf-8");
		
		
		
		Paging paging = boardService.getSearchPaging(req);
		System.out.println("freeboardlistController[GET] - " + paging);
		
		List<Free_board> boardList = boardService.getSearchList(paging, req);
		
		
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("paging", paging);
		req.setAttribute("search", req.getParameter("search"));
		req.setAttribute("type", req.getParameter("type"));
		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_research.jsp").forward(req, resp);
		
	}
}
