package join.service.face;

import javax.servlet.http.HttpServletRequest;

import join.dto.Member;

public interface MemberService {
	
	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청정보 객체
	 * @return info - 추출한 회원가입 정보
	 */
	Member getJoinMember(HttpServletRequest req);
	

//	/**
//	 * 회원가입 처리
//	 * 
//	 * @param param - 회원가입 정보 객체
//	 */
//	void join(User_Info param);

	
	
	/**
	 * 회원가입 여부 
	 * 
	 * @param info - 회원가입
	 * @return 회원가입 처리 여부 (true -성공, false-실패) 
	 */
	boolean join(Member info);
	
	
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	public Member getMember(Member info);

	/**
	 * 중복검사 대상 아이디 추출하기
	 * 
	 * @param req
	 * @return
	 */
	public Member getDuplChkId(HttpServletRequest req);

	/**
	 * 중복검사 대상 닉네임 추출하기
	 * 
	 * @param req
	 * @return
	 */
	public Member getDuplChkNick(HttpServletRequest req);
	
		
	/**
	 * 아이디 중복 검사
	 * 
	 * @param info - req객체에서 가져온 가입 정보
	 * @return 아이디 중복 여부 (0-중복없음,1-중복있음)
	 */
	public int checkDuplicationEmail(Member info);
	
	
	
	/**
	 * 닉네임 중복 검사
	 * 
	 * @param info -req객체에서 가져온 가입 정보
	 * @return 닉네임 중복 여부 (0-중복없음,1-중복있음)
	 */
	public int checkDuplicationNick(Member info);

	
	/**
	 * 아이디,닉네임 중복 검사
	 * 
	 * @param info - req객체에서 가져온 가입 정보
	 * @return 아이디 중복 여부 (0-중복없음,1-중복있음)
	 */
	public int checkDuplNickEmail(Member info);



}