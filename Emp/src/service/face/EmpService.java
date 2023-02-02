package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {

	/**
	 * ����� ��ü ����� ��ȸ�Ѵ�
	 * 
	 * @return ��ȸ�� ��ü ������� ����� java.util.List�� ��ȯ�Ѵ�
	 */
	public List<Emp> list();
	
	
	/**
	 * ��� ������ �� ��ȸ�Ѵ�
	 * 
	 * @param empno - ��ȸ�� �����ȣ
	 * @return ��ȸ�� ����� �� ����, ��� �÷��� ���� ������ �ִ�
	 * 	��ȸ�Ǵ� ����� ���ٸ� null��ȯ
	 */
	public Emp detail(int empno);
}
