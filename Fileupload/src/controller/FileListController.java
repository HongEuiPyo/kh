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

	
	//���� ��ü
	private FileService fileService = new FileServiceImpl();
	
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/file/list [GET]");
	
	
		//���� ���� ��ü ��ȸ�ϱ� - FileService �̿�
		List<UploadFile> list = fileService.list();
	
		
		
		
		
		//��ȸ����� �𵨰����� �����ϱ�
		req.setAttribute("list", list);
	
	
	
		//VIEW ���� & forward
		req.getRequestDispatcher("/WEB-INF/views/file/list.jsp");
	
	}


	
	
}



















