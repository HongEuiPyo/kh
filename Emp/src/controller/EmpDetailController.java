package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpDetailController
 */
@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//���� ��ü
	private EmpService empService = new EmpServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/emp/detail [GET]");
			
			//��û�����κ��� �����Ķ���� empno ���� - req��ü �̿�
			String param = req.getParameter("empno");
			System.out.println("�����Ķ���� empno : " + param);
			
			int empno = 0; //�Ķ���͸� ������ ����
			if( param!=null && !"".equals(param)) {
				empno = Integer.parseInt(param); //Strind -> int ��ȯ
			} else {
				System.out.println("[ERROR] �����Ķ����(empno) �߸� ���޵�");
			}
			System.out.println("[TEST] empno : " + empno);
			
			// ��� ���� �� ��ȸ�ϱ� - EmpService �̿�
			Emp emp = empService.detail(empno);
			System.out.println("EmpController - emp: " + emp);
			
			
			// ��ȸ����� view�� ���� - req��ü �̿�
			req.setAttribute("emp", emp);
			
			
			//view �����ϱ� - RequestDispatcher�̿�
			//view�� �������� ����ϱ� - forward()
			req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
			
			
			
			
			
		}

}
