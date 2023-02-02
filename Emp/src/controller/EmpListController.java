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
		
		//Emp테이블의 전체 목록을 조회하기 - EmpService 이용
		List<Emp> list = empService.list();
		
		//[TEST] 조회결과 확인 - console출력		
		for(Emp e : list) System.out.println(e);
		
		//조회된 결과를 JSP(View)에 전달하기 - req객체 사용
		//	-> "empList"라는 이름으로 JSP코드에 list객체를 전달
		req.setAttribute("empList", list);
		
		
		//JSP를 View지정하고, View를 이용한 응답 - RequestDispatcher 이용, forward()메소드 사용
		
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
		
		
	}
 
	
	
	

}
