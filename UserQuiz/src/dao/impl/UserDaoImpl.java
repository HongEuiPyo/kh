package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.UserDao;
import dto.User;

public class UserDaoImpl implements UserDao{

	//OJDBC ����̹�
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB���� ����
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC ��ü
	private static Connection conn = null; //DB���ᰴü
	private static PreparedStatement ps = null; //SQL���ఴü
	private static ResultSet rs = null; //��ȸ�����ü
	
	//������
	public UserDaoImpl() {
		try {
			// ����̹� �ε�
			Class.forName(DRIVER);
			
			// DB ����
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			
//			conn.getAutoCommit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<User> selectAll() {
		// SQL �ۼ�
		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " ORDER BY idx";
		
		// SQL ���� ����� ������ List
		List<User> userList = new ArrayList<>();
		
			try {
				// SQL ����
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				// ��� ó��
				while(rs.next()) {
					User user = new User();
					
					user.setIdx(rs.getInt("idx"));
					user.setUserid(rs.getString("userid"));
					user.setName(rs.getString("name"));
					
					userList.add( user );
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					// �ڿ� ����
					if(rs!=null && !rs.isClosed()) rs.close();
					if(ps!=null && !ps.isClosed()) ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					
		// ���� ��� ����
		return userList;
		
		
	}

	@Override
	public void insertUser(User insertUser) {
		
		// SQL �ۼ�
		String sql = "";
		sql += "INSERT INTO userTest( idx, userid, name )";
		sql += " VALUES (userTest_SQ.nextval, ?, ? )";
		
		try {
			// SQL ���� ��ü
			ps = conn.prepareStatement(sql);
			
			// SQL�� ? ä���
			ps.setString(1, insertUser.getUserid());
			ps.setString(2, insertUser.getName());
			
			// SQL ����
			ps.executeUpdate();
			
			// ���ܾ��� �ڵ� �������� ��� Ŀ��
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			// ���ܰ� �߻����� ��� �ѹ�
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			
			try {
				// �ڿ� ����
				if(ps!=null && !ps.isClosed()) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public User selectByIdx(int idx) {
		
		// SQL �ۼ�
		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " WHERE idx = ?";
		
		// ��ȸ ����� ������ DTO ��ü
		User user = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  idx);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				user = new User();
				
				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ڿ� ����
			try {
				if(rs!=null && rs.isClosed()) rs.close();
				if(ps!=null && ps.isClosed()) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// ���� ��� ��ȯ		
		return user;
	}

	@Override
	public void deleteByIdx(int idx) {
		// SQL �ۼ�
		String sql = "";
		sql += "DELETE userTest";
		sql += " WHERE idx = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idx);
			
			ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if(ps!=null && ps.isClosed()) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}	