package free.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import free.dao.face.ShoppingBoardDao;
import free.dao.impl.ShoppingBoardDaoImpl;
import free.dto.ShoppingBoard;
import free.service.face.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {

	private ShoppingBoardDao shoppingdao = new ShoppingBoardDaoImpl();
	
	@Override
	public List<ShoppingBoard> getList() {
		
		return shoppingdao.getList(JDBCTemplate.getConnection());
	}

	@Override
	public List<ShoppingBoard> getList(HttpServletRequest req) {
		String category = req.getParameter("category");
		Connection conn = JDBCTemplate.getConnection();
		List<ShoppingBoard> shoppingBoard = null;
		
		if(category.equals("alchol")) {
			shoppingBoard = shoppingdao.getAlcholList(conn);
		}
		if(category.equals("tool")) {
			shoppingBoard = shoppingdao.getToolList(conn);
		}
		if(category.equals("food")){
			shoppingBoard = shoppingdao.getFoodList(conn);
		}
		
		System.out.println("res: " + shoppingBoard);
		
		return shoppingBoard;
	}

}
