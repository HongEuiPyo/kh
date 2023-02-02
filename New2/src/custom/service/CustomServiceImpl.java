package custom.service;

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
import custom.dao.CustomDao;
import custom.dao.CustomDaoImpl;
import custom.dto.Custom;
import custom.dto.CustomComment;
import custom.dto.CustomFile;
import custom.dto.Report;
import official.dao.OfficialDao;
import official.dao.OfficialDaoImpl;
import official.dto.Official;
import official.dto.OfficialComment;
import util.Paging;

public class CustomServiceImpl implements CustomService{
	
	//CustomDao 객체 생성
	private CustomDao customDao = new CustomDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달 파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[CAUTION] curPage값이 null 또는 비어있습니다");
		}
		
		//Offical 테이블의 총 데이터 수(레시피 숫자)를 조회
		int totalCount = customDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;				
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req, String search, String category) {
		//전달 파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[CAUTION] curPage값이 null 또는 비어있습니다");
		}
		
		int totalCount = 0;
		
		//검색어로 검색한 테이블의 반환 데이터 수(레시피 숫자)를 조회
		if( "all".equals(category) ) {
			totalCount = customDao.selectCntSearchAll(JDBCTemplate.getConnection(), search);
		} else {
			totalCount = customDao.selectCntSearch(JDBCTemplate.getConnection(), search, category);
			//글쓴이 정보 가져오기 필요
		}
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;		
	}
	
	@Override
	public List<Custom> getList(Paging paging) {

		return customDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Custom> getList(Paging paging, String search, String category) {
		
		List<Custom> list = new ArrayList<>();
		
		if( "all".equals(category)) {
			list = customDao.selectSearchAll(JDBCTemplate.getConnection(), paging, search);
		} else {
			list = customDao.selectSearch(JDBCTemplate.getConnection(), paging, search, category);
		}
		
		return list;
	}
	
	@Override
	public Custom getCustom_no(HttpServletRequest req) {
		
		//Custom 객체 생성
		Custom customno = new Custom();
		
		System.out.println("[Serv] custom_no : " + req.getParameter("custom_no"));
		
		//customno 전달 파라미터 검증 - null or ""
		String param = req.getParameter("custom_no");
		
		if(param != null && !"".equals(param)) {
			//custom_no 전달 파라미터 추출
			customno.setCustom_board_no(Integer.parseInt(param));
		}
		
		//결과 Custom 객체 반환
		return customno;
	}
	
	@Override
	public Custom view(Custom custom_board_no) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		//조회수 증가 
		if( customDao.updateHit(connection, custom_board_no) > 0 ) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		
		//게시글 조회
		Custom custom = customDao.selectCustomByCustomno(connection, custom_board_no);
		
		System.out.println("[Serv] custom : " + custom);
		
		custom.setUser_nickname(customDao.selectNickByUserno(connection, custom));
		
		System.out.println("[Serv] custom(afternick) : " + custom);
			
		return custom;
	}
	
	@Override
	public void write(HttpServletRequest req) {
		
		//게시글 정보 DTO 객체
		Custom custom = null;
		
		//첨부파일 정보 DTO 객체
		CustomFile customFile = null;
			
		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");
			return; //write() 메소드 중단
		}
		
		//게시글 정보를 저장할 DTO객체 생성
		custom = new Custom();
		
		//디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); //1MB

		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); //임시 저장소 폴더 생성
		factory.setRepository(repository); //임시 저장소 폴더 지정
		
		//파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		//업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); //10MB
		
		//전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) { //모든 요청 정보 처리
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) {
				continue; //빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}
			
			//--- 2) form-data에 대한 처리 ---
			if( item.isFormField() ) {
				//키 추출하기
				String key = item.getFieldName();
				
				//값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				//키(name)에 따라서 value저장하기
				if( "custom_board_title".equals(key) ) {
					custom.setCustom_board_title( value );
				} else if( "content".equals(key) ) {
					custom.setCustom_board_content( value );
				}
				
			} //if( item.isFormField() ) end
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//UUID 생성
				UUID uuid = UUID.randomUUID(); //랜덤 UUID
				String uid = uuid.toString().split("-")[0]; //8자리 uuid
				
				//로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); //폴더 생성
				
				//업로드 파일 객체
				String origin = item.getName(); //원본파일명
				String stored = origin + "_" + uid; //원본파일명_uid
				File up = new File(upFolder, stored);
				
				try {
					item.write(up); //실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); //임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보 저장
				customFile = new CustomFile();
				customFile.setOriginal_file_name(origin);
				customFile.setStored_file_name(stored);
				customFile.setFile_size( (int)item.getSize() );
				
			} //if( !item.isFormField() ) end
		} //while( iter.hasNext() ) end
		
		//DB연결 객체
		Connection connection = JDBCTemplate.getConnection();
		
		//게시글 번호 생성 - DAO 이용
		int customno = customDao.selectNextCustomno(connection);
			
		//게시글 정보가 있을 경우
		if(custom != null) {
			
			//작성자 user_no 입력 
			custom.setUser_no( (Integer)req.getSession().getAttribute("user_no") );
			//테스트용 임시데이터
//			int user_no = 2;
//			custom.setUser_no( user_no );

			custom.setCustom_board_no(customno); //게시글 번호 입력 (PK)
			
			if(custom.getCustom_board_title()==null || "".equals(custom.getCustom_board_title())) {
				custom.setCustom_board_title("(제목없음)");
			}
			
			if( customDao.insert(connection, custom) > 0 ) {
				JDBCTemplate.commit(connection);
			} else {
				JDBCTemplate.rollback(connection);
			}
		}
		
		//첨부파일 정보가 있을 경우
		if(customFile != null) {
			customFile.setCustom_board_no(customno); //게시글 번호 입력 (FK)
			
			if( customDao.insertFile(connection, customFile) > 0 ) {
				JDBCTemplate.commit(connection);
			} else {
				JDBCTemplate.rollback(connection);
			}
		}
		
	}
	
	@Override
	public String getNick(Custom viewCustom) {
		return customDao.selectNickByUserno(JDBCTemplate.getConnection(), viewCustom);
	}
	
	@Override
	public CustomFile viewFile(Custom viewCustom) {
		return customDao.selectFile(JDBCTemplate.getConnection(), viewCustom);
	}
	
	@Override
	public void update(HttpServletRequest req) {
		//게시글 정보 DTO 객체
		Custom custom = null;
		
		//첨부파일 정보 DTO 객체
		CustomFile customFile = null;
		
		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님");
			
			return; //write() 메소드 중단
		}
		
		//게시글 정보를 저장할 DTO객체 생성
		custom = new Custom();
		
		//디스크기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 지정
		factory.setSizeThreshold(1 * 1024 * 1024); //1MB

		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir(); //임시 저장소 폴더 생성
		factory.setRepository(repository); //임시 저장소 폴더 지정
		
		//파일업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);

		//업로드 용량 제한
		upload.setFileSizeMax(10 * 1024 * 1024); //10MB
		
		//전달 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//파싱된 전달파라미터를 처리할 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) { //모든 요청 정보 처리
			FileItem item = iter.next();

			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) {
				continue; //빈 파일은 무시하고 다음 FileItem처리로 넘긴다
			}
			
			
			//--- 2) form-data에 대한 처리 ---
			if( item.isFormField() ) {
				//키 추출하기
				String key = item.getFieldName();
				
				//값 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}

				//키(name)에 따라서 value저장하기
				if( "custom_board_no".equals(key) ) {
					custom.setCustom_board_no( Integer.parseInt(value) );
				} else if( "custom_board_title".equals(key) ) {
					custom.setCustom_board_title( value );
				} else if( "content".equals(key) ) {
					custom.setCustom_board_content( value );
				}
				
			} //if( item.isFormField() ) end
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//UUID 생성
				UUID uuid = UUID.randomUUID(); //랜덤 UUID
				String uid = uuid.toString().split("-")[0]; //8자리 uuid
				
				//로컬 저장소의 업로드 폴더
				File upFolder = new File(req.getServletContext().getRealPath("upload"));
				upFolder.mkdir(); //폴더 생성
				
				//업로드 파일 객체
				String origin = item.getName(); //원본파일명
				String stored = origin + "_" + uid; //원본파일명_uid
				File up = new File(upFolder, stored);
				
				
				
				try {
					item.write(up); //실제 업로드(임시파일을 최종결과파일로 생성함)
					item.delete(); //임시파일을 삭제
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보 저장
				customFile = new CustomFile();
				customFile.setOriginal_file_name(origin);
				customFile.setStored_file_name(stored);
				customFile.setFile_size( (int)item.getSize() );
				
			} //if( !item.isFormField() ) end
		} //while( iter.hasNext() ) end
		
		
		//DB연결 객체
		Connection connection = JDBCTemplate.getConnection();
		
		//게시글 정보가 있을 경우
		if(custom != null) {
			if( customDao.update(connection, custom) > 0 ) {
				JDBCTemplate.commit(connection);
			} else {
				JDBCTemplate.rollback(connection);
			}
		}
		
		//첨부파일 정보가 있을 경우
		if(customFile != null) {
			customFile.setCustom_board_no(custom.getCustom_board_no()); //게시글 번호 입력 (FK)
			
			if( customDao.insertFile(connection, customFile) > 0 ) {
				JDBCTemplate.commit(connection);
			} else {
				JDBCTemplate.rollback(connection);
			}
		}
		
	}
	
	@Override
	public void delete(Custom custom) {
		Connection connection = JDBCTemplate.getConnection();
		
		if( customDao.deleteFile(connection, custom) > 0 ) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		
		if( customDao.delete(connection, custom) > 0 ) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}
		
	}
		
	@Override
	public List<CustomComment> getComment(Paging paging, Custom viewCustom) {
		
		List<CustomComment> comments = 
			customDao.selectComment(JDBCTemplate.getConnection(), paging, viewCustom);
		return comments;
	}
	
	@Override
	public void writeComment(CustomComment customComment) {
		System.out.println("writeComment() invoked");
		
		Connection conn = JDBCTemplate.getConnection();
		if( customDao.insertComment(conn, customComment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public void updateComment(CustomComment customComment) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		int result = customDao.updateComment(connection, customComment);
		
		//result 결과에 따라 commit, rollback
		if(result == 1) {
			System.out.println("수정 commit");
			JDBCTemplate.commit(connection);
		} else {
			System.out.println("수정 실패");
			JDBCTemplate.rollback(connection);				
		}
		
	}
	
	@Override
	public void deleteComment(CustomComment customComment) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		//게시글 데이터 delete
		if( customDao.delete(connection, customComment) > 0 ) {
			//게시글 삭제 성공 시
			System.out.println("[DELETE] 댓글 삭제 성공");
			JDBCTemplate.commit(connection);
		} else {
			System.out.println("[ERROR] 댓글 삭제 실패");
			JDBCTemplate.rollback(connection);
		}
	}
	
	@Override
	public void reportContent(Report report) {
		Connection conn = JDBCTemplate.getConnection();
		if( customDao.report(conn, report) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}	
	
}
