package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.OfficialCocktail;
import service.face.MainService;
import service.impl.MainServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main [GET]");
		
		// 로그인 정보 - get
		boolean login = false;
		
		if(login) {
			
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main [POST]");
		
		
		//	베스트 칵테일 정보 - post
		MainService mainService = new MainServiceImpl();
		
		// New DTO
		OfficialCocktail best1 = null;
		OfficialCocktail best2 = null;
		OfficialCocktail best3 = null;
		
		
		// DTO <- ServiceImpl 의 getBest
		best1 = mainService.getBest1(req);
		best2 = mainService.getBest2(req);
		best3 = mainService.getBest3(req);
		
		
		//	Session에 값 저장
		HttpSession session = req.getSession();
		session.setAttribute("best1_name", best1.getOfficial_cocktail_name());
		session.setAttribute("best1_attach", best1.getAttach_no());
		
		session.setAttribute("best2_name", best2.getOfficial_cocktail_name());
		session.setAttribute("best2_attach", best2.getAttach_no());
		
		session.setAttribute("best3_name", best3.getOfficial_cocktail_name());
		session.setAttribute("best3_attach", best3.getAttach_no());
	}
	
	
}
