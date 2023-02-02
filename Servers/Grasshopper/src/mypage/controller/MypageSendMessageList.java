package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		System.out.println(user_no);

		List<Message> message = mypageService.sendMessageSelect(user_no);

		session.setAttribute("message", message);

		List<User_info> user_info = mypageService.getList();

		session.setAttribute("user_info", user_info);

		req.getRequestDispatcher("/WEB-INF/views/my/mypageSendMessageList.jsp").forward(req, resp);

	}

}
