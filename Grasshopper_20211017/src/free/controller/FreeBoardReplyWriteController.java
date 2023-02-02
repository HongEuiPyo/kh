package free.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import free.dto.FreeReply;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardReplyController
 */
@WebServlet("/reply/write")
public class FreeBoardReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/reply [GET]");
		
		resp.setContentType("application/json; charset=utf-8");
		
		boardService.insertReply(req);
		
		List<FreeReply> freeReplyList = boardService.getReply(req);
		
		
		
		PrintWriter out = resp.getWriter();
		
		out.println(new Gson().toJson(freeReplyList));		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/reply [POST]");

		doGet(req, resp);
		
		
	}
}
