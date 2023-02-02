package dao.face;

import java.sql.Connection;

import dto.Member;

public interface MemberDao {

	/**
	 * member_seq�� nextval�� ��ȯ�Ѵ�
	 * 
	 * @param conn - DB���ᰴü
	 * @return member_seq.nextval
	 */
	public int selectNextUserno(Connection conn);

	/**
	 * Member��ü�� ���� ���̺� �����Ѵ�
	 * 
	 * @param conn - DB���ᰴü
	 * @param param - ������ ���� ��ü
	 */
	public int insert(Connection conn, Member param);

}


