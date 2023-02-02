package free.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import free.dao.face.ShoppingBoardDao;
import free.dao.impl.ShoppingBoardDaoImpl;
import free.dto.Shopping_board;
import free.service.face.ShoppingService;
import free.util.ShoppingPaging;

public class ShoppingServiceImpl implements ShoppingService {

	private ShoppingBoardDao shoppingdao = new ShoppingBoardDaoImpl();
	
	@Override
	public List<Shopping_board> getList() {
		
		return shoppingdao.getList(JDBCTemplate.getConnection());
	}

	@Override
	public List<Shopping_board> getList(HttpServletRequest req, ShoppingPaging paging) {
		String category = req.getParameter("category");
		Connection conn = JDBCTemplate.getConnection();
		List<Shopping_board> shoppingBoard = null;
		
		if(category.equals("alchol")) {
			shoppingBoard = shoppingdao.getAlcholList(conn, paging);
		}
		if(category.equals("tool")) {
			shoppingBoard = shoppingdao.getToolList(conn, paging);
		}
		if(category.equals("food")){
			shoppingBoard = shoppingdao.getFoodList(conn, paging);
		}
		
		System.out.println("res: " + shoppingBoard);
		
		return shoppingBoard;
	}

	@Override
	public ShoppingPaging getPaging(HttpServletRequest req) {
		System.out.println("ShoppingServiceImpl.getPaging()");
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}else {
			System.out.println("[WARNING] curPage값이 null이거나 비어있습니다");
		}
		
		String category = req.getParameter("category");
		System.out.println("category: " + category);
		
		if(category.equals("food")) {
			category = "FOOD";
		}else if(category.equals("tool")) {
			category = "TO";
		}else {
			category = "AL";
		}
		
		int totalCount = shoppingdao.selectCntAll(JDBCTemplate.getConnection(), category);
		System.out.println("totalCount: " + totalCount);
		
		ShoppingPaging paging = new ShoppingPaging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public List<Shopping_board> getOrderedList(HttpServletRequest req) {
		String category = req.getParameter("category");
		System.out.println("category:" + category);
		String tmp = req.getParameter("order");
		System.out.println(tmp);
		
		String[] temp = req.getParameter("order").split("_");
		String col = temp[0];
		String orderby = temp[1];
	
		if(category.equals("food")) {
			category = "FOOD";
		}else if(category.equals("tool")) {
			category = "TO";
		}else {
			category = "AL";
		}
		
		List<Shopping_board> list = null;
		if(col.equals("name")) {
			col = "shopping_product_title";			
			list = shoppingdao.getOrderedListByProductTitle(JDBCTemplate.getConnection(), category, col, orderby);
		}else {
			col = "shopping_product_price";
			list = shoppingdao.getOrderedListByProducPrice(JDBCTemplate.getConnection(), category, col, orderby);
		}
		
		return list;
	}

	@Override
	public List<Shopping_board> Search(HttpServletRequest req) {
		String search = req.getParameter("search");
		
		return shoppingdao.getSearch(JDBCTemplate.getConnection(), search);
	}

}
