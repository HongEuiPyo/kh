package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

/**
 * Servlet implementation class FileListController
 */
@WebServlet("/file/list")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private FileService fileService = new FileServiceImpl();
	
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/file/list [GET]");
	
	
		//파일 정보 전체 조회하기 - FileService 이용
		List<UploadFile> list = fileService.list();
	
		
		
		
		
		//조회결과를 모델값으로 전달하기
		req.setAttribute("list", list);
	
	
	
		//VIEW 지정 & forward
		req.getRequestDispatcher("/WEB-INF/views/file/list.jsp");
	
	}


	
	
}



















