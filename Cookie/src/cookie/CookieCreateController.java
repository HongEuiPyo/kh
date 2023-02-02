package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/create")
public class CookieCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cookie/create [GET]");
		
		Cookie c1 = new Cookie("ID", "Ali");	//쿠키 객체 생성
		resp.addCookie(c1);	//	쿠키 정보를 클라이언트로 보내는 코드
		
		Cookie c2 = new Cookie("PASS", "1234");
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("NAME", "Alice");
		resp.addCookie(c3);
		
		// 응답객체(resp)를 통한 addCookie()메소드 호출은
		// 응답메시지 헤더(Response Header)에 Set-Cookie 항목을
		// 추가한다
		//	-> 클라이언트는 Set-Cookie 항목의 쿠키 정보를 저장한다
		
		//--------------------------------------------
		
		req.getRequestDispatcher("/WEb-INF/views/cookie/create.jsp")
		.forward(req, resp);
		
		
	}
	
}
