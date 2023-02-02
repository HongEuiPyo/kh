package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService{

	//DAO ��ü
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Emp> list() {
		System.out.println("EmpService - list() ȣ��");
		
		//Connection ��ü ���� - JDBCTemplate.java �̿�
		Connection conn = JDBCTemplate.getConnection();
		
		
		//Emp ���̺� ��ü ��ȸ - EmpDao �̿�
		List<Emp> list = empDao.selectAll(conn);
		
		//��ȸ ��� ��ȯ
		return list;
	}
	
	@Override
	public Emp detail(int empno) {
		System.out.println("EmpService - detail() ȣ��");
		System.out.println("EmpService - empno : " + empno);
		
		//Connection ��ü ����
		Connection conn = JDBCTemplate.getConnection();
		
		//empno�� �̿��Ͽ� ��� ���� ��ȸ
		Emp emp = empDao.selectByEmpno(conn, empno);
		
		//��ȸ��� ��ȯ
		return emp;
	}
	

	
	
}
