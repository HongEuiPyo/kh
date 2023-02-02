package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [GET] - ��û �Ϸ�");
		
		//View�� �����ϰ� �����ϱ� - forward
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp")
			.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [POST] - ��û �Ϸ�");
		
		//1. POST ���޵����� �ѱ� ���ڵ� ���� (UTF-8)
		req.setCharacterEncoding("UTF-8");
		
		//2. �����Ķ���͸� Member��ü�� ���� - MemberService �̿�
		Member param = memberService.getParam(req);
		System.out.println("MemberController - " + param);
		
		//3. Member��ü�� �����ͺ��̽��� �Է�
		Member result = memberService.join(param);
		System.out.println("MemberController result - " + result);
		
		//4. DB�� �Էµ� ���� View�� ����
		req.setAttribute("result", result);
		
		//5. View�� �����ϰ� �����ϱ�
		req.getRequestDispatcher("/WEB-INF/views/member/result.jsp")
			.forward(req, resp);
	}
	
}










