package mypage.controller;

import mypage.service.impl.MypageServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MypageLogoutController
 */
@WebServlet("/mypage/logout")
public class MypageLogoutController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션 해제
		req.getSession().invalidate();

		// 메인페이지로 리다이렉트
		resp.sendRedirect("/mypage/main");

	}

}
