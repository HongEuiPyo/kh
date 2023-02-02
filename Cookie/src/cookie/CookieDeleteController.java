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
		
		//��û�� ��Ű�� ������
		Cookie[] cookies = req.getCookies();
		
		for(int i=0; i<cookies.length; i++) {
//			cookies[i].setMaxAge(0);	//	��� ����
//			cookies[i].setMaxAge(3);	//	3�� �� ����
			
			cookies[i].setMaxAge(24 * 60 * 60);	//	Ŭ���̾�Ʈ�� ��Ű ����
			
			resp.addCookie(cookies[i]);	//	Ŭ���̾�Ʈ�� ��Ű ����
						
		}
		
		req.getRequestDispatcher("/WEB-INF/views/cookie/delete.jsp")
			.forward(req, resp);
		
		
		
	}
	
}
