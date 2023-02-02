package member.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.User_info;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;
import member.util.Paging;

@WebServlet("/kh1/admin/member")
public class AdminMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//BoardService 객체 생성
		private MemberService memberService = new MemberServiceImpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//요청파라미터를 전달하여 Paging객체 생성하기
			Paging paging = memberService.getPaging(req);
			System.out.println("AdminMemberController [GET] - " + paging);
			
			//멤버 전체 조회
			List<User_info> memberList = memberService.getList(paging);
			
			//조회결과 MODEL값 전달
			req.setAttribute("memberList", memberList);
		
			//페이징 정보 MODEL값 전달
			req.setAttribute("paging", paging);
			
			//VIEW 지정 및 응답 - forward
			req.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp").forward(req, resp);		
			
		}

}
