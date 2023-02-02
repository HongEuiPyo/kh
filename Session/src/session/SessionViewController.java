package session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/view")
public class SessionViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/session/view [GET]");
		
		//세션 객체
		HttpSession session = req.getSession();
		
		//req.getSession(true)
		//	-> 세션객체를 불러오는데 없으면 새롭게 생성해서 반환
		//	-> req.getSession() 과 같음
		
		//req.getSession(false)
		//	-> 세션객체를 불러오는데 없으면 null값 반환
		
		//--------------------------------------------------------

		//세션 관련 정보
	
		//세션아이디, SESSION_ID
		System.out.println("Session ID : " + session.getId());
		
		//세션 생성 시간
//		System.out.println("CreationTime : " + session.getCreationTime());
		System.out.println("CreationTime : " + new Date(session.getCreationTime()));
		
		//세션 최근(마지막) 접속 시간
//		System.out.println("LastAccessedTime : " + session.getLastAccessedTime());
		System.out.println("LastAccessedTime : " + new Date(session.getLastAccessedTime()));
	
		//세션 유지 시간
		System.out.println("MaxInactiveInterval : " + session.getMaxInactiveInterval());
	
		//세션이 새롭게 생성된 건지 확인
		System.out.println("isNew : " + session.isNew());
		
		//-------------------------------------------------------------------------------------------
		
		//세션 정보(데이터) 출력
		System.out.println("test 세션정보 : " + session.getAttribute("test"));
		
		//-------------------------------------------------------------------------------------------

		req.getRequestDispatcher("/WEB-INF/views/session/view.jsp")
			.forward(req, resp);
		
	}
	
}











