package main.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;
import free.dto.FreeBoard;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;
import member.dto.User_info;
import member.service.face.MemberService;
import member.service.impl.MemberServiceImpl;
import official.dto.Official;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;
import util.Paging;

@WebServlet("/main")
public class MainPageController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// MemberService 객체 생성
	private MemberService memberService = new MemberServiceImpl();

	private CustomService customService = new CustomServiceImpl();
	private OfficialService officialService = new OfficialServiceImpl();
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main [GET]");

		// 전달파라미터 얻기 - 로그인 정보
		User_info member = memberService.getLoginMember(req);

		// 로그인 인증
		boolean login = memberService.login(member);

		if (login) {
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main2.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String search = req.getParameter("search");

		resp.sendRedirect("/main/total_search?search="  + search);
	}

}