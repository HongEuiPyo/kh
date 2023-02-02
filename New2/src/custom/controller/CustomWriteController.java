package custom.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;


/**
 * Servlet implementation class CustomWriteController
 */
@WebServlet("/custom/write")
public class CustomWriteController extends CustomServiceImpl {
private static final long serialVersionUID = 1L;
    
	private CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/write [GET]");
		
		//세션 객체 생성
		HttpSession session = req.getSession();
		
		//로그인 되어있지 않으면 리다이렉트
		if( session.getAttribute("login")== null || !(boolean)session.getAttribute("login")) {
			resp.sendRedirect("/");
			return;
		}
		
		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}		
		
		//세션확인 및 테스트용 세션파라미터 지정
		System.out.println("[TEST] session : " + session);
		session.getAttribute("login");
		session.getAttribute("user_no");
		
		req.getRequestDispatcher("/WEB-INF/views/board/custom_write.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/write [POST]");
		
		//작성글 삽입
		customService.write(req);
		
		
		
		//목록으로 리다이렉션
		resp.sendRedirect("/custom/list");
		
	}
	
	
}
