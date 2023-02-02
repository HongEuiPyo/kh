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

	//���� ��ü
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/commons/fileupload [GET]");
		
		//View�����ϰ� ������(forward)
		req.getRequestDispatcher("/WEB-INF/views/commons/fileupload.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/commons/fileupload [POST]");
		
		
		fileService.fileupload(req, resp);
		
		//���� ����������� �����̷�Ʈ [����]
		resp.sendRedirect("/file/list");
		
		
		//------------------------------------------------------
		
		//�����Ķ���� Ȯ�� - ������ �� ����
//		System.out.println("title : " + req.getParameter("title"));
//		System.out.println("data1 : " + req.getParameter("data1"));
//		System.out.println("data2 : " + req.getParameter("data2"));
//		System.out.println("upfile : " + req.getParameter("upfile"));
		
		// <form>�±��� ���������ڵ����(enctype)��
		//multipart/form-data�� �����ϸ� getParameter()�޼ҵ��
		//���� �����͸� ������ �� ����
		//	-> ���� ���ε� ���̺귯���� �̿��ؾ߸� �����ϴ�		
	
	}
	
	//���� ������ ������ DTO ��ü
	UploadFile up = new UploadFile();
	up.setOriginName(origin);
	
	
	
}


















