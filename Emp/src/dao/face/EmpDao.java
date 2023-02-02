package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {

	
	/**
	 * 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return 조회된 전체 Emp테이블의 목록을 List로 반환한다
	 */
	public List<Emp> selectAll(Connection conn);
	
	/**
	 *전달된 empno를 이용하여 사원정보를 조회한다 
	 *
	 * @param conn - DB연결 객체
	 * @param empno - 조회할 사원의 사원번호
	 * @return 조회된 사원의 정보를 Emp객체로 반환한다, 존재하지 않으면 null
	 */
	public Emp selectByEmpno(Connection conn, int empno);
}
