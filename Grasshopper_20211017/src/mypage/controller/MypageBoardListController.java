package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Custom_board;
import mypage.dto.Free_board;
import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageListController
 */
@WebServlet("/mypage/board/list")
public class MypageBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
	
		int user_no = (int)session.getAttribute("user_no");
		
		List<Custom_board> customBoardList = mypageService.customBoardSelectAll(user_no);

		System.out.println(customBoardList);

		session.setAttribute("customBoardList", customBoardList);

		List<Free_board> freeBoardList = mypageService.freeBoardSelectAll(user_no);

		System.out.println(freeBoardList);

		session.setAttribute("freeBoardList", freeBoardList);

		req.getRequestDispatcher("/WEB-INF/views/my/mypageWriteList.jsp").forward(req, resp);

	}

}
