package free.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import free.dao.face.ShoppingBoardDao;
import free.dto.ShoppingBoard;

public class ShoppingBoardDaoImpl implements ShoppingBoardDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<ShoppingBoard> getList(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		
		ShoppingBoard shoppingBoard = null;
		List<ShoppingBoard> shoppingBoardList= new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shoppingBoard = new ShoppingBoard();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shoppingBoardList.add(shoppingBoard);
				System.out.println(shoppingBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return shoppingBoardList;
	}

	@Override
	public List<ShoppingBoard> getAlcholList(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		sql += " WHERE shopping_category LIKE ?";
		
		ShoppingBoard shoppingBoard = null;
		List<ShoppingBoard> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "AL_%");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new ShoppingBoard();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shoppingBoardList.add(shoppingBoard);
				System.out.println(shoppingBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return shoppingBoardList;
	}

	@Override
	public List<ShoppingBoard> getToolList(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		sql += " WHERE shopping_category LIKE ?";
		
		ShoppingBoard shoppingBoard = null;
		List<ShoppingBoard> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "TO%");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new ShoppingBoard();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shoppingBoardList.add(shoppingBoard);
				System.out.println(shoppingBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return shoppingBoardList;
	}

	@Override
	public List<ShoppingBoard> getFoodList(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		sql += " WHERE shopping_category LIKE ?";
		
		ShoppingBoard shoppingBoard = null;
		List<ShoppingBoard> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "FOOD");
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new ShoppingBoard();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shoppingBoardList.add(shoppingBoard);
				System.out.println(shoppingBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return shoppingBoardList;
	}

}
