package main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main3")
public class MainPageController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main [GET]");
		
		boolean login = false;
		
		if(login) {
			
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/main3.jsp").forward(req, resp);
		
	}
	
	
}