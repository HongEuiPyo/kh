package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {

	/**
	 * ��ü ��ȸ	
	 * @return ��ȸ�� ���̺��� ��ü ��
	 */
	public List<User> selectAll();
	
	
	/**
	 * ���ο� ������ ����
	 * @param insertUser - ���ԵǴ� User ���� ��ü
	 */
	public void insertUser(User insertUser);
	
	
	/**
	 * ������ idx�� ���� ���� ��ȸ
	 * 
	 * @param idx - ��ȸ�Ϸ��� ���� idx
	 * @return ��ȸ�� ������� ��ü, ��ȸ�� �����Ͱ� ������ null
	 */
	public User selectByIdx(int idx);
	
	
	/**
	 * �־��� idx�� �̿��Ͽ� ���� ������ �����Ѵ�
	 * 
	 * @param idx - �����Ϸ��� ������ idx ��ȣ
	 */
	public void deleteByIdx(int idx);
	
}
