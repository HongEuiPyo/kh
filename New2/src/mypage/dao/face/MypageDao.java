package mypage.dao.face;

import java.sql.Connection;
import java.util.List;

import mypage.dto.Attachment_profile;
import mypage.dto.Custom_board;
import mypage.dto.Custom_reply;
import mypage.dto.Free_board;
import mypage.dto.Free_board_reply;
import mypage.dto.Message;
import mypage.dto.Official_reply;
import mypage.dto.Qna_board;
import mypage.dto.Qna_board_attachment;
import mypage.dto.Qna_board_reply;
import mypage.dto.User_admin;
import mypage.dto.User_info;

public interface MypageDao {

	/**
	 * User_info테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<User_info> - User_info테이블 전체 조회 결과 리스트
	 */
	public List<User_info> selectAll(Connection conn);

	/**
	 * user_email 과 user_password가 일치하는 회원의 수를 조회
	 * 
	 * @param User_info - 조회할 회원의 정보
	 * @return int - 1(존재하는 회원), 0(존재하지 않는 회원), -1(에러)
	 */
	public int selectCntUser_infoByUseremailUserpassword(Connection conn, User_info user_info);

	/**
	 * user_email을 이용해 회원정보 조회
	 * 
	 * @param user_info - 조회할 회원
	 * @return User_info - 조회된 결과 객체
	 */
	public User_info selectUser_infoByUser_email(Connection conn, User_info user_info);

	/**
	 * 회원정보 수정
	 * 
	 * @param user_info - 수정할 내용을 담은 객체
	 */
	public int update(Connection conn, User_info user_info);

	/**
	 * 
	 * @param conn
	 * @param user_no - 유저정보를 조회할 전달 파라미터 유저번호
	 * @return 조회한 객체
	 */
	public User_info selectUserInfoByUserNo(Connection conn, int user_no);

	/**
	 * 첨부파일 입력
	 * 
	 * @param conn               - DB연결 객체
	 * @param attachment_profile - 첨부파일 정보
	 * @return 삽입 결과
	 */
	public int insertFile(Connection conn, Attachment_profile attachment_profile);

	/**
	 * 첨부파일 조회
	 * 
	 * @param connection - DB연결 객체
	 * @param user_no    - 첨부파일을 조회할유저번호
	 * @return Attachment_profile - 첨부파일객체
	 */
	public Attachment_profile getByUser_no(Connection conn, int user_no);

	/**
	 * 사용자의 user_no를 변경하여 프로필 사진을 업데이트한다
	 * 
	 * @param conn
	 * @param user_info
	 * @param attachment_profile
	 * @return
	 */
	public int updateProfile(Connection conn, User_info user_info, Attachment_profile attachment_profile);

	/**
	 * 첨부파일 번호 seq의 nextval을 반환한다
	 * 
	 * @param conn
	 * @return
	 */
	public int getNextProfileNo(Connection conn);

	/**
	 * 내가쓴 게시글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return customBoard - 조회된 결과 객체
	 */
	public List<Custom_board> customBoardByUserno(Connection conn, int user_no);

	/**
	 * 내가쓴 게시글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return Free_board - 조회된 결과 객체
	 */
	public List<Free_board> freeBoardByUserno(Connection conn, int user_no);

	/**
	 * 내가 자유게시판에 쓴 댓글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return Free_board_reply - 조회된 결과 객체
	 */
	public List<Free_board_reply> freeBoardReplyByUserno(Connection conn, int user_no);

	/**
	 * 내가 커스텀게시판에 쓴 댓글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return custom_reply - 조회된 결과 객체
	 */
	public List<Custom_reply> customReplyByUserno(Connection conn, int user_no);

	/**
	 * 내가 오피셜게시판에 쓴 댓글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return official_reply - 조회된 결과 객체
	 */
	public List<Official_reply> officialReplyByUserno(Connection conn, int user_no);

	/**
	 * 회원탈퇴
	 * 
	 * @param - 탈퇴한 회원정보를 담은 객체
	 */
//	public User_info delete(Connection conn, int user_no );

	/**
	 * 
	 * @param conn
	 * @param user_no 회원탈퇴할 유저번호
	 * @return
	 */
	public int delete(Connection conn, int user_no);

