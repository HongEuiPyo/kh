package free.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.BoardFile;
import free.dto.FreeBoard;
import free.dto.FreeReply;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class FreeBoardViewController
 */
@WebServlet("/free/view")
public class FreeBoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/free/view [GET]");
		
		//자유게시판 게시글 정보 가져오기
		FreeBoard freeBoard = boardService.getFreeBoardDetail(req);
		
		//자유게시판 게시글에 해당하는 첨부파일 가져오기
		BoardFile boardFile = boardService.getBoardFile(req);
		
		//자유게시판 게시글에 달린 댓글 가져오기
		List<FreeReply> freeReplyList = boardService.getReply(req);

		
		req.setAttribute("freeboard", freeBoard);
		req.setAttribute("boardFile", boardFile);		
		req.setAttribute("replyList", freeReplyList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_view.jsp").forward(req, resp);
	}
}
