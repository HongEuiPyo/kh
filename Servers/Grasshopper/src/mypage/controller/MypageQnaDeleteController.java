package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.dto.Qna_board;
import mypage.service.face.MypageService;
import mypage.service.impl.MypageServiceImpl;

/**
 * Servlet implementation class MypageQnaDeleteController
 */
@WebServlet("/qna/delete")
public class MypageQnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Qna_board board = mypageService.getBoardno(req);

		mypageService.deleteQna(board);

		// 목록으로 리다이렉트
		resp.sendRedirect("/qna/list");

	}

}
