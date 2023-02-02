package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Attachment_profile;
import mypage.dto.Qna_board;
import mypage.dto.Qna_board_attachment;
import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageQnaUpdateController
 */
@WebServlet("/qna/update")
public class MypageQnaUpdateController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

		User_info user_info = mypageService.getUserInfo(user_no);

		req.setAttribute("user_info", user_info);
		
		Attachment_profile attachmentFile = mypageService.getFile(user_no);

//		System.out.println("MyPageMainController - " + attachmentFile);
		req.setAttribute("attachmentFile", attachmentFile);
		

		Qna_board boardno = mypageService.getBoardno(req);

		Qna_board updateBoard = mypageService.view(boardno);

		req.setAttribute("updateBoard", updateBoard);

		Qna_board_attachment boardFile = mypageService.viewFile(updateBoard);

		req.setAttribute("boardFile", boardFile);

		req.getRequestDispatcher("/WEB-INF/views/my/qnaUpdate.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mypageService.updateQna(req);

		resp.sendRedirect("/qna/list");

	}

}
