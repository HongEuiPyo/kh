package dao.face;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	/**
	 * ���̺� ��ü ���� ��ȸ�Ѵ�
	 * 
	 * @return ���̺��� ��ȸ�� ��ü ���
	 */
	public List<Emp> selectAll();
	
	
	
	/**
	 * �Ű������� ������ �μ���ȣ�� �ش��ϴ� ������� ��ȸ�Ѵ�
	 * 
	 * @param deptno - ��ȸ�� ����� �μ� ��ȣ
	 * @return �μ���ȣ�� ��ȸ�� ��� ���
	 */
	public List<Emp> selectByDeptno(int deptno);
	
	
	/**
	 * ���ο� ������� �����ϱ�
	 * 
	 * @param insertEmp - DB�� ������ �ű� ��� ���� DTO��ü
	 */
	public void insert(Emp insertEmp);



	/**
	 * �����ȣ�� �̿��Ͽ� ��� ���� ��ȸ�ϱ�
	 * 
	 * @param empno - ��ȸ�Ϸ��� ����� �����ȣ
	 * @return �����ȣ�� ��ȸ�� ����� ���� DTO��ü, ��ȸ ����� ������ null�� ��ȯ�Ѵ�
	 */
	public Emp selectByEmpno(int empno);
	
}






























