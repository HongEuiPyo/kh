package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Qna_board_reply;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageQnaReplyController
 */
@WebServlet("/qna/reply")
public class MypageQnaReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
			
		//세션 객체 생성
		HttpSession session = req.getSession();

		//입력 문자 인코딩 한글처리
		req.setCharacterEncoding("UTF-8");

		//응답페이지 문자 인코딩
		resp.setContentType("text/html; charset=UTF-8");

		//전달 파라미터 입력
		String content = req.getParameter("commentContent"); //댓글 내용
		int board_no = Integer.parseInt(req.getParameter("board_no")); //댓글을 달 게시글 번호

		int user_no = (int) session.getAttribute("user_no");
		
		Qna_board_reply qna_board_reply = new Qna_board_reply();
		
		qna_board_reply.setQna_board_no(board_no);
		qna_board_reply.setUser_no(user_no);
		qna_board_reply.setQna_reply_content(content);
		
		mypageService.writeQnaReply(qna_board_reply);

		
		resp.sendRedirect("/qna/view?boardno=" + board_no);
		
		}
	
	}
	
	
