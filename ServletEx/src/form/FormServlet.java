package form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/form.do [GET]");
		
		//JSP로 응답데이터 만들기 - VIEW 지정하기
		RequestDispatcher rd;		
		rd = req.getRequestDispatcher("/WEB-INF/views/inputForm.jsp");
		
		//지정된 JSP를 이용하여 응답 보내기
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/form.do [POST]");		
		// ----------------------------------------------
		// 요청 데이터의 한글 인코딩 방식 지정하기
		req.setCharacterEncoding("UTF-8");
		
		// 응답 데이터의 형식 지정하기
		resp.setContentType("text/html; charset=utf-8");
		// -----------------------------------------------
		
		String uid = req.getParameter("userid");
		String upw = req.getParameter("userpw");
		
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		// -----------------------------------------------
		
		// 서블릿에서 클라이언트로 직접 응답하기
		//	-> JSP(VIEW)를 이용하지 않는다
		
		
		resp.getWriter()
			.append("<h1>전달받은 데이터</h1>")
			.append("<hr>")
			.append("<h3>아이디 : " + uid + "</h3>")
			.append("<h3>패스워드 : " + upw + "</h3>");
		
		
		resp.getWriter()
			.append("<a href='/form.do'>입력 폼으로</a>");
	}
	
	
	
}
