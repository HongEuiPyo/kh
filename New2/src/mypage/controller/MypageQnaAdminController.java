package mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypage.dto.Qna_board;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageAdminController
 */
@WebServlet("/qna/admin")
public class MypageQnaAdminController extends MypageServiceImpl {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Qna_board> boardList = mypageService.getListQnaBoard();

		HttpSession session = req.getSession();

		session.setAttribute("boardList", boardList);

		req.getRequestDispatcher("/WEB-INF/views/my/qnaAdmin.jsp").forward(req, resp);
	}

}
