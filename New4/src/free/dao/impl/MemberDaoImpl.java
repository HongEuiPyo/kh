package free.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import free.dao.face.MemberDao;
import free.dto.User_info;

public class MemberDaoImpl implements MemberDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public User_info login(Connection conn, User_info member) {
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += " WHERE user_email = ? AND user_password = ?";



		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUser_email());
			ps.setString(2, member.getUser_password());

			rs = ps.executeQuery();


			while(rs.next()) {
				member.setUser_nickname(rs.getString("user_nickname"));				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}


	
	@Override public int selectCntMemberByUseridUserpw(Connection conn, User_info
			member) { String sql = ""; sql += "SELECT count(*) FROM user_info"; sql +=
			" WHERE 1=1"; sql += "	AND user_email = ?"; sql +=
			"	AND user_password = ?";

			int res = -1;

			try { 
				ps = conn.prepareStatement(sql);
				ps.setString(1,member.getUser_email()); 
				ps.setString(2, member.getUser_password());

				rs = ps.executeQuery();

				while(rs.next()) { 
					res = rs.getInt(1); 
				} 
			} catch (SQLException e) { // TODO
				 e.printStackTrace(); }
			finally {
				JDBCTemplate.close(rs); JDBCTemplate.close(ps); 
			}

			return res; 
	}


	@Override
	public User_info selectMemberByUseremail(Connection conn, User_info member) {
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM user_info";
		sql += " WHERE 1=1";
		sql += "	AND user_email = ?";

		//조회결과를 저장할 객체
		User_info result = null;

		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체

			ps.setString(1, member.getUser_email());

			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장

			//조회 결과 처리
			while(rs.next()) {
				result = new User_info();

				result.setUser_email( rs.getString("user_email") );
				result.setUser_password( rs.getString("user_password") );
				result.setUser_nickname( rs.getString("user_nickname") );
				result.setUser_no(rs.getInt("user_no"));
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
	public User_info selectUser_nickByUserid(Connection conn, User_info member) {
		String sql = "";
		sql += "SELECT user_nickname FROM user_info";
		sql += " WHERE user_no = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getUser_no());

			rs = ps.executeQuery();

			while(rs.next()) {
				member.setUser_nickname(rs.getString("user_nickname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		return member;
	}

}
