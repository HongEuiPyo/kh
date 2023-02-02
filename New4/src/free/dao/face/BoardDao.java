package free.dao.face;

import java.sql.Connection;
import java.util.List;

import free.dto.Free_board_attachment;
import free.dto.Free_board;
import free.dto.Free_board_reply;
import free.util.Paging;

public interface BoardDao {

	/**
	 * 총 게시글 수 조회
	 *  
	 * @param conn - DB 연결 객체
	 * @return int - free_board 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll(Connection conn);
	
	
	/**
	 * FreeBoard테이블 전체 조회
	 *  페이징 처리 추가
	 *  
	 * @param conn -DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<FreeBoard> - Board테이블 전체 조회 결과 리스트
	 */
	public List<Free_board> selectAll(Connection conn, Paging paging);

	
	/**
	 * FreeBoard 게시글 조회
	 *  
	 * @param conn - DB 연결 객체
	 * @param board - boardno가 들어있는 객체
	 * @return - dto타입 반환
	 */
	public Free_board getFreeBoardByFreeBoardNo(Connection conn, Free_board board);


	/**
	 * FreeBoard테이블 안에 해당 boardno로 게시글의 존재 여부를 파악하는 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - boardno를 가지고 잇는 dto객체
	 * @return - boardno로 검색된 게시글 수 반환
	 */
	public int SearchByBoardNo(Connection conn, Free_board board);


	/**
	 * FreeBoard 게시글 조회수 증가 메소드
	 * 
	 * @param connection - DB 연결 객체
	 * @param board - Boardno정보가 들어있는 DTO
	 */
	public void Hit(Connection connection, Free_board board);

	/**
	 * 다음 boardno값을 가져오는 메소드
	 * 
	 * @param conn - DB연결 객체
	 * @return - boardno값 리턴
	 */
	public int selectNextFreeBoardno(Connection conn);

	
	/**
	 * 
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile 
	 * @return - attachno값 리턴
	 */
	public int selectNextAttachno(Connection conn);
	
	/**
	 * freeboard테이블에 insert
	 * 
	 * @param conn - DB연결 객체
	 * @param freeBoard - dto객체
	 * @return - insert완료한 행 갯수 반환
	 */
	public int insertIntoFreeBoard(Connection conn, Free_board freeBoard);

	/**
	 * attachment테이믈에 insert
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - dto객체
	 * @return - insert완료한 행 갯수 반환
	 */
	public int insertFile(Connection conn, Free_board_attachment boardFile);




	/**
	 * attachment 테이블에서 attach_no로 select
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardFile - attach_no가 들어있는 dto객체
	 * @return - 결과값 dto객체
	 */
	public Free_board_attachment getAttachmentByAttachNo(Connection conn, Free_board_attachment boardFile);


	

	/**
	 * 요청객체 내용을 바탕으로 FreeBorad 게시글 업데이트
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeBoard - free.dto
	 */
	public int updateFreeBoard(Connection conn, Free_board freeBoard);


	/**
	 * freeBoardno를 free_board_no로 가지는 attach_no를 찾는 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeBoardno - 검색하려 하는 free_board_no
	 * @return - 검색한 attach_no
	 */
//	public int getAttach_noByfree_board_no(Connection conn, int freeBoardno);


	/**
	 * 수정된 내용을 바탕으로 user_no로 검색된 행의 내용을 update해준다
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardFile - user_no가 들어있는 free.dto
	 * @return - 변경된 행의 갯수 반환
	 */
	public int updateFile(Connection conn, Free_board_attachment boardFile);

	
	/**
	 * freeboardno를 바탕으로 검색한 boardfile dto객체를 반환하는 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @return
	 */
	public Free_board_attachment getFreeboardAttachmentByFreeBoardNo(Connection conn, Free_board_attachment boardFile);

	
	
	/**
	 * 넘겨받은 freeboardno를 바탕으로 글 삭제
	 * 
	 * @param connection - DB 연결 객체
	 * @param freeBoard - free_board_no가 들어있는 FreeBoard free.dto 객체
	 */
	public int deleteFreeBoardByFreeBoardNo(Connection connection, Free_board freeBoard);

	/**
	 * 넘겨받은 freeboardno를 바탕으로 게시글 관련 파일 삭제
	 * 
	 * @param connection
	 * @param boardFile
	 * @return
	 */
	public int deleteFreeBoardAttachment(Connection connection, Free_board_attachment boardFile);


	/**
	 * 매개변수로 전달받은 dto객체를 바탕으로 free_board_reply에 insert
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeReply - free.dto 객체
	 * @return - 반영된 행의 수 반환
	 */
	public int insertReply(Connection conn, Free_board_reply freeReply);


	/**
	 * dto객체의 freeboardno를 기준으로 조회한 모든 reply를 반환 
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeReply - DTO
	 * @return - DTO ArrayList
	 */
	public List<Free_board_reply> selectAllReplyByFreeboardno(Connection conn, Free_board_reply freeReply);


	/**
	 * dto객체의 no를 검색후 삭제하는 메소드
	 * 
	 * @param conn - DB연결 객체
	 * @param freeReply - free.dto
	 * @return - 반영된 행 갯수 반환
	 */
	public int deleteFreeReplyByNo(Connection conn, Free_board_reply freeReply);


	/**
	 * 게시글 좋아요 증가 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeBoard - free.dto
	 * @return - update가 반영된 행의 수 반환
	 */
	public int PlusVote(Connection conn, Free_board freeBoard);

	
	/**
	 * 게시글 좋아요 감소 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeBoard - free.dto
	 * @return - update가 반영된 행의 수 반환
	 */
	public int MinusVote(Connection conn, Free_board freeBoard);

	/**
	 * 게시글의 좋아요 수 반환
	 * 
	 * @param conn - DB 연결 객체
	 * @param freeBoard - freeboardno가 포함된 free.dto
	 * @return - 좋아요 수가 포함된 dto객체
	 */
	public Free_board getLike(Connection conn, Free_board freeBoard);


	/**
	 * attachment_seq 시퀀스로 생성된 no와 free_board_no만  free_board_attachment 테이블에 새롭게 삽입하는 메소드
	 * 사용자가 먼저 글을 올린 이후에 update를 하면서 첨부 파일 추가시 해당 첨부파일을 추가할 자리를 미리 만들어 둔다
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardFile - dto객체
	 */
	public int createByAttachno(Connection conn, Free_board_attachment boardFile);


	/**
	 * 타입에 따른 검색 결과를 반환하는 메소드
	 * 
	 * @param connection - DB 연결 객체
	 * @param type - 검색 타입
	 * @return - 검색 결과 수
	 */
	public int selectCntByCategory(Connection connection, String type, String search);


	/**
	 * 타입에 따른 검색 결과를 dto리스트로 반환하는 메소드
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징
	 * @param type - 검색 타입
	 * @param search - 검색 내용
	 * @return - 반환 리스트
	 */
	public List<Free_board> selectSearchList(Connection conn,Paging paging, String type, String search);

	
	




	
}
