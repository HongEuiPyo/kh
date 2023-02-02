package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/update")
public class CookieUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cookie/update [GET]");
		
		Cookie coo1 = new Cookie("ID", "boo");	//	쿠키 객체 생성
		resp.addCookie(coo1);	//	클라이언트에 쿠키 전달
		
		resp.addCookie( new Cookie("PASS", "87234a"));
		
		resp.addCookie( new Cookie("name", "Bob"));
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/update.jsp")
			.forward(req, resp);
	}

}
