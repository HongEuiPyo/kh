package official.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import official.dto.OfficialComment;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;

/**
 * Servlet implementation class OfficialCommentWriteController
 */
@WebServlet("/official/comment/write")
public class OfficialCommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		OfficialService officialService = new OfficialServiceImpl();
	
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("/official/comment [GET] why you see me?");
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
//			int user_no = 2; //임시로 회원번호 부여
						
			//OfficialComment 객체 생성
			OfficialComment officialComment = new OfficialComment();
			
//			officialComment.setOfficial_reply_no(official_reply_no); //자동입력
			officialComment.setOfficial_board_no(board_no);
			officialComment.setUser_no(user_no);
//			officialComment.setUser_nickname(user_nickname); //Service에서 받아서입력하기
//			officialComment.setBoard_type(board_type); //Service에서 official에 맞는 타입으로 자동 입력
			officialComment.setOfficial_reply_content(content);
//			officialComment.setOfficial_reply_date(official_reply_date); //자동입력
			
			System.out.println(officialComment);
			
			//코멘트 등록 메소드
			officialService.writeComment(officialComment);
			
			resp.sendRedirect("/official/view?official_no=" + board_no);

		}
}

