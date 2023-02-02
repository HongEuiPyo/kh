package member.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import member.dto.User_info;
import member.util.Paging;

public interface MemberService {

	/**
	 * 로그인 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보
	 */
	public User_info getLoginMember(HttpServletRequest req);

	/**
	 * 로그인 처리
	 * 
	 * @param member - 로그인 정보
	 * @return true - 인증됨, false - 인증되지 않음
	 */
	public boolean login(User_info user_info);

	/**
	 * 유저정보 가져오기
	 * 
	 * @param member - 회원 아이디를 가진 객체
	 * @return Member - 조회된 회원 정보
	 */
	public User_info info(User_info user_info);

	/**
	 * 회원가입 정보 추출하기
	 * 
	 * @param req - 요청정보 객체
	 * @return Member - 추출한 회원가입 정보
	 */
	public User_info getJoinMember(HttpServletRequest req);

	/**
	 * 회원가입 처리
	 * 
	 * @param param - 회원가입 정보 객체
	 */
	public void join(User_info user_info);
	
	
	public User_info getEmail(HttpServletRequest req);
	
	public User_info getPassword(HttpServletRequest req);

	public void changePass(User_info newPassUserInfo);

	public int getUsernoByEmail(String user_email);
	
	
	/**
	 * 회원 전체 조회
	 * 
	 * @return List<memberList> - 회원 전체 조회 결과 리스트
	 */
	public List<User_info> getList();

	/**
	 * 회원 전체 조회
	 * 	페이징 처리 추가
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<memberList> - 게시글 전체 조회 결과 리스트
	 */
	public List<User_info> getList(Paging paging);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청파라미터 curPage를 구한다
	 * User_info테이블과 curPage값을 이용하여 Paging객체를 구하여 반환한다
	 * 
	 * @param req - 요청정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
}
