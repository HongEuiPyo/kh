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
@WebServlet("/main2")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/main [GET]");
		
		boolean login = false;
		
		req.getRequestDispatcher("/WEB-INF/views/main2.jsp").forward(req, resp);
		
	}
	
	
}