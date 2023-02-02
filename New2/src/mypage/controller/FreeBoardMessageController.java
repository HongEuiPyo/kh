package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import free.dto.Free_board_attachment;
import free.dto.Free_board_reply;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;
import mypage.dto.Free_board;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class FreeBoardMessageController
 */
@WebServlet("/freeboard/message")
public class FreeBoardMessageController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	MypageService mypageService = new MypageServiceImpl();
	BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

		// 자유게시판 게시글 정보 가져오기
		free.dto.Free_board freeBoard = boardService.getFreeBoardDetail(req);

		Free_board free_board = new Free_board();
		free_board.setUser_no(freeBoard.getUser_no());

		//메세지보내기
		mypageService.FreeBoardInsertMessage(req, free_board, user_no);
		
		// 자유게시판 게시글에 해당하는 첨부파일 가져오기
		Free_board_attachment boardFile = boardService.getBoardFile(req);
		// 자유게시판 게시글에 달린 댓글 가져오기
		List<Free_board_reply> freeReplyList = boardService.getReply(req);

		req.setAttribute("freeboard", freeBoard);
		req.setAttribute("boardFile", boardFile);
		req.setAttribute("replyList", freeReplyList);

		req.getRequestDispatcher("/WEB-INF/views/freeboard/freeboard_view.jsp").forward(req, resp);

	}

}
