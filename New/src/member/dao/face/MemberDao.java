package member.dao.face;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import member.dto.User_info;
import member.util.Paging;

public interface MemberDao {

	/**
	 * userid 와 userpw가 일치하는 회원의 수를 조회
	 * 
	 * @param member - 조회할 회원의 정보
	 * @return int - 1(존재하는 회원), 0(존재하지 않는 회원), -1(에러)
	 */
	public int selectCntMemberByUseridUserpw(Connection Conn, User_info user_info);

	/**
	 * userid를 이용해 회원정보 조회
	 * 
	 * @param member - 조회할 회원
	 * @return Member - 조회된 결과 객체
	 */
	public User_info selectMemberByUserid(Connection Conn, User_info user_info);

	/**
	 * 회원가입정보 삽입하기
	 * 
	 * @param member - 회원가입 정보 객체
	 */
	public int insert(Connection Conn, User_info user_info);
	
	
	/**
	 * 회원의 비밀번호를 변경한다 
	 * 
	 * @param Conn
	 * @param user_info - 변경할 비밀번호, user_no(PK) 필요
	 * @return
	 */
	public int updatePassword(Connection Conn, User_info user_info);

	/**
	 * 비밀번호 변경 이메일 전송을 위한 정보 가져옴
	 * 
	 * @param conn
	 * @param user_email
	 * @return
	 */
	public int selectUsernoByEmail(Connection conn, String user_email);
	
	/**
	 * 관리자 페이지 회원정보 조회
	 * @param Conn
	 * @param user_info
	 * @return
	 */
	public List getMemberList(Connection Conn, User_info user_info);

	public List<User_info> selectAll(Connection conn);

	public List<User_info> selectAll(Connection conn, Paging paging);

	public int selectCntAll(Connection conn);
	


}
