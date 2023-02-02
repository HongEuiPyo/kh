package free.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import free.dao.face.BoardDao;
import free.dao.face.MemberDao;
import free.dao.impl.BoardDaoImpl;
import free.dao.impl.MemberDaoImpl;
import free.dto.BoardFile;
import free.dto.FreeBoard;
import free.dto.FreeReply;
import free.dto.Member;
import free.service.face.BoardService;
import free.util.Paging;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDaoImpl();
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		System.out.println("boardService.getPaging() ");

		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}else {
			System.out.println("[WARNING] curPage값이 null이거나 비어있습니다");
		}

		int totalCount = boardDao.selectCntAll(JDBCTemplate.getConnection());

		Paging paging = new Paging(totalCount, curPage);


		return paging;
	}
	


	@Override
	public List<FreeBoard> getList(Paging paging) {
		return boardDao.selectAll(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public FreeBoard getFreeBoardDetail(HttpServletRequest req) {

		FreeBoard board = new FreeBoard();

		board.setFree_board_no(Integer.parseInt(req.getParameter("freeboardno")));
		System.out.println("boardno: " + req.getParameter("freeboardno"));
		
		int res = boardDao.SearchByBoardNo(JDBCTemplate.getConnection(), board);

		if( res <= 0 ) {
			System.out.println("[ERROR] 해당 게시글이 존재하지 않습니다");
			return null;
		}

		System.out.println("res = " + res);

		boardDao.Hit(JDBCTemplate.getConnection(), board);

		board = boardDao.getFreeBoardByFreeBoardNo(JDBCTemplate.getConnection(), board);

		return board;
	}

	@Override
	public void write(HttpServletRequest req) {

		System.out.println("boardService.write()");

		FreeBoard freeBoard = null;
		BoardFile boardFile = null;

		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; //write() 메소드 중단
		}

		freeBoard = new FreeBoard();


		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1*1024*1024); // 1MB

		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir();
		factory.setRepository(repository);//임시 저장소 폴더 지정




		//파일 업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setFileSizeMax(10*1024*1024);



		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<FileItem> iter = items.iterator();

		while(iter.hasNext()) {
			FileItem item = iter.next();

			if( item.getSize() <= 0 ) {
				continue;
			}


			if(item.isFormField()) {
				String key = item.getFieldName();

				String value = null;

				try {
					value = item.getString("UTF-8");
				}catch(UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				if("title".equals(key)) {
					freeBoard.setFree_board_title(value);
				}else if("content".equals(key)) {
					freeBoard.setFree_board_content(value);
				}

			}

			if( !item.isFormField()) {

				UUID uuid = UUID.randomUUID();
				String uid = uuid.toString().split("-")[0];

				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir();

				String origin = item.getName();
				String stored = origin + "_" + uid;

				File up = new File(upFolder, stored);


				try{
					item.write(up);
					item.delete();
				}catch(Exception e) {
					e.printStackTrace();
				}

				boardFile = new BoardFile();
				boardFile.setOriginal_file_name(origin);
				boardFile.setStored_file_name(stored);
				boardFile.setFile_size( (int)item.getSize());
			}
		}

		Connection conn = JDBCTemplate.getConnection();

		int freeBoardno = boardDao.selectNextFreeBoardno(conn);
		int attachno = boardDao.selectNextAttachno(conn);


		//게시글 정보가 있을 경우
		if(freeBoard != null) {

			//작성자 userid 입력
			freeBoard.setUser_no((int)req.getSession().getAttribute("user_no"));
			System.out.println("user_no: " + freeBoard.getUser_no());

			freeBoard.setFree_board_no(freeBoardno); //게시글 번호 입력 (PK)

			if(freeBoard.getFree_board_title()==null || "".equals(freeBoard.getFree_board_title())) {
				freeBoard.setFree_board_title("(제목없음)");
			}

			if( boardDao.insertIntoFreeBoard(conn, freeBoard) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("success insert into freeboard");
			} else {
				JDBCTemplate.rollback(conn);
				System.out.println("fail insert into freeboard");
			}
		}

		//첨부파일 정보가 있을 경우
		if(boardFile != null) {
			boardFile.setAttach_no(attachno); //게시글 번호 입력 (PK)
			boardFile.setFree_board_no(freeBoardno);

			if( boardDao.insertFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("insert into attachment clear");
			} else {
				JDBCTemplate.rollback(conn);	
				System.out.println("fail to insert into attachment");
			}
		}





	}

	@Override
	public BoardFile getAttachment(BoardFile boardFile) {

		return boardDao.getAttachmentByAttachNo(JDBCTemplate.getConnection(),boardFile);
	}

	@Override
	public void update(HttpServletRequest req) {
		System.out.println("boardService.update()");

		FreeBoard freeBoard = null;
		BoardFile boardFile = null;

		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);

		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");

			return; //write() 메소드 중단
		}

		freeBoard = new FreeBoard();


		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1*1024*1024); // 1MB

		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir();
		factory.setRepository(repository);//임시 저장소 폴더 지정




		//파일 업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setFileSizeMax(10*1024*1024);



		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<FileItem> iter = items.iterator();

		while(iter.hasNext()) {
			FileItem item = iter.next();

			if( item.getSize() <= 0 ) {
				continue;
			}


			if(item.isFormField()) {
				String key = item.getFieldName();

				String value = null;

				try {
					value = item.getString("UTF-8");
				}catch(UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				if("title".equals(key)) {
					freeBoard.setFree_board_title(value);
				}else if("content".equals(key)) {
					freeBoard.setFree_board_content(value);
				}

			}

			if( !item.isFormField()) {

				UUID uuid = UUID.randomUUID();
				String uid = uuid.toString().split("-")[0];

				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir();

				String origin = item.getName();
				String stored = origin + "_" + uid;

				File up = new File(upFolder, stored);


				try{
					item.write(up);
					item.delete();
				}catch(Exception e) {
					e.printStackTrace();
				}

				boardFile = new BoardFile();
				boardFile.setOriginal_file_name(origin);
				boardFile.setStored_file_name(stored);
				boardFile.setFile_size( (int)item.getSize());
			}
		}

		Connection conn = JDBCTemplate.getConnection();


		int freeBoardno = Integer.parseInt(req.getParameter("freeboardno"));
		

		//게시글 정보가 있을 경우
		if(freeBoard != null) {
			
			
			System.out.println("freeBoardno: " + freeBoardno);
			
			freeBoard.setFree_board_no(freeBoardno); //게시글 번호 입력 (PK)

			if(freeBoard.getFree_board_title()==null || "".equals(freeBoard.getFree_board_title())) {
				freeBoard.setFree_board_title("(제목없음)");
			}
	
			if( boardDao.updateFreeBoard(conn, freeBoard) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("success insert into freeboard");
			} else {
				JDBCTemplate.rollback(conn);
				System.out.println("fail insert into freeboard");
			}
		}
		
		//첨부파일 정보가 있을 경우
		if(boardFile != null) {

			boardFile.setFree_board_no(freeBoardno);
			

			if( boardDao.updateFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("insert into attachment clear");
			} else {
				JDBCTemplate.rollback(conn);	
				System.out.println("fail to insert into attachment");
			}
		}




	}

	@Override
	public BoardFile getBoardFile(HttpServletRequest req) {
		
		BoardFile boardFile = new BoardFile();
		boardFile.setFree_board_no(Integer.parseInt(req.getParameter("freeboardno")));
		return boardDao.getFreeboardAttachmentByFreeBoardNo(JDBCTemplate.getConnection(), boardFile );
	}

	@Override
	public void delete(HttpServletRequest req) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		FreeBoard freeBoard = new FreeBoard();
		
		freeBoard.setFree_board_no(Integer.parseInt(req.getParameter("freeboardno")));
		
		BoardFile boardFile = new BoardFile();
		boardFile.setFree_board_no(freeBoard.getFree_board_no());
		boardFile = boardDao.getFreeboardAttachmentByFreeBoardNo(conn, boardFile);
		
		if(boardDao.deleteFreeBoardAttachment(conn, boardFile) > 0 ) {
			System.out.println("delete file");
			JDBCTemplate.commit(conn);
		}else {
			System.out.println("fail to delete file");
			JDBCTemplate.rollback(conn);
		}
		
		if(	boardDao.deleteFreeBoardByFreeBoardNo(JDBCTemplate.getConnection(), freeBoard) > 0) {
			System.out.println("delete file");
			JDBCTemplate.commit(conn);
		}else {
			System.out.println("fail to delete file");
			JDBCTemplate.rollback(conn);
		}
		
		
	}

	@Override
	public List<FreeBoard> getList(Paging paging, HttpServletRequest req) {
		
		paging.setStartNo(0);
		paging.setEndNo(Integer.MAX_VALUE);
		
		List<FreeBoard> boardList = boardDao.selectAll(JDBCTemplate.getConnection(), paging);

		List<FreeBoard> result_boardList = new ArrayList<>();
		
		for(FreeBoard freeboard: boardList) {
			
			String type = req.getParameter("type");
			String search = req.getParameter("search");
			
			if(type.equals("writer") && freeboard.getUser_nickname().equals(search)) {
				System.out.println(freeboard.getUser_nickname().equals(search));
				result_boardList.add(freeboard);
			}else if(type.equals("title") && freeboard.getFree_board_title().contains(search)) {
				System.out.println("list add");
				result_boardList.add(freeboard);
			}else if(type.equals("content") && freeboard.getFree_board_content().contains(search)) {
				System.out.println("list add");
				result_boardList.add(freeboard);
			}
		}		
		
		return result_boardList;
	}

	@Override
	public void insertReply(HttpServletRequest req) {
		
		FreeReply freeReply = new FreeReply();
		
//		freeReply.setUser_no(Integer.parseInt(req.getParameter("user_no")));
		freeReply.setUser_no((int)req.getSession().getAttribute("user_no"));
		freeReply.setFree_board_no(Integer.parseInt(req.getParameter("freeboardno")));
		freeReply.setFree_reply_content(req.getParameter("content"));
		
		System.out.println("freeboardno: " + freeReply.getFree_board_no());
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = boardDao.insertReply(conn, freeReply);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	@Override
	public List<FreeReply> getReply(HttpServletRequest req) {
		FreeReply freeReply = new FreeReply();
		System.out.println("freeboardno: " + req.getParameter("freeboardno"));
		int freeboardno = Integer.parseInt(req.getParameter("freeboardno"));
		System.out.println("freeboardno:" + freeboardno);
		freeReply.setFree_board_no(freeboardno);
		
		
		return boardDao.selectAllReplyByFreeboardno(JDBCTemplate.getConnection(), freeReply);
	}

	@Override
	public void deleteComment(HttpServletRequest req) {
		FreeReply freeReply = new FreeReply();
		
		System.out.println("req.getParameter(replyno)" + req.getParameter("free_reply_no"));
		
		freeReply.setFree_reply_no(Integer.parseInt(req.getParameter("free_reply_no")));
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( boardDao.deleteFreeReplyByNo(conn, freeReply) > 0 ) {
			System.out.println("delete reply");
			JDBCTemplate.commit(conn);
		}else {
			System.out.println("delete fail");
			JDBCTemplate.rollback(conn);
		}
		
	}



	@Override
	public Member getuser_nickname(HttpServletRequest req) {
		Member member = new Member();
		member.setUser_no((Integer)req.getSession().getAttribute("user_no"));
		
		
		return memberDao.selectMemberByUserid(JDBCTemplate.getConnection(), member);  
	}




	
	/*
	@Override
	public void updateLike(HttpServletRequest req) {
		int res = -1;
		
		Connection conn = JDBCTemplate.getConnection();	

		FreeBoard freeBoard = new FreeBoard();
		freeBoard.setFree_board_no(Integer.parseInt(req.getParameter("freeboardno")));
		
		if(req.getParameter("btnlike").equals("false")) {
			res = boardDao.PlusLike(conn, freeBoard);
		}else {
			res = boardDao.MinusLike(conn, freeBoard);
		}
		
		if(res>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
				
	}

	@Override
	public FreeBoard getVote(HttpServletRequest req) {
		FreeBoard freeBoard = new FreeBoard();

		return boardDao.getLike(JDBCTemplate.getConnection(), freeBoard);
	}
	*/

}
