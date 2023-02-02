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

	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn = null; //DB연결객체
	private static PreparedStatement ps = null; //SQL수행객체
	private static ResultSet rs = null; //조회결과객체
	
	//생성자
	public UserDaoImpl() {
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// DB 연결
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
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " ORDER BY idx";
		
		// SQL 수행 결과를 저장할 List
		List<User> userList = new ArrayList<>();
		
			try {
				// SQL 수행
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				// 결과 처리
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
					// 자원 해제
					if(rs!=null && !rs.isClosed()) rs.close();
					if(ps!=null && !ps.isClosed()) ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					
		// 최종 결과 리턴
		return userList;
		
		
	}

	@Override
	public void insertUser(User insertUser) {
		
		// SQL 작성
		String sql = "";
		sql += "INSERT INTO userTest( idx, userid, name )";
		sql += " VALUES (userTest_SQ.nextval, ?, ? )";
		
		try {
			// SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			// SQL의 ? 채우기
			ps.setString(1, insertUser.getUserid());
			ps.setString(2, insertUser.getName());
			
			// SQL 수행
			ps.executeUpdate();
			
			// 예외없이 코드 실행했을 경우 커밋
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			// 예외가 발생했을 경우 롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			
			try {
				// 자원 해제
				if(ps!=null && !ps.isClosed()) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public User selectByIdx(int idx) {
		
		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " WHERE idx = ?";
		
		// 조회 결과를 저장할 DTO 객체
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
			// 자원 해제
			try {
				if(rs!=null && rs.isClosed()) rs.close();
				if(ps!=null && ps.isClosed()) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// 최종 결과 반환		
		return user;
	}

	@Override
	public void deleteByIdx(int idx) {
		// SQL 작성
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