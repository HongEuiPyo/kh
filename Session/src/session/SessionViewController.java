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
		
		//���� ��ü
		HttpSession session = req.getSession();
		
		//req.getSession(true)
		//	-> ���ǰ�ü�� �ҷ����µ� ������ ���Ӱ� �����ؼ� ��ȯ
		//	-> req.getSession() �� ����
		
		//req.getSession(false)
		//	-> ���ǰ�ü�� �ҷ����µ� ������ null�� ��ȯ
		
		//--------------------------------------------------------

		//���� ���� ����
	
		//���Ǿ��̵�, SESSION_ID
		System.out.println("Session ID : " + session.getId());
		
		//���� ���� �ð�
//		System.out.println("CreationTime : " + session.getCreationTime());
		System.out.println("CreationTime : " + new Date(session.getCreationTime()));
		
		//���� �ֱ�(������) ���� �ð�
//		System.out.println("LastAccessedTime : " + session.getLastAccessedTime());
		System.out.println("LastAccessedTime : " + new Date(session.getLastAccessedTime()));
	
		//���� ���� �ð�
		System.out.println("MaxInactiveInterval : " + session.getMaxInactiveInterval());
	
		//������ ���Ӱ� ������ ���� Ȯ��
		System.out.println("isNew : " + session.isNew());
		
		//-------------------------------------------------------------------------------------------
		
		//���� ����(������) ���
		System.out.println("test �������� : " + session.getAttribute("test"));
		
		//-------------------------------------------------------------------------------------------

		req.getRequestDispatcher("/WEB-INF/views/session/view.jsp")
			.forward(req, resp);
		
	}
	
}











