package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {

	/**
	 * 사원의 전체 목록을 조회한다
	 * 
	 * @return 조회된 전체 사원들의 목록을 java.util.List로 반환한다
	 */
	public List<Emp> list();
	
	
	/**
	 * 사원 정보를 상세 조회한다
	 * 
	 * @param empno - 조회할 사원번호
	 * @return 조회된 사원의 상세 정보, 모든 컬럼의 값을 가지고 있다
	 * 	조회되는 사원이 없다면 null반환
	 */
	public Emp detail(int empno);
}
