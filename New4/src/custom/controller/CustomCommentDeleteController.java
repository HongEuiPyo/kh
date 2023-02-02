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
 * Servlet implementation class CustomCommentDeleteController
 */
@WebServlet("/custom/comment/delete")
public class CustomCommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/delete [GET]");
		
		//세션 객체 생성
		HttpSession session = req.getSession();

		//요청파라미터 /custom/delete?customno=??? 에 해당하는 customno 받기
		int custom_reply_no = Integer.parseInt(req.getParameter("custom_reply_no"));
		System.out.println(custom_reply_no);
		
		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}	
		
		CustomComment customComment = new CustomComment();
		customComment.setCustom_reply_no(custom_reply_no);
		
		System.out.println(customComment);
		
		//custom_reply_no에 해당하는 글 지우기
		customService.deleteComment(customComment);

		//목록으로 리다이렉트
		resp.sendRedirect(req.getHeader("Referer"));
	}

}
