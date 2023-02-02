package dao.face;

import java.sql.Connection;

import dto.Dept;

public interface DeptDao {

	
	public Dept selectByDeptno(Connection conn, int deptno);
	
	/**
	 * ���޹��� ��ü�� �̿��Ͽ� �μ� ������ �����Ѵ�
	 * 
	 * @param conn - DB���� ��ü
	 * @param newDept - ���� ������ �� ������ ��ü
	 * @return
	 * 		0 - insert ����
	 * 		1 - insert ����
	 */
	public int insertDept(Connection conn, Dept newDept);
	
	
}
