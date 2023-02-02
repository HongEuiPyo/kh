package free.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardLikeController
 */
@WebServlet("/free/like")
public class FreeBoardLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/like [GET]");
		
		
//		boardService.updateLike(req);
//
//		FreeBoard freeBoard = boardService.getVote(req);
//		
//		PrintWriter out = resp.getWriter();
//		
//		out.println(new Gson().toJson(freeBoard));	
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
				
	}
}
