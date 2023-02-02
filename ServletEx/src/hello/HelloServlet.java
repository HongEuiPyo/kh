package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/hello [GET]");	
		
		//���� �������� ������ �����Ѵ� ( HETML ���� )
		resp.setContentType("text/html; charset=UTF-8");
		
		//����� ��� ��Ʈ��
		PrintWriter out = resp.getWriter();
		
		//���� ���� �ۼ� �� ��� - HTML �������� �ۼ��Ѵ�
		out.append("<h1>��������</h1>");
		out.append("<h3>�ߵǳ���?</h3>");
		
	}
	
	
	
}
