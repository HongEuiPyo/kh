

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao{

	@Override
	public List<Emp> selectAll( Connection conn ) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "";
		sql += "	empno, ename, job, mgr";
		sql += "	, hiredate, sal, comm, deptno";
		sql += " FROM emp";
		sql += " ORDER BY empno";

		//--- 조회 결과를 저장할 List ---
		List<Emp> list = new ArrayList<Emp>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while(rs.next()) {
				Emp emp = new Emp();

				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));

				list.add(emp);

				
			}


		} catch (SQLException e) {
		  e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//--- 최종 조회 결과 반환 ---
		return list;
	}
	
	@Override
	public Emp selectByEmpno(Connection conn, int empno) {
		System.out.println("EmpDao - selectByEmpno() 호출");
		System.out.println("EmpDao - empno : " + empno);
		
		PreparedStatement ps = null; //SQL수행 객체
		ResultSet rs = null; //결과 집합 객체
		
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += "	empno, ename, job, mgr";
		sql += "	, hiredate, sal, comm, deptno";
		sql += " FROM emp";
		sql += " WHERE empno = ?";
		
		//조회된 결과를 저장할 객체
		Emp res = null;
		
		
		try {
			//--- SQL수행 객체 ---
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			
			//--- SQL 수행 및 결과 반환 ---
			rs = ps.executeQuery();
			
			//--- 결과 처리 ---
				res = new Emp();
				
				res.setEmpno(rs.getInt("empno"));
				res.setEname(rs.getString("ename"));
				res.setJob(rs.getString("job"));
				res.setMgr(rs.getInt("mgr"));
				res.setHiredate(rs.getDate("hiredate"));
				res.setSal(rs.getDouble("sal"));
				res.setComm(rs.getDouble("comm"));
				res.setDeptno(rs.getInt("deptno"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//--- 최종 조회 결과 반환 ---
		return res;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}