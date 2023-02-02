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
       
	//서비스 객체
	private EmpService empService = new EmpServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("/emp/detail [GET]");
			
			//요청정보로부터 전달파라미터 empno 추출 - req객체 이용
			String param = req.getParameter("empno");
			System.out.println("전달파라미터 empno : " + param);
			
			int empno = 0; //파라미터를 저장할 변수
			if( param!=null && !"".equals(param)) {
				empno = Integer.parseInt(param); //Strind -> int 변환
			} else {
				System.out.println("[ERROR] 전달파라미터(empno) 잘못 전달됨");
			}
			System.out.println("[TEST] empno : " + empno);
			
			// 사원 정보 상세 조회하기 - EmpService 이용
			Emp emp = empService.detail(empno);
			System.out.println("EmpController - emp: " + emp);
			
			
			// 조회결과를 view에 전달 - req객체 이용
			req.setAttribute("emp", emp);
			
			
			//view 지정하기 - RequestDispatcher이용
			//view를 응답으로 사용하기 - forward()
			req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
			
			
			
			
			
		}

}
