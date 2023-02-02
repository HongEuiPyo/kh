package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageUnregisterController
 */
@WebServlet("/mypage/unregister")
public class MypageUnregisterController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

		User_info user_info = mypageService.getUserInfoAll(user_no);

		req.setAttribute("user_info", user_info);

		session.setAttribute("user_info", user_info);

		req.getRequestDispatcher("/WEB-INF/views/my/mypageUnregister.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

		User_info user_info = mypageService.getUserInfoAll(user_no);

		mypageService.unregister(user_info, password);

		// 세션 해제
		req.getSession().invalidate();

		// 메인페이지로 리다이렉트
		resp.sendRedirect("/main");

	}

}
