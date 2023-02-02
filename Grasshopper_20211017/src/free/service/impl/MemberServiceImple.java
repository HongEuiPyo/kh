package free.service.impl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import free.dao.face.MemberDao;
import free.dao.impl.MemberDaoImpl;
import free.dto.Member;
import free.service.face.MemberService;

public class MemberServiceImple implements MemberService {

	private MemberDao memberDao = new MemberDaoImpl();


	@Override
	public boolean login(Member member) {
		
		if(memberDao.selectCntMemberByUseridUserpw(JDBCTemplate.getConnection(), member)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Member getLoginMember(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Member member = new Member();
		
		member.setUser_email( req.getParameter("useremail") );
		member.setUser_password( req.getParameter("userpassword") );
		
		System.out.println("getLoginMember() : " + member);
		
		return member;
	}

	@Override
	public Member info(Member member) {
		return memberDao.selectMemberByUseremail(JDBCTemplate.getConnection(), member);
	}
	
	

}
