package ex;

import java.util.List;
import java.util.Scanner;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

//실행 클래스
public class EmpEx {
	
	//EmpDao 객체 생성 (DB 연결)
	private static EmpDao empDao = new EmpDaoImpl();
	
	
	public static void main(String[] args) {
		
		//DAO객체를 이용한 Emp테이블 전체 조회
		List<Emp> list = empDao.selectAll();
		
		//결과 출력
		for(Emp e : list) {
			System.out.println( e );
		}
		
		System.out.println("--------------------");
		
		//입력 객체
		Scanner sc = new Scanner(System.in);
		
		//부서번호 입력
		System.out.print("조회할 부서번호는? ");
		int deptno = sc.nextInt();
		
		//부서번호를 이용한 DB데이터 조회
		List<Emp> resList = empDao.selectByDeptno(deptno);
		
		//결과 출력
		for(Emp e : resList) {
			System.out.println( e );
		}
	
		System.out.println("--------------------");
		
		//사원번호, 사원이름, 부서번호 입력 받아서 DB에 삽입하기
		//	-> INSERT
		
		//삽입될 정보를 저장할 DTO객체
		Emp insertEmp = new Emp();
		
		//사원번호 입력
		System.out.print("사원 번호? ");
		insertEmp.setEmpno( sc.nextInt() );
		
		sc.nextLine(); //버퍼 비우기
		
		//사원이름 입력
		System.out.print("사원 이름? ");
		insertEmp.setEname( sc.nextLine() );
		
		//부서번호 입력
		System.out.print("부서 번호? ");
		insertEmp.setDeptno( sc.nextInt() );
		
//		System.out.println("TEST " + insertEmp);
		
		
		//DAO를 이용한 DB데이터 삽입
		empDao.insert( insertEmp );
		
		System.out.println("--------------------");
		
		//삽입된 사원정보를 조회해서 확인
		Emp resEmp = empDao.selectByEmpno( insertEmp.getEmpno() );
		
		
		if( resEmp == null ) {
			//조회된 결과가 없을 경우
			System.out.println("사원정보 입력 실패");
			
		} else {
			//조회된 결과가 있을 경우
			System.out.println("사원정보 입력 성공");
			
			System.out.println("<< DB에 추가된 사원 >>");
			System.out.println( resEmp );
			
		}
		
	}
}





















