package official.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import official.dto.Official;
import official.dto.OfficialComment;
import util.Paging;

public interface OfficialService {
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * 전체 테이블과 curPage값을 이용해 Paging객체를 구하여 반환한다 
	 * 
	 * @param req - 요청정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	Paging getPaging(HttpServletRequest req);
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * 특정 검색어로 조회한 Official테이블의 데이터와 curPage값을 이용해 Paging객체를 구하여 반환한다 
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
	 * @return 게시글 목록을 List<Official>형태로 가져온다
	 */
	List<Official> getList(Paging paging);
	
	/**
	 * 레시피 목록을 조회하는 기능
	 * 페이징 정보를 고려하여 조회한다
	 * 
	 * @param paging - 현재 페이징 정보
	 * @param categorySearch - 검색범위 + 검색어
	 * @return 게시글 목록을 List<Official>형태로 가져온다
	 */
	List<Official> getList(Paging paging, String search, String category);
	
	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청정보객체
	 * @return Board - 전달파라미터 official_no를 포함한 Official객체
	 */
	Official getOfficial_no(HttpServletRequest req);
	
	/**
	 * 주어진 official_no를 이용하여 레시피를 조회 
	 * [비활성] 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param official_no - official_cocktail_no를 가지고 있는 Official 객체
	 * @return Official - 조회된 레시피
	 */
	Official view(Official official_no);
	
	/**
	 * 전달된 게시글 번호에 연관된 댓글들을 불러온다 
	 * 
	 * @param viewOfficial
	 * @param paging
	 * @return OfficialComment - 코멘트 속성
	 */
	List<OfficialComment> getComment(Paging paging, Official viewOfficial);
	
	/**
	 * 해당 게시글에 코멘트를 등록한다 
	 * 
	 * @param officialComment
	 */
	void writeComment(OfficialComment officialComment);
	
	/**
	 * 등록된 코멘트를 수정한다 
	 * 
	 * @param officialComment
	 */
	void updateComment(OfficialComment officialComment);
	
	/**
	 * 등록된 코멘트를삭제한다
	 * 
	 * @param officialComment
	 */
	void deleteComment(OfficialComment officialComment);



}
