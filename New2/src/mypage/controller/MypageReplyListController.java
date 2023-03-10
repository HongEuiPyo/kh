package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Attachment_profile;
import mypage.dto.Custom_reply;
import mypage.dto.Free_board_reply;
import mypage.dto.Official_reply;
import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageReplyListController
 */
@WebServlet("/mypage/reply/list")
public class MypageReplyListController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");
		
		User_info user_info = mypageService.getUserInfo(user_no);

		req.setAttribute("user_info", user_info);

		Attachment_profile attachmentFile = mypageService.getFile(user_no);

//		System.out.println("MyPageMainController - " + attachmentFile);
		req.setAttribute("attachmentFile", attachmentFile);

		List<Free_board_reply> freeBoardReply = mypageService.freeBoardReplySelectAll(user_no);

		session.setAttribute("freeBoardReply", freeBoardReply);

		List<Custom_reply> customReply = mypageService.customReplySelectAll(user_no);

		session.setAttribute("customReply", customReply);

		List<Official_reply> officialReply = mypageService.officialReplySelectAll(user_no);

		session.setAttribute("officialReply", officialReply);

		req.getRequestDispatcher("/WEB-INF/views/my/mypageReplyList.jsp").forward(req, resp);

	}

}
