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
import mypage.dto.Message;
import mypage.dto.User_info;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageSendMessageList
 */
@WebServlet("/mypage/sendmessage")
public class MypageSendMessageList extends HttpServlet {
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
		
		List<Message> message = mypageService.sendMessageSelect(user_no);

		session.setAttribute("message", message);

		List<User_info> userinfo = mypageService.getList();

		session.setAttribute("userinfo", userinfo);

		req.getRequestDispatcher("/WEB-INF/views/my/mypageSendMessageList.jsp").forward(req, resp);

	}

}
