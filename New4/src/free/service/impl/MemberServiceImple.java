package free.service.impl;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import free.dao.face.MemberDao;
import free.dao.impl.MemberDaoImpl;
import free.dto.User_info;
import free.service.face.MemberService;

public class MemberServiceImple implements MemberService {

	private MemberDao memberDao = new MemberDaoImpl();


	@Override
	public boolean login(User_info member) {
		
		if(memberDao.selectCntMemberByUseridUserpw(JDBCTemplate.getConnection(), member)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User_info getLoginMember(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		User_info member = new User_info();
		
		member.setUser_email( req.getParameter("useremail") );
		member.setUser_password( req.getParameter("userpassword") );
		
		System.out.println("getLoginMember() : " + member);
		
		return member;
	}

	@Override
	public User_info info(User_info member) {
		return memberDao.selectMemberByUseremail(JDBCTemplate.getConnection(), member);
	}
	
	

}
