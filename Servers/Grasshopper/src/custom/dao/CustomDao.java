package custom.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import custom.dto.Custom;
import custom.dto.CustomComment;
import custom.dto.CustomFile;
import custom.dto.Report;
import official.dto.OfficialComment;
import custom.dto.Custom;
import util.Paging;

public interface CustomDao {
	
	/**
	 * 전체 테이블의 행 갯수를 조회
	 * 
	 * @param conn - DB연결객체
	 * @return int = Custom테이블 전체 행의 갯수 
	 */
	int selectCntAll(Connection connection);
		
	/**
	 * 특정 검색어로 특정 카테고리에서 검색한 데이터베이스의 행 갯수를 조회
	 * @param search 
	 * 
	 * @param conn - DB연결객체
	 * @return int = Custom테이블 전체 행의 갯수 
	 */
	int selectCntSearch(Connection connection, String search, String category);

	/**
	 * 검색어가포함된 테이블의 행 갯수를 조회
	 * 
	 * @param conn - DB연결객체
	 * @param search - 검색어
	 * @return int - Custom테이블 전체 행의 갯수 
	 */
	int selectCntSearchAll(Connection connection, String search);
	
	/**
	 * 파일 정보 테이블 전체 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @return 테이블 전체 조회 결과 List<C>
	 */
	List<Custom> selectAll(Connection connection, Paging paging);

	/**
	 * 파일 정보 테이블 검색어 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @param search - 카테고리 + 검색어
	 * @return 테이블 전체 조회 결과 List<Custom>
	 */
	List<Custom> selectSearch(Connection connection, Paging paging, String search, String category);
	
	/**
	 * 파일 정보 테이블 검색어 조회 (DB로부터)
	 * 페이징 처리 추가
	 * 
	 * @param connection - DB연결 객체
	 * @param Paging 페이징 객체
	 * @param categorySearch - 검색어
	 * @return 테이블 전체 조회 결과 List<Custom>
	 */
	List<Custom> selectSearchAll(Connection connection, Paging paging, String search);
	
	/**
	 * [비활성]조회된 게시글의 조회수 증가시키기
	 * 
	 * @param custom_no - 조회된 게시글 번호를 가진 객체
	 */
	int updateHit(Connection connection, Custom custom_no);

	/**
	 * 특정 레시피 조회
	 * 
	 * @param custom_no - 조회할 custom_cocktail_no를 가진 Custom 객체
	 * @return Custom - 조회된 결과 Custom객체
	 */
	Custom selectCustomByCustomno(Connection connection, Custom custom_no);
	
	/**
	 * 다음 게시글 번호 조회
	 * 
	 * 	게시글 테이블과 첨부파일 테이블에 입력될 공통 custom_board_no값을 시퀀스를 통해 조회한다
	 * 
	 * @param connection - DB연결 객체
	 * @return 다음 게시글 번호
	 */
	int selectNextCustomno(Connection connection);

	/**
	 * 게시글 입력
	 * 
	 * @param custom - 삽입될 게시글 내용
	 */
	int insert(Connection connection, Custom custom);

	/**
	 * 첨부파일 입력
	 * 
	 * @param connection - DB연결 객체
	 * @param customFile - 첨부파일 정보
	 * @return 삽입 결과
	 */
	int insertFile(Connection connection, CustomFile customFile);

	/**
	 * user_no를 이용해 nick을 조회한다
	 * 
	 * @param viewBoard - 조회할 user_no를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	String selectNickByUserno(Connection connection, Custom viewCustom);
	
	/**
	 * 첨부파일 조회
	 * 
	 * @param connection - DB연결 객체
	 * @param viewCustom - 첨부파일을 조회할 게시글번호 객체
	 * @return CustomFile - 조회된 첨부파일
	 */
	CustomFile selectFile(Connection connection, Custom viewCustom);

	/**
	 * 게시글 수정 
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	int update(Connection connection, Custom custom);

	/**
	 * 게시글 삭제
	 * 
	 * @param custom - 삭제할 게시글번호를 담은 객체
	 */
	int deleteFile(Connection connection, Custom custom);
	
	/**
	 * 게시글에 첨부된 파일 기록 삭제
	 * 
	 * @param custom - 삭제할 게시글번호를 담은 객체
	 */
	int delete(Connection connection, Custom custom);

	/**
	 * 코멘트 정보를 데이터베이스에 입력한다 
	 * 
	 * @param connection
	 * @param customComment
	 */
	int insertComment(Connection connection, CustomComment customComment);
	
	/**
	 * 데이터베이스의 코멘트 정보를 수정한다
	 * 
	 * @param connection
	 * @param customComment
	 * @return
	 */
	int updateComment(Connection connection, CustomComment customComment);
	
	/**
	 * 해당 코멘트 데이터를 삭제한다 
	 *  
	 * @param connection
	 * @param customComment
	 * @return
	 */
	int delete(Connection connection, CustomComment customComment);

	/**
	 * 특정 게시글의 코멘트들을 조회하여 반환한다
	 * 
	 * @param connection - DB연결객체
	 * @param paging - 페이징 객체
	 * @param viewCustom - 조회할 게시글 객체
	 * @return List<CustomComment> 
	 */
	List<CustomComment> selectComment(Connection connection, Paging paging, Custom viewCustom);
	
	/**
	 * Report객체를 report_board DB에 삽입한다
	 * @param connection 
	 * 
	 * @param report
	 */
	int report(Connection connection, Report report);

}
