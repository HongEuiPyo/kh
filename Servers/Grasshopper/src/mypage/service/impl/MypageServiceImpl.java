package mypage.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
//import java.util.UUID;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import mypage.dao.face.MypageDao;
import mypage.dao.impl.MypageDaoImpl;
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
import mypage.service.face.MypageService;

public class MypageServiceImpl implements MypageService {

	private MypageDao mypageDao = new MypageDaoImpl();

	@Override
	public List<User_info> getList() {
		return mypageDao.selectAll(JDBCTemplate.getConnection());

	}

	@Override
	public User_info getLoginUser_info(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		User_info user_info = new User_info();

		user_info.setUser_email(req.getParameter("user_email"));
		user_info.setUser_password(req.getParameter("user_password"));

		return user_info;

	}

	@Override
	public boolean login(User_info user_info) {

		if (mypageDao.selectCntUser_infoByUseremailUserpassword(JDBCTemplate.getConnection(), user_info) > 0) {
			return true; // 로그인 성공
		} else {
			return false; // 로그인 실패
		}

	}

	@Override
	public User_info info(User_info user_info) {

		return mypageDao.selectUser_infoByUser_email(JDBCTemplate.getConnection(), user_info);
	}

	@Override
	public User_info getUser_no(HttpServletRequest req) {
		// user_no를 저장할 객체 생성
		User_info user_no = new User_info();

		// user_no 전달파라미터 검증 - null, ""
		String param = req.getParameter("user_no");
		if (param != null && !"".equals(param)) {

			// user_no 전달파라미터 추출
			user_no.setUser_no(Integer.parseInt(param));
		}

		// 결과 객체 반환
		return user_no;

	}

