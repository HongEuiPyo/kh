package official.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import official.dto.Official;
import official.dto.OfficialComment;
import util.Paging;

public interface OfficialDao {
	
	/**
	 * 전체 Official 데이터베이스의 행 갯수를 조회
	 * 
	 * @param conn - DB연결객체
	 * @return int = Official테이블 전체 행의 갯수 
	 */
	int selectCntAll(Connection connection);
		
	/**
	 * 특정 검색어로 조회한 Official데이터베이스의 행 갯수를 조회
	 * @param search 
	 * 
	 * @param conn - DB연결객체
	 * @return int = Official테이블 전체 행의 갯수 
	 */
	int selectCntSearch(Connection connection, String search, String category);

	/**
	 * 전체 Official 데이터베이스의 행 갯수를 조회
	 * 
	 * @param conn - DB연결객체
	 * @param search - 검색어
	 * @return int - Official테이블 전체 행의 갯수 
	 */
	int selectCntSearchAll(Connection connection, String search);
	
	/**
	 * 파일 정보 테이블 전체 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @return 테이블 전체 조회 결과 List<Official>
	 */
	List<Official> selectAll(Connection connection, Paging paging);

	/**
	 * 파일 정보 테이블 검색어 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @param search - 카테고리 + 검색어
	 * @return 테이블 전체 조회 결과 List<Official>
	 */
	List<Official> selectSearch(Connection connection, Paging paging, String search, String category);
	
	/**
	 * 파일 정보 테이블 검색어 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @param categorySearch - 검색어
	 * @return 테이블 전체 조회 결과 List<Official>
	 */
	List<Official> selectSearchAll(Connection connection, Paging paging, String search);
	
	/**
	 * [비활성]조회된 게시글의 조회수 증가시키기
	 * 
	 * @param official_no - 조회된 게시글 번호를 가진 객체
	 */
	int updateHit(Connection connection, Official official_no);

	/**
	 * 특정 레시피 조회
	 * 
	 * @param official_no - 조회할 official_cocktail_no를 가진 Official 객체
	 * @return Official - 조회된 결과 Official객체
	 */
	Official selectOfficialByOfficialno(Connection connection, Official official_no);
	
	/**
	 * 특정 게시글의 코멘트들을 조회하여 반환한다
	 * 
	 * @param connection - DB연결객체
	 * @param paging - 페이징 객체
	 * @param viewOfficial - 조회할 게시글 객체
	 * @return List<OfficialComment> 
	 */
	List<OfficialComment> selectComment(Connection connection, Paging paging, Official viewOfficial);
	
	/**
	 * 코멘트 정보를 데이터베이스에 입력한다 
	 * 
	 * @param connection
	 * @param officialComment
	 */
	int insertComment(Connection connection, OfficialComment officialComment);
	
	/**
	 * 데이터베이스의 코멘트 정보를 수정한다
	 * 
	 * @param connection
	 * @param officialComment
	 * @return
	 */
	int updateComment(Connection connection, OfficialComment officialComment);
	
	/**
	 * 해당 코멘트 데이터를 삭제한다
	 *  
	 * @param connection
	 * @param officialComment
	 * @return
	 */
	int delete(Connection connection, OfficialComment officialComment);








}
