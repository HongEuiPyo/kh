package form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/form.do [GET]");
		
		//JSP�� ���䵥���� ����� - VIEW �����ϱ�
		RequestDispatcher rd;		
		rd = req.getRequestDispatcher("/WEB-INF/views/inputForm.jsp");
		
		//������ JSP�� �̿��Ͽ� ���� ������
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/form.do [POST]");		
		// ----------------------------------------------
		// ��û �������� �ѱ� ���ڵ� ��� �����ϱ�
		req.setCharacterEncoding("UTF-8");
		
		// ���� �������� ���� �����ϱ�
		resp.setContentType("text/html; charset=utf-8");
		// -----------------------------------------------
		
		String uid = req.getParameter("userid");
		String upw = req.getParameter("userpw");
		
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		// -----------------------------------------------
		
		// �������� Ŭ���̾�Ʈ�� ���� �����ϱ�
		//	-> JSP(VIEW)�� �̿����� �ʴ´�
		
		
		resp.getWriter()
			.append("<h1>���޹��� ������</h1>")
			.append("<hr>")
			.append("<h3>���̵� : " + uid + "</h3>")
			.append("<h3>�н����� : " + upw + "</h3>");
		
		
		resp.getWriter()
			.append("<a href='/form.do'>�Է� ������</a>");
	}
	
	
	
}
