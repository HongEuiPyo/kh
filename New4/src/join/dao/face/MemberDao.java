package join.dao.face;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import join.dto.Member;

	public interface MemberDao {

	/**
	 * 회원가입정보 삽입하기
	 * 
	 * @param conn - DB연결 객체
	 * @param info - 회원가입 정보 객체
	 */
	public int insert(Connection conn, Member info);

	
	/**
	 * 회원이메일로 회원정보 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param info - 회원가입 정보 객체
	 * @return 회원정보
	 */
	Member selectByUser_info(Connection conn, Member info);

	/**
	 * 회원아이디(이메일)로 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param info - 회원가입 정보 객체
	 * @return 결과가 1이면 중복이메일, 0이면 처음가입하는 이메일
	 */
	public int selectByUser_email(Connection conn,Member info);
	
	/**
	 * 회원닉네임으로 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param info - 회원가입 정보 객체
	 * @return 결과가 1이면 중복닉네임, 0이면 중복없는 닉네임
	 */
	public int selectByUser_nickname(Connection conn,Member info);
	
}
