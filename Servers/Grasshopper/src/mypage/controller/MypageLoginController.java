package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Attachment_profile;
import mypage.dto.User_admin;
import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageLoginController
 */
@WebServlet("/mypage/login")
public class MypageLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.getRequestDispatcher("/WEB-INF/views/my/mypageLogin.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전달파라미터 얻기 - 로그인 정보
		User_info user_info = mypageService.getLoginUser_info(req);

		// 로그인 인증
		boolean login = mypageService.login(user_info);

		if (login) {

			user_info = mypageService.info(user_info);

			int user_no = user_info.getUser_no();

			// 세션정보 저장하기
			HttpSession session = req.getSession();

			session.setAttribute("login", login);

			session.setAttribute("user_no", user_no);

			Attachment_profile attachmentFile = mypageService.getFile(user_no);

			session.setAttribute("attachmentFile", attachmentFile);

			System.out.println(attachmentFile);

			session.setMaxInactiveInterval(60 * 30);

			resp.sendRedirect("/mypage/main");
		}

		// 전달파라미터 얻기 - 로그인 정보
		User_admin user_admin = mypageService.getLoginAdmin_info(req);
		
		// 로그인 인증
		boolean loginAdmin = mypageService.login(user_admin);

		if( loginAdmin ) {
			
			HttpSession session = req.getSession();

			session.setAttribute("loginAdmin", loginAdmin);
			
			resp.sendRedirect("/mypage/main/admin");

		}		
		
		

	}

	
	
	
	
	
	
}
