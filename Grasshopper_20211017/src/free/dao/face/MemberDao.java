package free.dao.face;

import java.sql.Connection;

import free.dto.Member;

public interface MemberDao {

	/**
	 * memberdto와 일치하는 정보가 잇다면 로그인
	 * 
	 * @param conn - DB 연결 객체
	 * @param member - free.dto
	 * @return - 검색 결과로 나오는 행 수 반환
	 */
	public Member login(Connection conn, Member member);

	public int selectCntMemberByUseridUserpw(Connection connection, Member member);

	public Member selectMemberByUseremail(Connection connection, Member member);
	
	/**
	 * user_no를 바탕으로 조회한 user_nickname결과를 포함하는 dto를 반환
	 * 
	 * @param conn - DB 연결 객체
	 * @param member - free.dto
	 * @return - dto반환
	 */
	public Member selectMemberByUserid(Connection conn, Member member);
}
