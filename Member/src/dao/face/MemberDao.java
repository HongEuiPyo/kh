package dao.face;

import java.sql.Connection;

import dto.Member;

public interface MemberDao {

	/**
	 * member_seq의 nextval을 반환한다
	 * 
	 * @param conn - DB연결객체
	 * @return member_seq.nextval
	 */
	public int selectNextUserno(Connection conn);

	/**
	 * Member객체의 값을 테이블에 삽입한다
	 * 
	 * @param conn - DB연결객체
	 * @param param - 삽입할 정보 객체
	 */
	public int insert(Connection conn, Member param);

}


