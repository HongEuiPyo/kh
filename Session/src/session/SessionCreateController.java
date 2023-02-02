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
		
		//���� ��ü ����
		HttpSession session = req.getSession();
		
		//���� ���� ����
		session.setAttribute("test", "Apple");

		//���� �����ð� �����ϱ�
//		session.setMaxInactiveInterval(0); //0�� == ������
//		session.setMaxInactiveInterval(5); //5��
		session.setMaxInactiveInterval(2 * 60 * 60); //2�ð�
		
		req.getRequestDispatcher("/WEB-INF/views/session/create.jsp")
			.forward(req, resp);
		
	}
	
}






