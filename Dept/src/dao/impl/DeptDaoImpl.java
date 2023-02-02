package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.DeptDao;
import dto.Dept;


public class DeptDaoImpl implements DeptDao {

	@Override
	public Dept selectByDeptno(Connection conn, int deptno) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//SQL �ۼ�
		String sql = "";
		sql += "SELECT * FROM dept";
		sql += " WHERE deptno = ?";
		
		// ��ȸ�� ��� ���� ��ü
		Dept dept = null;
		
		
		try {
			//���� ���� ��ü
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			
			//���� ���� �� ��� ����
			rs = ps.executeQuery();
			
			//��� ó��
			if( rs.next() ) {
				dept = new Dept();
				
				dept.setDeptno( rs.getInt("deptno"));
				dept.setDname( rs.getString("dname"));
				dept.setLoc( rs.getString("loc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ�����
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		// ��ȸ��� ��ȯ
		return dept;		
	}	
	@Override
	public int insertDept(Connection conn, Dept newDept) {
		
		// SQL ���� ��ü
		PreparedStatement ps = null;
		
		// SQL ����
		String sql = "";
		sql += "INSERT INTO dept ( deptno, dname, loc )";
		sql += " VALUES( ?, ?, ? )";
		
		// ������� ���� ��
		int res = 0;
		
		try {
			// SQL ���� ��ü
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newDept.getDeptno());
			ps.setString(2,  newDept.getDname());
			ps.setString(3, newDept.getLoc());
			
			// SQL ����
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ڿ� ����
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	
	
	
	
}
