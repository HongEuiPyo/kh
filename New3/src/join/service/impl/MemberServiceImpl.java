package join.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import join.dao.face.MemberDao;
import join.dao.impl.MemberDaoImpl;
import join.dto.Member;
import join.service.face.MemberService;

public class MemberServiceImpl implements MemberService {
	
	//MemberJoinDao객체
	MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Member getJoinMember(HttpServletRequest req) {
		
		//저장할 User_Info객체
		Member info = new Member();
		
		info.setUser_name( req.getParameter("username"));
		info.setUser_birth( req.getParameter("userbirth"));
		info.setUser_email( req.getParameter("userid") );
		info.setUser_password( req.getParameter("userpw"));
		info.setUser_nickname( req.getParameter("usernick"));
		info.setUser_check( Integer.parseInt(req.getParameter("subsmail")) );
		
		return info;
	}

	
	
//	@Override
//	public void join(User_Info info) {
//		Connection conn = JDBCTemplate.getConnection();
//	
//		if( memberJoinDao.insert(conn,info) > 0 ) {
//			JDBCTemplate.commit(conn);
//			
//		} else {
//			JDBCTemplate.rollback(conn);
//		}
//	}

	
	public boolean join(Member info) {
		Connection conn = JDBCTemplate.getConnection();
		
		if( memberDao.insert(conn,info) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
			
		} else {
			JDBCTemplate.rollback(conn);
			return false;
		}
	}


	@Override 
	public Member getMember(Member info) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = memberDao.selectByUser_info(conn, info);
		
		
		return member;
	}
	
	@Override
	public Member getDuplChkId(HttpServletRequest req) {
		
		//저장할 User_Info객체
		Member info = new Member();
		
		info.setUser_email( req.getParameter("userid") );
		
		return info;
	}
	
	@Override
	public Member getDuplChkNick(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//저장할 User_Info객체
		Member info = new Member();
		
		info.setUser_nickname( req.getParameter("usernick") );
		
		return info;
	}
	
	@Override
	public int checkDuplicationEmail(Member info) {
		
		int res = memberDao.selectByUser_email(JDBCTemplate.getConnection(),info);
		
		if(res == 0) {
			System.out.println("동일 아이디 없음");
		} else if(res == 1) {
			System.out.println("중복 아이디. 가입 불가");
		}
		return res;
		
	}
	
	@Override
	public int checkDuplicationNick(Member info) {
		
		int res =  memberDao.selectByUser_nickname(JDBCTemplate.getConnection(),info);
		
		if(res == 0) {
			System.out.println("동일 닉네임 없음");
		} else if(res == 1) {
			System.out.println("동일 닉네임 있음, 사용불가");
		}
		
		return res;
	}
	
	@Override
	public int checkDuplNickEmail(Member info) {
		
		int duplnick = memberDao.selectByUser_nickname(JDBCTemplate.getConnection(),info);
		int duplemail = memberDao.selectByUser_email(JDBCTemplate.getConnection(),info);
		
		int res = 0;
		
		if( duplnick == 0 && duplemail == 0) {
			res = 0;
		} else if( duplnick == 1 || duplemail == 1 ) {
			res = 1;
		} else {
			res = 1;
		}
	
		return res;
	}

}