	/**
	 * 
	 * @param conn
	 * @param user_no- 유저번호로 탈퇴할 유저의 객체를 반환한다
	 * @return
	 */
	public User_info unregsterUserInfoByUserNo(Connection conn, int user_no);

//	public int deleteFile(Connection conn, int user_no);

	/**
	 * 
	 * @param conn
	 * @param qna_board
	 * @return 1 - 성공 , 0 - 실패 -1 -에러
	 */
	public int insertQna(Connection conn, Qna_board qna_board);

	/**
	 * 
	 * @param conn
	 * @param boardFile
	 * @return 1 - 성공 , 0 - 실패 -1 -에러
	 */
	public int insertFile(Connection conn, Qna_board_attachment boardFile);

	/**
	 * 
	 * @param conn
	 * @return 다음에 올 보드넘버
	 */
	public int getNextBoardno(Connection conn);

	/**
	 * 
	 * @param conn
	 * @return 다음에 올 첨부파일 넘버
	 */
	public int getNextAttachno(Connection conn);

	/**
	 * 내가 쓴 문의 게시글 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return Qna_board - 조회된 결과 객체
	 */
	public List<Qna_board> QnaBoardByUserno(Connection conn, int user_no);

	/**
	 * 
	 * @param conn
	 * @param boardno 해당 보드넘버
	 * @return 해당 보드넘버의 객체 반환
	 */
	public Qna_board selectQnaBoardByBoardno(Connection conn, Qna_board boardno);

	/**
	 * 
	 * @param conn
	 * @param user_no 유저번호를 이용하여 해당 객체 반환
	 * @return 조회된 문의게시판 객체
	 */
	public Qna_board QnaBoardInstanceByUserno(Connection conn, int user_no);

	/**
	 * 첨부파일 조회
	 * 
	 * @param connection - DB연결 객체
	 * @param viewBoard  - 첨부파일을 조회할 게시글번호 객체
	 * @return Qna_board_attachment - 조회된 첨부파일
	 */
	public Qna_board_attachment selectFile(Connection conn, Qna_board viewBoard);

	/**
	 * 게시글 수정
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	public int update(Connection conn, Qna_board board);

	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public int delete(Connection conn, Qna_board board);

	/**
	 * 게시글에 첨부된 파일 기록 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public int deleteFile(Connection conn, Qna_board board);

	/**
	 * 관리자 아이디로 로그인했는지 확인한다
	 * 
	 * @param User_admin
	 * @return int - 1(존재하는 관리자), 0(존재하지 않는 관리자), -1(에러)
	 */
	public int loginAdmin(Connection conn, User_admin user_admin);

	/**
	 * Qna_board테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return List<Qna_board> - Qna_board테이블 전체 조회 결과 리스트
	 */
	public List<Qna_board> selectAllQna(Connection conn);

	/**
	 * 
	 * @param conn
	 * @param message
	 * @return
	 */
	public int insertMessage(Connection conn, Message message);

	/**
	 * 다음 쪽지 번호 조회
	 * 
	 * 
	 * @param conn - DB연결 객체
	 * @return 다음 쪽지 번호
	 */
	public int selectNextMessageNo(Connection conn);

	/**
	 * 내가쓴 쪽지 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return Message - 조회된 결과 객체
	 */
	public List<Message> sendMessageByUserno(Connection conn, int user_no);

	/**
	 * 내가보낸 쪽지 조회
	 * 
	 * @param user_no - 조회할 user_no를 가진 객체
	 * @return Message - 조회된 결과 객체
	 */
	public List<Message> recMessageByUserno(Connection conn, int user_no);

	
	
	
	/**
	 * FreeBoard 게시글 조회
	 *  
	 * @param conn - DB 연결 객체
	 * @param boardno
	 * @return - dto타입 반환
	 */
	public Free_board getFreeBoardByFreeBoardNo(Connection conn, int boardno);
	
	
	
	public int getNextQnaReplyNo(Connection conn);
	
	
	/**
	 * 코멘트 정보를 데이터베이스에 입력한다 
	 * 
	 * @param conn
	 * @param qna_board_reply
	 */
	int insertQnaReply(Connection conn, Qna_board_reply qna_board_reply);
	
	
	public List<Qna_board_reply> selectQnaBoardReply(Connection conn);
	
	public int updateMsgCheck(Connection conn, int user_no);
	
}// class
