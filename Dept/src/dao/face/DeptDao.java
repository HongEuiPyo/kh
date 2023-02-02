package dao.face;

import java.sql.Connection;

import dto.Dept;

public interface DeptDao {

	
	public Dept selectByDeptno(Connection conn, int deptno);
	
	/**
	 * 전달받은 객체를 이용하여 부서 정보를 삽입한다
	 * 
	 * @param conn - DB연결 객체
	 * @param newDept - 새로 삽입할 붓 ㅓ정보 객체
	 * @return
	 * 		0 - insert 실패
	 * 		1 - insert 성공
	 */
	public int insertDept(Connection conn, Dept newDept);
	
	
}
