package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/delete")
public class SessionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/session/delete [GET]");
		
		//���� ��ü
		HttpSession session = req.getSession();
		
		//���� ����(��ü) ����
		session.invalidate();
		
		req.getRequestDispatcher("/WEB-INF/views/session/delete.jsp")
			.forward(req, resp);
		
	}
	
}





