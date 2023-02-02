package controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/logout [GET]");
		
		//세션 객체
		HttpSession session = req.getSession();
		
		//세션 삭제 - 로그아웃
		session.invalidate();

		//메인화면으로 리다이렉트
		resp.sendRedirect("/login/login");
		
	}
	
}
