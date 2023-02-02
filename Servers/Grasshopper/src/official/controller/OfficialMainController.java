package official.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import official.dto.Official;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;
import util.Paging;

/**
 * Servlet implementation class OfficialMainController
 */
@WebServlet("/official/main")
public class OfficialMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	OfficialService officialService = new OfficialServiceImpl();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("/official/main [GET]");
    	System.out.println("[CONSOLE] /list로 리다이렉트합니다");
    	
//    	resp.sendRedirect("/official/list");
    	
		//세션 객체 생성
		HttpSession session = req.getSession();
		
		//세션 Attribute에 user_no 임의로 지정 (테스트용)
		session.setAttribute("user_no", 2);

		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}	
		
    	//기본적으로 default값이 주어진 /official/list 로 포워딩 한다
    	req.getRequestDispatcher("/official/list").forward(req, resp);
    	
    }

}
