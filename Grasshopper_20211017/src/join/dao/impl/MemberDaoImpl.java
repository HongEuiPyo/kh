package join.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import join.dao.face.MemberDao;
import join.dto.Member;

public class MemberDaoImpl implements MemberDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public int insert(Connection conn, Member info) {
		
		//쿼리작성
		String sql = "";
		sql += "INSERT INTO user_info";
		sql += " (user_no, user_email, user_password, user_point";
		sql += " , user_name, user_check, user_nickname, user_birth)";
		sql += " VALUES(userInfo_seq.nextval,?, ?, 0, ?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, info.getUser_email());
			ps.setString(2, info.getUser_password());
			ps.setString(3, info.getUser_name());
			ps.setInt(4, info.getUser_check());
			ps.setString(5, info.getUser_nickname());
			ps.setString(6, info.getUser_birth());
			
			res = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		return res;
	}


	
	
	@Override
	public Member selectByUser_info(Connection conn, Member info) {
		
		System.out.println("info값 확인" + info);
		
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += "   WHERE user_email = ?";
		
		Member member = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, info.getUser_email());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				
				member.setUser_no( rs.getInt("user_no"));
				member.setUser_email( rs.getString("user_email"));
				member.setUser_birth( rs.getString("user_birth"));
				member.setUser_point( rs.getInt("user_point"));
				member.setUser_name( rs.getString("user_name"));
				member.setUser_birth( rs.getString("user_birth"));
				member.setUser_check( rs.getInt("user_check"));
				member.setUser_nickname( rs.getString("user_nickname"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
				
		return member;
	}

	
	
	@Override
	public int selectByUser_email(Connection conn, Member info) {
		String sql ="";
		sql += "SELECT count(*) FROM user_info";
		sql += "  WHERE user_email = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString( 1, info.getUser_email());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	@Override
	public int selectByUser_nickname(Connection conn, Member info) {
		
		String sql ="";
		sql += "SELECT count(*) FROM user_info";
		sql += "  WHERE user_nickname = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString( 1, info.getUser_nickname());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	
	
	
	
}