package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class cosFileuploadController
 */
@WebServlet("/cos/fileupload")
public class cosFileuploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FileService
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cos/fileupload [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/cos/fileupload.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cos/fileupload [POST]");
		
		//--- multipart/form-data ���� ---
		
		//���� ���ε� ������ �ƴ� ��쿡 ���� ó��
		if( !ServletFileUpload.isMultipartContent(req) ) {
			
			//������������ ������ �޽��� �ۼ� - MODEL��
			req.setAttribute("msg", "form�±��� enctype�Ӽ��� �� �½��ϴ�");
			
			
			req.setAttribute("alertMsg", "���!");
			req.setAttribute("redirectUrl", "/file/list");
			
			req.getRequestDispatcher("/WEB-INF/views/file/error.jsp").forward(req, resp);
			
			//doPost()�޼ҵ� �ߴ� ��Ű��
			//	-> return���� ������ �Ʒ��� �ڹ��ڵ�� �״�� ����ȴ�
			return;
		}
		
		System.out.println("TEST - forward ���� ���� �ڵ�");
		//------------------------------
		
		//--- MultipartRequest ������ �Ű����� �غ� ---
		//1. ��û ���� ��ü
		//	-> req
		
		//2. ���� ���� ��ġ
		String saveDirectory = getServletContext().getRealPath("upload");
		
		//3. ���ε� ���� ũ��
		int maxPostSize = 10 * 1024 * 1024; // 10MB
		
		//4. ���ڵ�
		String encoding = "UTF-8";
		
		
		//5. �ߺ��� �����̸��� ó���ϴ� ��å
		FileRenamePolicy policy = new DefaultFileRenamePolicy();	
		//----------------------------------------------
		
		
		//** DefaultFileRenamePolicy Ŭ����
		//	�ߺ��� �����̸��� ���� ��� �����̸��� �������� ��ȣ�� �ٿ��� ó���Ѵ�
		//	-> �ڵ����� 1���� 1�� �����ϸ鼭 �ο��ȴ�
		
		
		//--- COS���� ���ε� ��ü ���� ---
		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy
				);
		//----------------------------------------------
		
		//���� ���� �̸�
		String origin = mul.getOriginalFileName(null);
		
		fileService.filesave(up);
		
		System.out.println( mul.getParameter("title"));
		System.out.println( mul.getParameter("nick"));
		
		resp.sendRedirect("/file/list");
		
	}
	
}




















