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

import free.dto.Free_board_reply;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardCommentDeleteController
 */
@WebServlet("/comment/delete")
public class FreeBoardReplyDeleteController extends BoardServiceImpl {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/comment/delete");
		
		resp.setContentType("application/json; charset=utf-8");
		
		boardService.deleteComment(req);		
		
		
		//자유게시판 게시글에 달린 댓글 가져오기
		List<Free_board_reply> freeReplyList = boardService.getReply(req);
		req.setAttribute("replyList", freeReplyList);
		
		
		
		PrintWriter out = resp.getWriter();
		out.println(new Gson().toJson(freeReplyList));	
		//resp.sendRedirect("/free/view?freeboardno="+req.getParameter("freeboardno"));
		//req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_view?freeobardno="+ req.getParameter("freeboardno")).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
