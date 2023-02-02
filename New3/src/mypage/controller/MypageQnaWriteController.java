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
 * Servlet implementation class MypageQnaController
 */
@WebServlet("/qna/write")
public class MypageQnaWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/kh1/login");
			return;
		}
		
		
		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

		User_info user_info = mypageService.getUserInfo(user_no);

		req.setAttribute("user_info", user_info);

		req.getRequestDispatcher("/WEB-INF/views/my/qnaWrite.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mypageService.write(req);

		resp.sendRedirect("/qna/list");

	}

}
