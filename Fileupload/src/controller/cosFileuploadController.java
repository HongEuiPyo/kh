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
		
		//--- multipart/form-data 검증 ---
		
		//파일 업로드 형식이 아닐 경우에 대한 처리
		if( !ServletFileUpload.isMultipartContent(req) ) {
			
			//에러페이지에 전달할 메시지 작성 - MODEL값
			req.setAttribute("msg", "form태그의 enctype속성이 안 맞습니다");
			
			
			req.setAttribute("alertMsg", "경고!");
			req.setAttribute("redirectUrl", "/file/list");
			
			req.getRequestDispatcher("/WEB-INF/views/file/error.jsp").forward(req, resp);
			
			//doPost()메소드 중단 시키기
			//	-> return하지 않으면 아래쪽 자바코드는 그대로 실행된다
			return;
		}
		
		System.out.println("TEST - forward 이후 실행 코드");
		//------------------------------
		
		//--- MultipartRequest 생성자 매개변수 준비 ---
		//1. 요청 정보 객체
		//	-> req
		
		//2. 파일 저장 위치
		String saveDirectory = getServletContext().getRealPath("upload");
		
		//3. 업로드 제한 크기
		int maxPostSize = 10 * 1024 * 1024; // 10MB
		
		//4. 인코딩
		String encoding = "UTF-8";
		
		
		//5. 중복된 파일이름을 처리하는 정책
		FileRenamePolicy policy = new DefaultFileRenamePolicy();	
		//----------------------------------------------
		
		
		//** DefaultFileRenamePolicy 클래스
		//	중복된 파일이름이 있을 경우 파일이름의 마지막에 번호를 붙여서 처리한다
		//	-> 자동으로 1부터 1씩 증가하면서 부여된다
		
		
		//--- COS파일 업로드 객체 생성 ---
		MultipartRequest mul = new MultipartRequest(
				req,
				saveDirectory,
				maxPostSize,
				encoding,
				policy
				);
		//----------------------------------------------
		
		//원본 파일 이름
		String origin = mul.getOriginalFileName(null);
		
		fileService.filesave(up);
		
		System.out.println( mul.getParameter("title"));
		System.out.println( mul.getParameter("nick"));
		
		resp.sendRedirect("/file/list");
		
	}
	
}




















