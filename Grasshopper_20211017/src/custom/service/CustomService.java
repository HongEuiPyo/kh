package custom.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import custom.dto.Custom;
import custom.dto.CustomComment;
import custom.dto.CustomFile;
import official.dto.OfficialComment;
import util.Paging;

public interface CustomService {
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * 전체 custom테이블과 curPage값을 이용해 Paging객체를 구하여 반환한다 
	 * 
	 * @param req - 요청정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	Paging getPaging(HttpServletRequest req);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * 특정 검색어로 조회한 테이블의 데이터와 curPage값을 이용해 Paging객체를 구하여 반환한다 
	 * 
	 * @param req - 요청정보 객체
	 * @param category, search - 검색범위 + 검색어
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	Paging getPaging(HttpServletRequest req, String search, String category);
	
	/**
	 * 레시피 목록을 조회하는 기능
	 * 페이징 정보를 고려하여 조회한다
	 * 
	 * @param paging - 현재 페이징 정보
	 * @return 게시글 목록을 List<custom>형태로 가져온다
	 */
	List<Custom> getList(Paging paging);
	
	/**
	 * 레시피 목록을 조회하는 기능
	 * 페이징 정보를 고려하여 조회한다
	 * 
	 * @param paging - 현재 페이징 정보
	 * @param categorySearch - 검색범위 + 검색어
	 * @return 게시글 목록을 List<Custom>형태로 가져온다
	 */
	List<Custom> getList(Paging paging, String search, String category);
	
	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청정보객체
	 * @return Board - 전달파라미터 custom_no를 포함한 custom객체
	 */
	Custom getCustom_no(HttpServletRequest req);
	
	/**
	 * 주어진 custom_no를 이용하여 레시피를 조회 
	 * [비활성] 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param custom_no - custom_cocktail_no를 가지고 있는 custom 객체
	 * @return custom - 조회된 레시피
	 */
	Custom view(Custom custom_no);
	
	/**
	 * 게시글 작성
	 * 	입력한 게시글 내용을 DB에 저장
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * 
	 */
	void write(HttpServletRequest req);
	
	/**
	 * Custom 객체의 user_no 를 이용한 닉네임 조회
	 * 
	 * @param viewCustom - 조회할 게시글 정보
	 * @return String - 게시글 작성자의 닉네임
	 */
	String getNick(Custom viewCustom);
	
	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param viewCustom - 첨부파일과 연결된 게시글번호를 포함한 DTO객체
	 * @return CustomFile - 첨부파일 정보 DTO객체
	 */
	CustomFile viewFile(Custom viewCustom);
	
	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	void update(HttpServletRequest req);

	/**
	 * 게시글 삭제
	 * 
	 * @param custom - 삭제할 게시글 번호를 가진 객체
	 */
	void delete(Custom custom);

	/**
	 * 해당 게시글에 코멘트를 등록한다 
	 * 
	 * @param customComment
	 */
	void writeComment(CustomComment customComment);

	/**
	 * 등록된 코멘트를 수정한다 
	 * 
	 * @param customComment
	 */
	void updateComment(CustomComment customComment);
	
	/**
	 * 등록된 코멘트를삭제한다
	 * 
	 * @param customComment
	 */
	void deleteComment(CustomComment customComment);

	/**
	 * 전달된 게시글 번호에 연관된 댓글들을 불러온다 
	 * 
	 * @param viewCustom
	 * @param paging
	 * @return CustomComment - 코멘트 속성
	 */
	List<CustomComment> getComment(Paging paging, Custom viewCustom);


}
