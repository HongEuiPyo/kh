package controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/login [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp")
			.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/login/login [POST]");
		
		//�����Ķ���� ������ - userid, userpw
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		System.out.println("userid - " + userid);
		System.out.println("userpw - " + userpw);
		
		//-------------------------------------------------------
		
		//���� ��ü
		HttpSession session = req.getSession();
		
		//�������� URL
		String url = null;
		
		if( "abc".equals(userid) && "123".equals(userpw) ) {
			//�α��� ����
			
			System.out.println("LoginController [POST] - �α��� ����");
			
			session.setAttribute("login", true); //�α��� ����
			session.setAttribute("loginid", userid); //�α����� ���̵�
			
			url = "/WEB-INF/views/login/loginSuccess.jsp";
			
		} else {
			//�α��� ����
			
			System.out.println("LoginController [POST] - �α��� ����");

			url = "/WEB-INF/views/login/loginFail.jsp";
			
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
	
}









