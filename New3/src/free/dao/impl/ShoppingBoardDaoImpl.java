package free.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import free.dao.face.ShoppingBoardDao;
import free.dto.Shopping_board;
import free.util.Paging;
import free.util.ShoppingPaging;

public class ShoppingBoardDaoImpl implements ShoppingBoardDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Shopping_board> getList(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		
		Shopping_board shoppingBoard = null;
		List<Shopping_board> shoppingBoardList= new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
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
	public List<Shopping_board> getAlcholList(Connection conn, ShoppingPaging paging) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, sp.* FROM shopping_board sp";
		sql += " 	WHERE shopping_category = ?";
		sql += ") WHERE rnum BETWEEN ? AND ?";
		
		Shopping_board shoppingBoard = null;
		List<Shopping_board> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "AL");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
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
	public List<Shopping_board> getToolList(Connection conn, ShoppingPaging paging) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, sp.* FROM shopping_board sp";
		sql += " 	WHERE shopping_category LIKE ?";
		sql += ") WHERE rnum BETWEEN ? AND ?";
		
		Shopping_board shoppingBoard = null;
		List<Shopping_board> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "TO");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
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
	public List<Shopping_board> getFoodList(Connection conn, ShoppingPaging paging) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, sp.* FROM shopping_board sp";
		sql += " 	WHERE shopping_category LIKE ?";
		sql += ") WHERE rnum BETWEEN ? AND ?";
		
		Shopping_board shoppingBoard = null;
		List<Shopping_board> shoppingBoardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "FOOD");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
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
	public int selectCntAll(Connection conn, String category) {
		String sql = "";
		sql += "SELECT count(*) FROM shopping_board";
		sql += " WHERE shopping_category = ?";
		
		int count = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		
		return count;
	}

	@Override
	public List<Shopping_board> getOrderedListByProductTitle(Connection conn, String category, String col, String orderby) {
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		sql += " WHERE shopping_category = ?";
		sql += " ORDER BY " + col + " " + orderby;
		
		List<Shopping_board> shopping_list = new ArrayList<>();
		Shopping_board shoppingBoard = null;
		
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shopping_list.add(shoppingBoard);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(rs);
		}
		
		
		
		
		return shopping_list;
	}

	@Override
	public List<Shopping_board> getOrderedListByProducPrice(Connection connection, String category, String col,
			String orderby) {
		
		String sql = "";
		sql += "SELECT * FROM shopping_board";
		sql += " WHERE shopping_category = ?";
		sql += " ORDER BY " + col + " " + orderby;
		
		List<Shopping_board> shopping_list = new ArrayList<>();
		Shopping_board shoppingBoard = null;
		
		
		
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, category);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shopping_list.add(shoppingBoard);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(rs);
		}
		
		return shopping_list;
	}

	@Override
	public List<Shopping_board> getSearch(Connection conn, String search) {
		String sql ="";
		sql += "SELECT * FROM  shopping_board";
		sql += " WHERE shopping_product_title LIKE ?";
		
		search = "%" + search + "%";
		
		List<Shopping_board> shopping_list = new ArrayList<>();
		Shopping_board shoppingBoard = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shoppingBoard = new Shopping_board();
				shoppingBoard.setShopping_product_no(rs.getInt("shopping_product_no"));
				shoppingBoard.setShopping_category(rs.getString("shopping_category"));
				shoppingBoard.setShopping_product_title(rs.getString("shopping_product_title"));
				shoppingBoard.setShopping_product_content(rs.getString("shopping_product_content"));
				shoppingBoard.setShopping_product_price(rs.getInt("shopping_product_price"));
				shoppingBoard.setShopping_product_link(rs.getString("shopping_product_link"));
				shoppingBoard.setShopping_img_link(rs.getString("shopping_img_link"));
				
				shopping_list.add(shoppingBoard);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(rs);
		}
		
		return shopping_list;
	}

}
