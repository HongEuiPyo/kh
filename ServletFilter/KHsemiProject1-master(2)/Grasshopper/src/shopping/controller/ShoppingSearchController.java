package shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import free.dto.Shopping_board;
import free.service.face.ShoppingService;
import free.service.impl.ShoppingServiceImpl;

/**
 * Servlet implementation class ShoppingSearchController
 */
@WebServlet("/shopping/search")
public class ShoppingSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService shoppingService = new ShoppingServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/shopping/search [GET]");
		
		resp.setContentType("application/json; charset=utf-8");
		
		List<Shopping_board> searchList =  shoppingService.Search(req);
		
		
		PrintWriter out = resp.getWriter();
		
		out.println(new Gson().toJson(searchList));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/shopping/search [POST]");
		
		doGet(req,resp);
	}

}
