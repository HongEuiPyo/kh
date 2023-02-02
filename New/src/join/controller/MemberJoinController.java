package join.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.dao.face.MemberDao;
import join.dao.impl.MemberDaoImpl;
import join.dto.Member;
import join.service.face.MemberService;
import join.service.impl.MemberServiceImpl;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [GET]");
	
		req.getRequestDispatcher("/WEB-INF/views/member/joinform.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [POST]");
		
		//한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//요청파라미터 처리
		Member info = memberService.getJoinMember(req);//입력한 가입정보 가져오기
		System.out.println("MemberJoinController - info : " + info); 
		
		
		//DB에 동일 아이디(email)값이 있는지 확인
		int duplchk = memberService.checkDuplNickEmail(info);
		
		if( duplchk == 0) {
			
			//회원가입 시도
			boolean resInsert = memberService.join(info); //커밋(true), 실패(false)
			
			if( resInsert == true ) { //회원가입 성공함
				
				//DB 데이터 다시 조회하여 전달값 전달
				Member userinfo = memberService.getMember(info);//user_no까지 포함된 정보 가져옴
				System.out.println("전달값 확인: " + userinfo);
				
				req.setAttribute("userinfo", userinfo );
				req.getRequestDispatcher("/WEB-INF/views/member/joinresult.jsp").forward(req, resp);
				
			} else if( duplchk == 1) { //회원가입 불가
				req.getRequestDispatcher("/WEB-INF/views/member/joinfail.jsp").forward(req, resp);
			}
			
		} 
		

	
	}
}
