package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;


@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private EmpService empService = new EmpServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/list [GET]");
		
		//Emp���̺��� ��ü ����� ��ȸ�ϱ� - EmpService �̿�
		List<Emp> list = empService.list();
		
		//[TEST] ��ȸ��� Ȯ�� - console���		
		for(Emp e : list) System.out.println(e);
		
		//��ȸ�� ����� JSP(View)�� �����ϱ� - req��ü ���
		//	-> "empList"��� �̸����� JSP�ڵ忡 list��ü�� ����
		req.setAttribute("empList", list);
		
		
		//JSP�� View�����ϰ�, View�� �̿��� ���� - RequestDispatcher �̿�, forward()�޼ҵ� ���
		
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
		
		
	}
 
	
	
	

}
