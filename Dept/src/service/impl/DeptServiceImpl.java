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
		
		//Connection ��ü
		Connection conn = JDBCTemplate.getConnection();
		
		//�μ����� ��ȸ
		Dept info = deptDao.selectByDeptno(conn, deptno);
		
		return info;
	}
	
	@Override
	public void register(Dept newDept) {
		
		// Connection ��ü
		Connection conn = JDBCTemplate.getConnection();
		
		// �ű� �μ����� �����ϱ�
		int res = deptDao.insertDept(conn, newDept);
		
		if( res == 0 ) { // insert ����
			JDBCTemplate.rollback(conn);
		} else if ( res == 1) { // insert ����
			JDBCTemplate.commit(conn);
		}
	}
}
