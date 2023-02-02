package shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.ShoppingBoard;
import free.service.face.ShoppingService;
import free.service.impl.ShoppingServiceImpl;

/**
 * Servlet implementation class ShoppingListController
 */
@WebServlet("/shopping/list")
public class ShoppingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShoppingService shoppingService  = new ShoppingServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/shopping/list [GET]");
		
		List<ShoppingBoard> shoppingBoardList = shoppingService.getList(req);
		
		
		req.setAttribute("shoppingBoardList", shoppingBoardList);
		
		System.out.println("setAttribute()");
		req.getRequestDispatcher("/WEB-INF/views/shopping/shopping_list.jsp").forward(req, resp);
		
	}
	
}
