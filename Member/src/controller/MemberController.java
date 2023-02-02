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
		System.out.println("/member/join [GET] - 요청 완료");
		
		//View를 지정하고 응답하기 - forward
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp")
			.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [POST] - 요청 완료");
		
		//1. POST 전달데이터 한글 인코딩 설정 (UTF-8)
		req.setCharacterEncoding("UTF-8");
		
		//2. 전달파라미터를 Member객체에 저장 - MemberService 이용
		Member param = memberService.getParam(req);
		System.out.println("MemberController - " + param);
		
		//3. Member객체를 데이터베이스에 입력
		Member result = memberService.join(param);
		System.out.println("MemberController result - " + result);
		
		//4. DB에 입력된 값을 View에 전달
		req.setAttribute("result", result);
		
		//5. View를 지정하고 응답하기
		req.getRequestDispatcher("/WEB-INF/views/member/result.jsp")
			.forward(req, resp);
	}
	
}