	@Override
	public Attachment_profile getFile(int user_no) {
		return mypageDao.getByUser_no(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public User_info getUserInfo(int user_no) {
		return mypageDao.selectUserInfoByUserNo(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public List<Custom_board> customBoardSelectAll(int user_no) {
		return mypageDao.customBoardByUserno(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public List<Free_board> freeBoardSelectAll(int user_no) {
		return mypageDao.freeBoardByUserno(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public List<Custom_reply> customReplySelectAll(int user_no) {
		return mypageDao.customReplyByUserno(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public List<Free_board_reply> freeBoardReplySelectAll(int user_no) {
		return mypageDao.freeBoardReplyByUserno(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public List<Official_reply> officialReplySelectAll(int user_no) {
		return mypageDao.officialReplyByUserno(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public void update(HttpServletRequest req) {

//		// 유저정보 DTO객체
		User_info user_info = null;

		// 첨부파일 정보 DTO객체
		Attachment_profile attachment_profile = null;

		// 파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

		}

		user_info = new User_info();

		// 디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); // 1MB

		// 임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); // 임시 저장소 폴더 생성
		factory.setRepository(repository); // 임시 저장소 폴더 지정

		// 파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); // 10MB

		// 전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) { // 모든 요청 정보 처리
			FileItem item = iter.next();

			// --- 1) 빈 파일에 대한 처리 ---
			if (item.getSize() <= 0) {
				continue; // 빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}

//			User_info user_info = new User_info();

			// --- 2) form-data에 대한 처리 ---
			if (item.isFormField()) {
				// 키 추출하기
				String key = item.getFieldName();

				// 값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				// 키(name)에 따라서 value저장하기
				if ("user_no".equals(key)) {
					user_info.setUser_no(Integer.parseInt(value));
				} else if ("user_password".equals(key)) {
					user_info.setUser_password(value);
				} else if ("user_nickname".equals(key)) {
					user_info.setUser_nickname(value);
				}

			} // if( item.isFormField() ) end

			// --- 3) 파일에 대한 처리 ---
			if (!item.isFormField()) {

				// 로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); // 폴더 생성

				// 업로드 파일 객체
				String origin = item.getName(); // 원본파일명
				File up = new File(upFolder, origin);

				try {
					item.write(up); // 실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); // 임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}

				attachment_profile = new Attachment_profile();
				attachment_profile.setProfile_name(origin);

			} // if( !item.isFormField() ) end
		} // while( iter.hasNext() ) end

		// DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		if (user_info != null) {
			if (mypageDao.update(conn, user_info) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

//		if (attachment_profile == null) {
//
//			if (mypageDao.insertFile(conn, attachment_profile) > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
//		}
		if (attachment_profile != null) {

			if (mypageDao.updateProfile(conn, user_info, attachment_profile) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		}
//		return user_info;

	}

	@Override
	public void unregister(User_info user_info, String password) {

		Connection conn = JDBCTemplate.getConnection();

		if (password.equals(user_info.getUser_password())) {

			int user_no = user_info.getUser_no();

			if (mypageDao.delete(conn, user_no) > 0) {
				JDBCTemplate.commit(conn);
			}
		} else {

			JDBCTemplate.rollback(conn);

		}

	}

	@Override
	public User_info getUserInfoAll(int user_no) {

		return mypageDao.unregsterUserInfoByUserNo(JDBCTemplate.getConnection(), user_no);
	}

	@Override
	public void write(HttpServletRequest req) {

		// **첨부파일 추가하여 글 작성 처리

		// 게시글 정보 DTO 객체
		Qna_board board = null;

		// 첨부파일 정보 DTO 객체
		Qna_board_attachment boardFile = null;

		// 파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; // write() 메소드 중단
		}

		// 게시글 정보를 저장할 DTO객체 생성
		board = new Qna_board();

		// 디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); // 1MB

		// 임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); // 임시 저장소 폴더 생성
		factory.setRepository(repository); // 임시 저장소 폴더 지정

		// 파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); // 10MB

		// 전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) { // 모든 요청 정보 처리
			FileItem item = iter.next();

			// --- 1) 빈 파일에 대한 처리 ---
			if (item.getSize() <= 0) {
				continue; // 빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}

			// --- 2) form-data에 대한 처리 ---
			if (item.isFormField()) {
				// 키 추출하기
				String key = item.getFieldName();

				// 값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				// 키(name)에 따라서 value저장하기
				if ("title".equals(key)) {
					board.setQna_board_title(value);
				} else if ("content".equals(key)) {
					board.setQna_board_content(value);
				}

			} // if( item.isFormField() ) end

			// --- 3) 파일에 대한 처리 ---
			if (!item.isFormField()) {

				// UUID 생성
				UUID uuid = UUID.randomUUID(); // 랜덤 UUID
				String uid = uuid.toString().split("-")[0]; // 8자리 uuid

				// 로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); // 폴더 생성

				// 업로드 파일 객체
				String origin = item.getName(); // 원본파일명
				String stored = origin + "_" + uid; // 원본파일명_uid
				File up = new File(upFolder, stored);

				try {
					item.write(up); // 실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); // 임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 업로드된 파일의 정보 저장
				boardFile = new Qna_board_attachment();
				boardFile.setOriginal_file_name(origin);
				boardFile.setStored_file_name(stored);
				boardFile.setFile_size((int) item.getSize());

			} // if( !item.isFormField() ) end
		} // while( iter.hasNext() ) end

		// DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		int board_no = mypageDao.getNextBoardno(conn);

//		HttpSession session = req.getSession();

//		User_info user_info = ((User_info) session.getAttribute("user_info"));

//		int user_no = user_info.getUser_no();

		HttpSession session = req.getSession();

		int user_no = (int) session.getAttribute("user_no");

//		User_info user_info = mypageDao.selectUserInfoByUserNo(conn, user_no);

		// 게시글 정보가 있을 경우
		if (board != null) {

			board.setUser_no(user_no);
			board.setQna_board_no(board_no);

			if (board.getQna_board_title() == null || "".equals(board.getQna_board_title())) {
				board.setQna_board_title("(제목없음)");
			}

			if (mypageDao.insertQna(conn, board) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

		// 첨부파일 정보가 있을 경우
		if (boardFile != null) {

			int attach_no = mypageDao.getNextAttachno(conn);
			boardFile.setAttach_no(attach_no);

			boardFile.setQna_board_no(board_no); // 게시글 번호 입력 (FK)

			if (mypageDao.insertFile(conn, boardFile) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

	}

	@Override
	public Qna_board getBoardno(HttpServletRequest req) {

		// boardno를 저장할 객체 생성
		Qna_board boardno = new Qna_board();

		// boardno 전달파라미터 검증 - null, ""
		String param = req.getParameter("boardno");
		if (param != null && !"".equals(param)) {

			// boardno 전달파라미터 추출

			boardno.setQna_board_no(Integer.parseInt(param));
		}

		// 결과 객체 반환
		return boardno;
	}

	@Override
	public List<Qna_board> qnaBoardSelectAll(int user_no) {
		return mypageDao.QnaBoardByUserno(JDBCTemplate.getConnection(), user_no);

	}

	@Override
	public Qna_board view(Qna_board boardno) {

		Connection conn = JDBCTemplate.getConnection();

		Qna_board qna_board = mypageDao.selectQnaBoardByBoardno(conn, boardno);

		return qna_board;
	}

	@Override
	public Qna_board_attachment viewFile(Qna_board viewBoard) {

		return mypageDao.selectFile(JDBCTemplate.getConnection(), viewBoard);

	}

	@Override
	public void deleteQna(Qna_board board) {

		Connection conn = JDBCTemplate.getConnection();

		if (mypageDao.deleteFile(conn, board) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		if (mypageDao.delete(conn, board) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

	@Override
	public void updateQna(HttpServletRequest req) {
		// 게시글 정보 DTO 객체
		Qna_board board = null;

		// 첨부파일 정보 DTO 객체
		Qna_board_attachment boardFile = null;

		// 파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; // write() 메소드 중단
		}

		// 게시글 정보를 저장할 DTO객체 생성
		board = new Qna_board();

		// 디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); // 1MB

		// 임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); // 임시 저장소 폴더 생성
		factory.setRepository(repository); // 임시 저장소 폴더 지정

		// 파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); // 10MB

		// 전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) { // 모든 요청 정보 처리
			FileItem item = iter.next();

			// --- 1) 빈 파일에 대한 처리 ---
			if (item.getSize() <= 0) {
				continue; // 빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}

			// --- 2) form-data에 대한 처리 ---
			if (item.isFormField()) {
				// 키 추출하기
				String key = item.getFieldName();

				// 값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				// 키(name)에 따라서 value저장하기

				if ("boardno".equals(key)) {
					board.setQna_board_no(Integer.parseInt(value));
				} else if ("title".equals(key)) {
					board.setQna_board_title(value);
				} else if ("content".equals(key)) {
					board.setQna_board_content(value);
				}

			} // if( item.isFormField() ) end

			// --- 3) 파일에 대한 처리 ---
			if (!item.isFormField()) {

				// UUID 생성
				UUID uuid = UUID.randomUUID(); // 랜덤 UUID
				String uid = uuid.toString().split("-")[0]; // 8자리 uuid

				// 로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); // 폴더 생성

				// 업로드 파일 객체
				String origin = item.getName(); // 원본파일명
				String stored = origin + "_" + uid; // 원본파일명_uid
				File up = new File(upFolder, stored);

				try {
					item.write(up); // 실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); // 임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 업로드된 파일의 정보 저장
				boardFile = new Qna_board_attachment();
				boardFile.setOriginal_file_name(origin);
				boardFile.setStored_file_name(stored);
				boardFile.setFile_size((int) item.getSize());

			} // if( !item.isFormField() ) end
		} // while( iter.hasNext() ) end

		// DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

//		HttpSession session = req.getSession();

//		User_info user_info = ((User_info) session.getAttribute("user_info"));

//		int user_no = user_info.getUser_no();

		// 게시글 정보가 있을 경우
		if (board != null) {

			if (board.getQna_board_title() == null || "".equals(board.getQna_board_title())) {
				board.setQna_board_title("(제목없음)");
			}

			if (mypageDao.update(conn, board) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

		// 첨부파일 정보가 있을 경우
		if (boardFile != null) {

			int attach_no = mypageDao.getNextAttachno(conn);
			boardFile.setAttach_no(attach_no);
			boardFile.setQna_board_no(board.getQna_board_no()); // 게시글 번호 입력 (FK)
			if (mypageDao.insertFile(conn, boardFile) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

	}

	@Override
	public User_admin getLoginAdmin_info(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		User_admin user_admin = new User_admin();

		user_admin.setAdmin_id(req.getParameter("user_email"));
		user_admin.setAdmin_pw(req.getParameter("user_password"));

		return user_admin;

	}

	public boolean login(User_admin user_admin) {
		if (mypageDao.loginAdmin(JDBCTemplate.getConnection(), user_admin) > 0) {
			return true; // 로그인 성공
		} else {
			return false; // 로그인 실패
		}
	}

	@Override
	public List<Qna_board> getListQnaBoard() {
		return mypageDao.selectAllQna(JDBCTemplate.getConnection());

	}

	@Override
	public Qna_board qnaBoardByuserno(int user_no) {
		Qna_board qna_board = mypageDao.QnaBoardInstanceByUserno(JDBCTemplate.getConnection(), user_no);
		return qna_board;
	}

	@Override
	public Qna_board qnaBoardByBoardno(Qna_board qna_board) {
		Qna_board qnaBoard = mypageDao.selectQnaBoardByBoardno(JDBCTemplate.getConnection(), qna_board);
		return qnaBoard;
	}

	@Override
	public Qna_board qnaBoardByBoardno(int boardno) {
		Qna_board qnaBoard = new Qna_board();
		qnaBoard.setQna_board_no(boardno);

		Qna_board qna_Board = mypageDao.selectQnaBoardByBoardno(JDBCTemplate.getConnection(), qnaBoard);
		return qna_Board;
	}

	@Override
	public void insertMessage(HttpServletRequest req, Qna_board qna_board, int user_no) {
		// DB연결 객체
		Message message = new Message();

		Connection conn = JDBCTemplate.getConnection();
		int msgNo = mypageDao.selectNextMessageNo(conn);
		message.setMsg_no(msgNo);

		message.setMsg_send(user_no);
		message.setMsg_rec(qna_board.getUser_no());
		// user_no 전달파라미터 검증 - null, ""
		String param = req.getParameter("message");
		try {
			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		if (param != null && !"".equals(param)) {
			message.setMsg_content(param);
		}

		if (mypageDao.insertMessage(conn, message) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

	@Override
	public List<Message> recMessageSelect(int user_no) {
		return mypageDao.recMessageByUserno(JDBCTemplate.getConnection(), user_no);

	}

	@Override
	public List<Message> sendMessageSelect(int user_no) {
		return mypageDao.sendMessageByUserno(JDBCTemplate.getConnection(), user_no);
	}

//	@Override
//	public void insertMsg(HttpServletRequest req, int user_no, int msg_rec) {
//
//		// DB연결 객체
//		Message message = new Message();
//
//		Connection conn = JDBCTemplate.getConnection();
//		int msgNo = mypageDao.selectNextMessageNo(conn);
//		message.setMsg_no(msgNo);
//		System.out.println("인서트메세지" + msg_rec);
//		message.setMsg_send(user_no);
//		message.setMsg_rec(msg_rec);
//		// user_no 전달파라미터 검증 - null, ""
//		String param = req.getParameter("msg");
//		try {
//			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
//
//		if (param != null && !"".equals(param)) {
//			message.setMsg_content(param);
//		}
//
//		if (mypageDao.insertMessage(conn, message) > 0) {
//			JDBCTemplate.commit(conn);
//		} else {
//			JDBCTemplate.rollback(conn);
//		}
//
//	}

	@Override
	public Free_board selectFreeBoard(int boardno) {
		return mypageDao.getFreeBoardByFreeBoardNo(JDBCTemplate.getConnection(), boardno);
	}

	@Override
	public void FreeBoardInsertMessage(HttpServletRequest req, Free_board free_board, int user_no) {
		// DB연결 객체
		Message message = new Message();

		Connection conn = JDBCTemplate.getConnection();
		int msgNo = mypageDao.selectNextMessageNo(conn);
		message.setMsg_no(msgNo);

		message.setMsg_send(user_no);
		message.setMsg_rec(free_board.getUser_no());
		// user_no 전달파라미터 검증 - null, ""
		String param = req.getParameter("message");
		try {
			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		if (param != null && !"".equals(param)) {
			message.setMsg_content(param);
		}

		if (mypageDao.insertMessage(conn, message) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

	@Override
	public void CustomBoardInsertMessage(HttpServletRequest req, Custom_board custom_board, int user_no) {
		// DB연결 객체
		Message message = new Message();

		Connection conn = JDBCTemplate.getConnection();
		int msgNo = mypageDao.selectNextMessageNo(conn);
		message.setMsg_no(msgNo);

		message.setMsg_send(user_no);
		message.setMsg_rec(custom_board.getUser_no());
		// user_no 전달파라미터 검증 - null, ""
		String param = req.getParameter("message");
		try {
			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		if (param != null && !"".equals(param)) {
			message.setMsg_content(param);
		}

		if (mypageDao.insertMessage(conn, message) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

	@Override
	public void writeQnaReply(Qna_board_reply qna_board_reply) {
		
		Connection conn = JDBCTemplate.getConnection();
		int qna_reply_no = mypageDao.getNextQnaReplyNo(conn);
		
		qna_board_reply.setQna_reply_no(qna_reply_no);
		
		if( mypageDao.insertQnaReply(conn, qna_board_reply) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	
	@Override
	public List<Qna_board_reply> getReply() {
		List<Qna_board_reply> qna_board_reply = mypageDao.selectQnaBoardReply(JDBCTemplate.getConnection());
		System.out.println("qnaboardreply : " +qna_board_reply);
		return qna_board_reply;
	}
	
	
	@Override
	public void msgCheck(int user_no) {
		
		Connection conn = JDBCTemplate.getConnection();
		if( mypageDao.updateMsgCheck(conn, user_no) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	
}// class