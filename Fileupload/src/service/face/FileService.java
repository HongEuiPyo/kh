package service.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {

	/**
	 * 파일 업로드 처리
	 * 
	 * @param req - HTTP요청 정보 객체
	 * @param resp - HTTP응답 정보 객체
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	
	/**
	 * 파일 전체 목록을 조회한다
	 * 
	 * @return 조회된 전체  파일 목록
	 */
	public List<UploadFile> list();
	
	
	/**
	 * 업로드된 파일의 정보를 저장한다
	 * 
	 * @param up - 업로드 된 파일의 정보 DTO 객체
	 */
	public void filesave(UploadFile up);
	
	
}
