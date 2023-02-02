package controller;

import java.util.Scanner;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptController {

	// ���� ��ü
	private static DeptService deptService = new DeptServiceImpl();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ȸ�� �μ���? ");
		int deptno = sc.nextInt();
		
		// �μ����� ��ȸ
		Dept info = deptService.getDeptInfo(deptno);
		
		if( info == null ) {
			System.out.println("��ȸ�Ǵ� �μ��� �����ϴ�");
		} else {
			System.out.println( info );
		}
		
		System.out.println("\n---���ο� �μ����� ����------");
		
		Dept newDept = new Dept();
		
		System.out.print("�μ���ȣ? ");
		newDept.setDeptno( sc.nextInt() );
		
		sc.nextLine(); // ���� ���
		System.out.print("�μ� �̸�? ");
		newDept.setDname( sc.nextLine());

		System.out.print("��ġ? ");
		newDept.setLoc( sc.nextLine());
		
		// �űԺμ� ���
		deptService.register( newDept );
		
		// ������ �μ� Ȯ��
		//	���Կ� ����� newDept��ü�� deptno�� �̿��Ѵ�
		Dept insertResult = deptService.getDeptInfo(newDept.getDeptno());
		
		System.out.println(">> ���Ե� �μ� : " + insertResult);
	}
	
}
