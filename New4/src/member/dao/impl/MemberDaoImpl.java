package member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import member.dao.face.MemberDao;
import member.dto.User_info;
import member.util.Paging;

public class MemberDaoImpl implements MemberDao {

	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	@Override
	public int selectCntMemberByUseridUserpw(Connection conn, User_info user_info) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM user_info";
		sql += " WHERE 1=1";
		sql += "	AND user_email = ?";
		sql += "	AND user_password = ?";
		
		//결과 저장할 변수
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, user_info.getUser_email());
			ps.setString(2, user_info.getUser_password());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return cnt;
	}

	@Override
	public User_info selectMemberByUserid(Connection conn, User_info user_info) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += " WHERE 1=1";
		sql += "	AND user_email = ?";
		
		//조회결과를 저장할 객체
		User_info result = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
//			ps.setInt(1, user_info.getUser_no());
			ps.setString(1, user_info.getUser_email());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				result = new User_info();
				
				result.setUser_no( rs.getInt("user_no") );
				result.setUser_email(rs.getString("user_email"));
//				result.setUser_password( rs.getString("user_password") );
				result.setUser_point(rs.getInt("user_point"));
				result.setUser_name(rs.getString("user_name"));
//				result.setUser_birth(rs.getInt("user_birth"));
//				result.setUser_birth(rs.getDate("user_birth"));
				result.setUser_birth(rs.getString("user_birth"));
				result.setUser_check(rs.getInt("user_check"));
				result.setUser_nickname( rs.getString("user_nickname") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return result;
	}

	@Override
	public int insert(Connection conn, User_info user_info) {
		
		//쿼리작성
		String sql = "";
		sql += "INSERT INTO member ( user_no, user_password, user_nickname, user_point, user_name, user_birth, user_check, user_email )";
		sql += " VALUES( ?, ?, ?, ?, ?, ?, ? ,? )";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
				
			//시퀸스 nextvalue로 줘야하는게 아닌지?
			ps.setInt(1, user_info.getUser_no());
			ps.setString(2, user_info.getUser_email());
			ps.setString(3, user_info.getUser_password());
			ps.setInt(4, user_info.getUser_point());
			ps.setString(5, user_info.getUser_name());
			
//			ps.setInt(6, user_info.getUser_birth());
//			ps.setDate(6, new java.sql.Date(user_info.getUser_birth().getTime()));
			ps.setString(6, user_info.getUser_birth());
			
			ps.setInt(7, user_info.getUser_check());
			ps.setString(8, user_info.getUser_nickname());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int updatePassword(Connection conn, User_info user_info) {
		
		//쿼리작성
		String sql = "";
		sql += "UPDATE user_info SET user_password = ?";
		sql += " WHERE user_no = ?";
				
		int res = 0;
		
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, user_info.getUser_password());
			ps.setInt(2, user_info.getUser_no());
			
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	@Override
	public int selectUsernoByEmail(Connection conn, String user_email) {

		//SQL 작성
		String sql = "";
		sql += "SELECT user_no FROM user_info";
		sql += "	WHERE user_email = ?";
		
		//조회결과를 저장할 객체
		int user_no  = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, user_email);
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				user_no = rs.getInt("user_no");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return user_no;
	}

	@Override
	public List getMemberList(Connection Conn, User_info user_info) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += " WHERE 1=1";
				
		//조회결과를 저장할 객체
		List memberList = new ArrayList();
				
		try {
			ps = Conn.prepareStatement(sql); //SQL수행 객체
				
			ps.setInt(1, user_info.getUser_no());
			ps.setString(1, user_info.getUser_email());
					
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
			//조회 결과 처리
			while(rs.next()) {
				
				User_info ad = new User_info(); 
				
				ad.setUser_no( rs.getInt("user_no") );
				ad.setUser_email(rs.getString("user_email"));
				ad.setUser_password( rs.getString("user_password") );
				ad.setUser_point(rs.getInt("user_point"));
				ad.setUser_name(rs.getString("user_name"));
//				ad.setUser_birth(rs.getInt("user_birth"));
				ad.setUser_birth(rs.getString("user_birth"));
				ad.setUser_check(rs.getInt("user_check"));
				ad.setUser_nickname( rs.getString("user_nickname") );
						
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		//최종 결과 반환
		return memberList;
			
		
		
	}			
	
	@Override
	public List<User_info> selectAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += " ORDER BY user_no";
		
		//결과 저장할 List
		List<User_info> memberList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				
				User_info ad = new User_info(); 
				
				ad.setUser_no( rs.getInt("user_no") );
				ad.setUser_email(rs.getString("user_email"));
				ad.setUser_password( rs.getString("user_password") );
				ad.setUser_point(rs.getInt("user_point"));
				ad.setUser_name(rs.getString("user_name"));
//				ad.setUser_birth(rs.getInt("user_birth"));
				ad.setUser_birth(rs.getString("user_birth"));
				ad.setUser_check(rs.getInt("user_check"));
				ad.setUser_nickname( rs.getString("user_nickname") );
						
				//리스트에 결과값 저장
				memberList.add(ad);
			}
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return memberList;
	}
	
	@Override
	public List<User_info> selectAll(Connection conn, Paging paging) {
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			user_no, user_email, user_password";
		sql += "			, user_point, user_name, user_birth, user_check, user_nickname";
		sql += "		FROM User_info";
		sql += "		ORDER BY user_no DESC";
		sql += "	) B";
		sql += " ) User_info";
		sql += " WHERE rnum BETWEEN ? AND ?";

		//결과 저장할 List
		List<User_info> memberList = new ArrayList<>(); 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				User_info ad = new User_info(); 
				
				ad.setUser_no( rs.getInt("user_no") );
				ad.setUser_email(rs.getString("user_email"));
				ad.setUser_password( rs.getString("user_password") );
				ad.setUser_point(rs.getInt("user_point"));
				ad.setUser_name(rs.getString("user_name"));
//				ad.setUser_birth(rs.getInt("user_birth"));
				ad.setUser_birth(rs.getString("user_birth"));
				ad.setUser_check(rs.getInt("user_check"));
				ad.setUser_nickname( rs.getString("user_nickname") );
						
				//리스트에 결과값 저장
				memberList.add(ad);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return memberList;
	}

	@Override
	public int selectCntAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM User_info";
		
		//총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

	

	
}
