package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;
import service.face.FileService;
import service.impl.FileServiceImpl;

@WebServlet("/commons/fileupload")
public class CommonsFileuploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/commons/fileupload [GET]");
		
		//View지정하고 포워드(forward)
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/commons/fileupload [POST]");
		
		
		fileService.fileupload(req, resp);
		
		//파일 목록페이지로 리다이렉트 [응답]
		resp.sendRedirect("/file/list");
		
		
		//------------------------------------------------------
		
		//전달파라미터 확인 - 데이터 못 받음
//		System.out.println("title : " + req.getParameter("title"));
//		System.out.println("data1 : " + req.getParameter("data1"));
//		System.out.println("data2 : " + req.getParameter("data2"));
//		System.out.println("upfile : " + req.getParameter("upfile"));
		
		// <form>태그의 데이터인코딩방식(enctype)을
		//multipart/form-data로 설정하면 getParameter()메소드로
		//전달 데이터를 추출할 수 없다
		//	-> 파일 업로드 라이브러리를 이용해야만 가능하다		
	
	}
	
	//파일 정보를 저장할 DTO 객체
	UploadFile up = new UploadFile();
	up.setOriginName(origin);
	
	
	
}


















