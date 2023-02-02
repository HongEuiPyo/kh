package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {

	
	/**
	 * ���̺� ��ü ��ȸ
	 * 
	 * @param conn - DB���� ��ü
	 * @return ��ȸ�� ��ü Emp���̺��� ����� List�� ��ȯ�Ѵ�
	 */
	public List<Emp> selectAll(Connection conn);
	
	/**
	 *���޵� empno�� �̿��Ͽ� ��������� ��ȸ�Ѵ� 
	 *
	 * @param conn - DB���� ��ü
	 * @param empno - ��ȸ�� ����� �����ȣ
	 * @return ��ȸ�� ����� ������ Emp��ü�� ��ȯ�Ѵ�, �������� ������ null
	 */
	public Emp selectByEmpno(Connection conn, int empno);
}
