package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/delete")
public class CookieDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cookie/delete [GET]");
		
		//요청된 쿠키들 얻어오기
		Cookie[] cookies = req.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
//			cookies[i].setMaxAge(0);	//	즉시 삭제
//			cookies[i].setMaxAge(3);	//	3초 뒤 삭제
			
			cookies[i].setMaxAge(24 * 60 * 60);	//	클라이언트로 쿠키 전송
			
			resp.addCookie(cookies[i]);	//	클라이언트로 쿠키 전송
						
		}
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/delete.jsp")
			.forward(req, resp);
		
		
		
	}
	
}
