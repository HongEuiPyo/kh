package member.service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import member.dao.face.MemberDao;
import member.dao.impl.MemberDaoImpl;
import member.dto.User_info;
import member.service.face.MemberService;
import member.util.Paging;

public class MemberServiceImpl implements MemberService {

	//MemberDao 객체
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public User_info getLoginMember(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		User_info user_info = new User_info();
		
		user_info.setUser_email( req.getParameter("user_email") );
		user_info.setUser_password( req.getParameter("user_password") );
		
		return user_info;
	}

	@Override
	public boolean login(User_info user_info) {
		
		if( memberDao.selectCntMemberByUseridUserpw(JDBCTemplate.getConnection(), user_info) > 0 ) {
			return true; //로그인 성공
		} else {
			return false; //로그인 실패
		}
	}

	@Override
	public User_info info(User_info user_info) {
		return memberDao.selectMemberByUserid(JDBCTemplate.getConnection(), user_info);
	}

	@Override
	public User_info getJoinMember(HttpServletRequest req) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		User_info user_info = new User_info();
		
		user_info.setUser_email(req.getParameter("user_email"));
		user_info.setUser_password(req.getParameter("user_password"));
		user_info.setUser_nickname(req.getParameter("user_nickname"));
		
		return user_info;
		
	}

	@Override
	public void join(User_info user_info) {
		Connection conn = JDBCTemplate.getConnection();
		
		if( memberDao.insert(conn, user_info) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	@Override
	public User_info getPassword(HttpServletRequest req) {
		
		
		User_info user_info = new User_info();
		
		user_info.setUser_email( req.getParameter("user_email") );
		user_info.setUser_password(req.getParameter("user_password"));
		
		return user_info;
	}
	
	@Override
	public User_info getEmail(HttpServletRequest req) {
		
		
		User_info user_info = new User_info();
		
		user_info.setUser_email( req.getParameter("user_email") );
		
		return user_info;
	}
	
	@Override
	public void changePass(User_info newPassUserInfo) {
		Connection conn = JDBCTemplate.getConnection();
		
		if( memberDao.updatePassword(conn, newPassUserInfo) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}	
	}
	
	@Override
	public int getUsernoByEmail(String user_email) {
		return memberDao.selectUsernoByEmail(JDBCTemplate.getConnection(), user_email);
	}
	
	@Override
	public List<User_info> getList() {
		
		return memberDao.selectAll(JDBCTemplate.getConnection());
		
		
	}
	@Override
	public List<User_info> getList(Paging paging) {
		
		return memberDao.selectAll(JDBCTemplate.getConnection(), paging);

		
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {

		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARNING] curPage값이 null이거나 비어있습니다");
		}
		
		//회원 테이블의 총 게시글 수를 조회한다
		int totalCount = memberDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
}
