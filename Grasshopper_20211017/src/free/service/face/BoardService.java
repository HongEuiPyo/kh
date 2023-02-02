package free.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import free.dto.BoardFile;
import free.dto.FreeBoard;
import free.dto.FreeReply;
import free.dto.Member;
import free.util.Paging;

public interface BoardService {

	/**
	 * 페이징 객체 생성
	 * 
	 * 요청 파라미터 curPage를 구한다
	 * Board테이블과 curPage값을 이용하여 Paging객체를 구하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	
	/**
	 * 게시글 전체 조회
	 *  페이징 처리 추가
	 *  
	 * @param paging - 페이징 정보 객체
	 * @return List<FreeBoard> - 게시글 전체 조회 결과 리스트
	 */
	public List<FreeBoard> getList(Paging paging);

	/**
	 * boardno를 바탕으로 게시글 내용 반환
	 * @param req
	 */
	public FreeBoard getFreeBoardDetail(HttpServletRequest req);

	/**
	 * 자유게시판 게시글 작성
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);


	/**
	 * boardFile dto에 저장된 attach_no를 가지고 attachment테이블을 select
	 * 
	 * @param boardFile - 결과값이 들어있는 dto객체
	 */
	public BoardFile getAttachment(BoardFile boardFile);


	/**
	 * freeboard 테이블 update
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	
	/**
	 * 요청한 글 번호의 첨부파일 정보를 dto객체로 반환하는 메소드
	 * 
	 * @param req - 요청 정보 객체
	 * @return - free.dto
	 */
	public BoardFile getBoardFile(HttpServletRequest req);


	/**
	 * 요청한 글을 삭제하는 메소드
	 *
	 * @param req
	 */
	public void delete(HttpServletRequest req);


	/**
	 * 전체 리스트에서 검색 조건에 맞는 dto만 반환하는 메소드
	 * 
	 * @param paging - 페이징
	 * @param req - 요청 객체
	 * @return - 결과값 List
	 */
	public List<FreeBoard> getList(Paging paging, HttpServletRequest req);


	/**
	 * ajax를 통해 넘어온 정보를 바탕으로 free_board_reply에 댓글 내용을 삽입
	 * 
	 * @param req - 요청 객체
	 * @return - 반영된 행의 수 반환
	 */
	public void insertReply(HttpServletRequest req);


	/**
	 * 게시글에 해당하는 모든 댓글 반환
	 * @param req 
	 * 
	 * @return - free.dto 타입의 arraylist
	 */
	public List<FreeReply> getReply(HttpServletRequest req);


	/**
	 * 게시글에 달린 댓글 삭제
	 * 
	 * @param req - 요청 객체
	 */
	public void deleteComment(HttpServletRequest req);

	/**
	 * userno를 가지고 usernick을 구하는 메소드
	 * @param req
	 * @return
	 */
	public Member getuser_nickname(HttpServletRequest req);



	


	
//	/**
//	 * 게시글 좋아요 증감 메소드
//	 * 
//	 */
//	public void updateLike(HttpServletRequest req);
//
//
//	/**
//	 * 게시글 좋아요를 포함함 dto를 반환하는 메소드
//	 * 
//	 * @param req
//	 * @return - free.dto
//	 */
//	public FreeBoard getVote(HttpServletRequest req);

	

}
