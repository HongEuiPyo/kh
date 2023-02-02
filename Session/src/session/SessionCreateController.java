package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/create")
public class SessionCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/session/create [GET]");
		
		//세션 객체 생성
		HttpSession session = req.getSession();
		
		//세션 정보 저장
		session.setAttribute("test", "Apple");

		//세션 유지시간 변경하기
//		session.setMaxInactiveInterval(0); //0초 == 무제한
//		session.setMaxInactiveInterval(5); //5초
		session.setMaxInactiveInterval(2 * 60 * 60); //2시간
		
		req.getRequestDispatcher("/WEB-INF/views/session/create.jsp")
			.forward(req, resp);
		
	}
	
}






