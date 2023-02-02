package custom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Custom;
import custom.dto.CustomFile;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;

/**
 * Servlet implementation class CustomUpdateController
 */
@WebServlet("/custom/update")
public class CustomUpdateController extends CustomServiceImpl {
	private static final long serialVersionUID = 1L;

	//CustomService 객체 생성
	private CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/update [GET]");
		
		//전달파라미터 얻기 - customno
		Custom customno = customService.getCustom_no(req);
		
		//상세보기 결과 조회
		Custom updateCustom = customService.view(customno);
		
		//닉네임 전달
		req.setAttribute("nick", customService.getNick(updateCustom));
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateCustom", updateCustom);

		//첨부파일 정보 VIEW에 전달
		CustomFile customFile = customService.viewFile(updateCustom);
		req.setAttribute("customFile", customFile);

		//VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/board/custom_update.jsp").forward(req, resp);		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		customService.update(req);
		
		resp.sendRedirect("/custom/list");
		
	}
}