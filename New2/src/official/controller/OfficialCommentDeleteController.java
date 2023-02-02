package official.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import official.dto.OfficialComment;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;


/**
 * Servlet implementation class OfficialCommentDeleteController
 */
@WebServlet("/official/comment/delete")
public class OfficialCommentDeleteController extends OfficialServiceImpl {
	private static final long serialVersionUID = 1L;
    
	OfficialService officialService = new OfficialServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/official/delete [GET]");
		
		//세션 객체 생성
		HttpSession session = req.getSession();

		//요청파라미터 /official/delete?officialno=??? 에 해당하는 officialno 받기
		int official_reply_no = Integer.parseInt(req.getParameter("official_reply_no"));
		System.out.println(official_reply_no);
		
		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}	
		
		OfficialComment officialComment = new OfficialComment();
		officialComment.setOfficial_reply_no(official_reply_no);
		
		System.out.println(officialComment);
		
		//official_reply_no에 해당하는 글 지우기
		officialService.deleteComment(officialComment);

		//목록으로 리다이렉트
		resp.sendRedirect(req.getHeader("Referer"));
	}

}
