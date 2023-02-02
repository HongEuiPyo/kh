package service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public Dept getDeptInfo(int deptno) {
		
		//Connection 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//부서정보 조회
		Dept info = deptDao.selectByDeptno(conn, deptno);
		
		return info;
	}
	
	@Override
	public void register(Dept newDept) {
		
		// Connection 객체
		Connection conn = JDBCTemplate.getConnection();
		
		// 신규 부서정보 삽입하기
		int res = deptDao.insertDept(conn, newDept);
		
		if( res == 0 ) { // insert 실패
			JDBCTemplate.rollback(conn);
		} else if ( res == 1) { // insert 실패
			JDBCTemplate.commit(conn);
		}
	}
}
