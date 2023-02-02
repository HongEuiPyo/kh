package shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.dto.Shopping_board;
import free.service.face.ShoppingService;
import free.service.impl.ShoppingServiceImpl;
import free.util.Paging;


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
		
		Paging paging = shoppingService.getPaging(req);
		
		List<Shopping_board> shoppingBoardList = shoppingService.getList(req, paging);
		
		
		req.setAttribute("shoppingBoardList", shoppingBoardList);
		
		req.setAttribute("paging", paging);
		
		req.setAttribute("category", req.getParameter("category"));
		
		
		System.out.println("setAttribute()");
		req.getRequestDispatcher("/WEB-INF/views/shopping/shopping_list.jsp").forward(req, resp);
		
	}
	
}
