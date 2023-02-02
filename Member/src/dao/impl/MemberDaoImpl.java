package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	private PreparedStatement ps = null; //SQL���� ��ü
	private ResultSet rs = null; //��� ���� ��ü

	@Override
	public int selectNextUserno(Connection conn) {
		
		String sql = "";
		sql += "SELECT member_seq.nextval AS next FROM dual";
		
		int next = 0; //����� ������ ����
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next(); //��ȸ�� ù �� ��� ã��
			
			next = rs.getInt("next");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return next;
	}

	@Override
	public int insert(Connection conn, Member param) {
		
		String sql = "";
		sql += "INSERT INTO member(userno, userid, nick, email)";
		sql += " VALUES( ?, ?, ?, ? )";
		
		int result = 0; //INSERT ��� ���� ����
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, param.getUserno());
			ps.setString(2, param.getUserid());
			ps.setString(3, param.getNick());
			ps.setString(4, param.getEmail());
			
			//INSERT ����
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps); //�ڿ� ����
		}
		
		//INSERT ���� ��� ��ȯ
		return result;
		
	}

}















