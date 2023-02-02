package join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.dto.Member;
import join.service.face.MemberService;
import join.service.impl.MemberServiceImpl;

@WebServlet("/duplchk/nick")
public class NickDuplicationChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/duplchk/nick [GET]");
		
		Member param = memberService.getDuplChkNick(req);
		System.out.println(param);
		
		int isDupl = memberService.checkDuplicationNick(param); 
		
		System.out.println(isDupl);

		resp.getWriter().println("{\"isDupl\": " + isDupl + "}");
	
	}

}
