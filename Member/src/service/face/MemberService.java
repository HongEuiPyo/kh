package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	/**
	 * �����Ķ���� userid, nick, email�� ��ü�� ��ȯ�Ѵ�
	 * 
	 * @param req - ��û ���� ��ü
	 * @return ���޵� �����͸� Member��ü�� ��Ƽ� ��ȯ
	 */
	public Member getParam(HttpServletRequest req);

	/**
	 * ���޵� �����͸� �̿��Ͽ� ȸ������ ó��
	 * 
	 * @param param - Ŭ���̾�Ʈ�κ��� ���޵� ȸ�� ���� ��ü
	 * @return DB�� ���� �Ϸ�� ȸ�� ���� ��ü
	 */
	public Member join(Member param);

}









