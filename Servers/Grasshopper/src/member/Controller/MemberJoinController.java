package member.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.User_info;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;

@WebServlet("/kh1/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/login/join.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청파라미터 처리
		User_info param = memberService.getJoinMember(req);
		
		// 회원가입
		memberService.join(param);
		
		// 메인으로 리다이렉션
		resp.sendRedirect("/kh1/login");
		
	}
	
}
