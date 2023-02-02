package service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member getParam(HttpServletRequest req) {
		
		Member param = new Member();
		param.setUserid( req.getParameter("userid") );
		param.setNick( req.getParameter("nick") );
		param.setEmail( req.getParameter("email") );
		
		return param;
	}

	@Override
	public Member join(Member param) {
		
		Connection conn = JDBCTemplate.getConnection(); //DB���ᰴü
		
		//1. member_seq�� ���� ��(nextval)�� ��ȸ�ϱ�
		int next = memberDao.selectNextUserno(conn);
		
		//2. ������ ���� param��ü�� ����
		param.setUserno(next);
		
		//3. DB�� ������ ����
		int result = memberDao.insert(conn, param);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //Ŀ��
		} else {
			JDBCTemplate.rollback(conn); //�ѹ�
		}

		//4. ��� ��ȯ
		return param;
	}

}



