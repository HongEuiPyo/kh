package member.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/kh1/logout")
public class MemberLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/kh1/logout [GET]");
		//세션 해제
		req.getSession().invalidate();
				
		HttpSession session = req.getSession();
//		session.setAttribute("login", login);
//		session.setAttribute("userno", member.getUser_no());
//		session.setAttribute("user_no", member.getUser_no());
////		session.setAttribute("userid", member.getUser_email());
//		session.setAttribute("usernick", member.getUser_nickname());
		
		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}	

		//메인페이지로 리다이렉트
		resp.sendRedirect("/main");
		
	}
}
