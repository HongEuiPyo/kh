package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * 테이블 전체 행을 조회한다
	 * 
	 * @return 테이블을 조회한 전체 목록
	 */
	public List<Emp> selectAll();
	
	
	
	/**
	 * 매개변수로 지정된 부서번호에 해당하는 사원들을 조회한다
	 * 
	 * @param deptno - 조회에 사용할 부서 번호
	 * @return 부서번호로 조회된 사원 목록
	 */
	public List<Emp> selectByDeptno(int deptno);
	
	
	/**
	 * 새로운 사원정보 삽입하기
	 * 
	 * @param insertEmp - DB에 삽입할 신규 사원 정보 DTO객체
	 */
	public void insert(Emp insertEmp);



	/**
	 * 사원번호를 이용하여 사원 정보 조회하기
	 * 
	 * @param empno - 조회하려는 사원의 사원번호
	 * @return 사원번호로 조회한 사원의 정보 DTO객체, 조회 대상이 없으면 null을 반환한다
	 */
	public Emp selectByEmpno(int empno);
	
}






























