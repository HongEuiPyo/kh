package member.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.User_info;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;

@WebServlet("/kh1/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/kh1/login [GET]");
		
		//VIEW 지정 - forward
		req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 얻기 - 로그인 정보
		User_info member = memberService.getLoginMember(req);
		
		//로그인 인증
		boolean login = memberService.login(member);
		
		
		if(login) {
			//세션정보 저장하기
			HttpSession session = req.getSession();
			
			//로그인 사용자의 정보 얻어오기
			member = memberService.info(member);
			
			session.setAttribute("login", login);
			session.setAttribute("user_no", member.getUser_no());
			session.setAttribute("userno", member.getUser_no());
			session.setAttribute("userid", member.getUser_email());
			session.setAttribute("usernick", member.getUser_nickname());
			
			//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}
			String id = (String)session.getAttribute("userid");
			
//			System.out.println(id.equals("projectkhwork@gmail.com"));
			
			if(id.equals("projectkhwork@gmail.com")) {
				resp.sendRedirect("/kh1/admin");
			
			} else {
			
			//메인페이지로 리다이렉트
			resp.sendRedirect("/main");
			}
		
	}
	
}
		
}
	



	

