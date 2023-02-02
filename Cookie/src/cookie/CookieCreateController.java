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
		
		Cookie c1 = new Cookie("ID", "Ali");	//��Ű ��ü ����
		resp.addCookie(c1);	//	��Ű ������ Ŭ���̾�Ʈ�� ������ �ڵ�
		
		Cookie c2 = new Cookie("PASS", "1234");
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("NAME", "Alice");
		resp.addCookie(c3);
		
		// ���䰴ü(resp)�� ���� addCookie()�޼ҵ� ȣ����
		// ����޽��� ���(Response Header)�� Set-Cookie �׸���
		// �߰��Ѵ�
		//	-> Ŭ���̾�Ʈ�� Set-Cookie �׸��� ��Ű ������ �����Ѵ�
		
		//--------------------------------------------
		
		req.getRequestDispatcher("/WEb-INF/views/cookie/create.jsp")
		.forward(req, resp);
		
		
	}
	
}
