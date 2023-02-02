package custom.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import custom.dto.CustomComment;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class CustomCommentWriteController
 */
@WebServlet("/custom/comment/write")
public class CustomCommentWriteController extends CustomServiceImpl {
	private static final long serialVersionUID = 1L;
       
		CustomService customService = new CustomServiceImpl();
	
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("/custom/comment [GET] why you see me?");
		}
		
		@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//세션 객체 생성
			HttpSession session = req.getSession();
	
			//입력 문자 인코딩 한글처리
			req.setCharacterEncoding("UTF-8");

			//응답페이지 문자 인코딩
			resp.setContentType("text/html; charset=UTF-8");

			//전달 파라미터 입력
			String content = req.getParameter("content"); //댓글 내용
			int board_no = Integer.parseInt(req.getParameter("board_no")); //댓글을 달 게시글 번호
			
			int user_no = (Integer)session.getAttribute("user_no"); //현재 로그인 시 회원번호 가져오기
						
			//CustomComment 객체 생성
			CustomComment customComment = new CustomComment();
			
//			customComment.setCustom_reply_no(custom_reply_no); //자동입력
			customComment.setCustom_board_no(board_no);
			customComment.setUser_no(user_no);
//			customComment.setUser_nickname(user_nickname); //Service에서 받아서입력하기
//			customComment.setBoard_type(board_type); //Service에서 custom에 맞는 타입으로 자동 입력
			customComment.setCustom_reply_content(content);
//			customComment.setCustom_reply_date(custom_reply_date); //자동입력
			
			System.out.println(customComment);
			
			//코멘트 등록 메소드
			customService.writeComment(customComment);
			
			resp.sendRedirect("/custom/view?custom_no=" + board_no);

		}
}

