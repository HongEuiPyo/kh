package controller;

import java.util.Scanner;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptController {

	// 서비스 객체
	private static DeptService deptService = new DeptServiceImpl();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("조회할 부서는? ");
		int deptno = sc.nextInt();
		
		// 부서정보 조회
		Dept info = deptService.getDeptInfo(deptno);
		
		if( info == null ) {
			System.out.println("조회되는 부서가 없습니다");
		} else {
			System.out.println( info );
		}
		
		System.out.println("\n---새로운 부서정보 삽입------");
		
		Dept newDept = new Dept();
		
		System.out.print("부서번호? ");
		newDept.setDeptno( sc.nextInt() );
		
		sc.nextLine(); // 버퍼 비움
		System.out.print("부서 이름? ");
		newDept.setDname( sc.nextLine());

		System.out.print("위치? ");
		newDept.setLoc( sc.nextLine());
		
		// 신규부서 등록
		deptService.register( newDept );
		
		// 삽입한 부서 확인
		//	삽입에 사용한 newDept객체의 deptno을 이용한다
		Dept insertResult = deptService.getDeptInfo(newDept.getDeptno());
		
		System.out.println(">> 삽입된 부서 : " + insertResult);
	}
	
}
