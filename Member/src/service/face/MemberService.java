package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	/**
	 * 전달파라미터 userid, nick, email을 객체로 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return 전달된 데이터를 Member객체에 담아서 반환
	 */
	public Member getParam(HttpServletRequest req);

	/**
	 * 전달된 데이터를 이용하여 회원가입 처리
	 * 
	 * @param param - 클라이언트로부터 전달된 회원 정보 객체
	 * @return DB에 삽입 완료된 회원 정보 객체
	 */
	public Member join(Member param);

}









