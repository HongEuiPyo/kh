package custom.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custom.dto.CustomComment;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class CustomCommentUpdateController
 */
@WebServlet("/custom/comment/update")
public class CustomCommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/comment/update [GET] Why you see me?");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/comment/update [POST]");
		
		//세션 객체 생성
		HttpSession session = req.getSession();

		//입력 문자 인코딩 한글처리
		req.setCharacterEncoding("UTF-8");

		//응답페이지 문자 인코딩
		resp.setContentType("text/html; charset=UTF-8");

		CustomComment customComment = new CustomComment();
		
		//수정할 comment의 reply_no 수신
		customComment.setCustom_reply_no(Integer.parseInt(req.getParameter("custom_reply_no")));
		customComment.setCustom_reply_content(req.getParameter("custom_reply_content"));
		

		System.out.println(customComment);
		
		//코멘트 업데이트
		customService.updateComment(customComment);
		
		//코멘트+파일업데이트 (disabled)
//		boardService.update(req, resp);
		
		System.out.println(req.getHeader("Referer"));
		
		resp.sendRedirect(req.getHeader("Referer"));
		
	}
}
	
	
	
