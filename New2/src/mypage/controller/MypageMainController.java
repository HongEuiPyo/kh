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
 * Servlet implementation class MypageController
 */
@WebServlet("/mypage/main")
public class MypageMainController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [GET]");

		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/kh1/login");
			return;
		}
		
		//로그인 인증 상태
				boolean login = (boolean)req.getSession().getAttribute("login");
				
//				System.out.println("/main - login : " + login);
				
				if (login) {

					HttpSession session = req.getSession();
					
					int user_no = (int)session.getAttribute("user_no");

					User_info user_info = mypageService.getUserInfo(user_no);

					req.setAttribute("user_info", user_info);

					Attachment_profile attachmentFile = mypageService.getFile(user_no);

//					System.out.println("MyPageMainController - " + attachmentFile);
					req.setAttribute("attachmentFile", attachmentFile);
					

				} 
					

				// 전달파라미터 얻기 - 로그인 정보
				User_admin user_admin = mypageService.getLoginAdmin_info(req);
				
				// 로그인 인증
				boolean loginAdmin = mypageService.login(user_admin);

				if( loginAdmin ) {
					
					HttpSession session = req.getSession();

					session.setAttribute("loginAdmin", loginAdmin);
				}
				
				req.getRequestDispatcher("/WEB-INF/views/my/mypageMain.jsp").forward(req, resp);

			}

		}
