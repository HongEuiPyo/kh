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
		
		Connection conn = JDBCTemplate.getConnection(); //DB연결객체
		
		//1. member_seq의 다음 값(nextval)을 조회하기
		int next = memberDao.selectNextUserno(conn);
		
		//2. 시퀀스 값을 param객체에 저장
		param.setUserno(next);
		
		//3. DB에 데이터 삽입
		int result = memberDao.insert(conn, param);
		
		if(result > 0) {
			JDBCTemplate.commit(conn); //커밋
		} else {
			JDBCTemplate.rollback(conn); //롤백
		}

		//4. 결과 반환
		return param;
	}

}



