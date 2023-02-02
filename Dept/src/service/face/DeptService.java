package service.face;

import dto.Dept;

public interface DeptService {

	/**
	 * �μ� ���� ��ȸ�ϱ�
	 * �־��� �μ���ȣ�� �̿��Ͽ� �μ������� ��ȸ�ϰ� DTO��ü�� ��ȯ�Ѵ�
	 * 
	 * @param deptno - ��ȸ�� �μ� ��ȣ
	 * @return ��ȸ�� �μ������� ������ ��ü, ������ null
	 */
	public Dept getDeptInfo(int deptno);
	
	/**
	 * �ű� �μ� ���
	 * 
	 * @param newDept - ����� �ű� �μ� ���� ��ü
	 */
	public void register(Dept newDept);
}
