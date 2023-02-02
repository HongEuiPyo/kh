package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/hello [GET]");	
		
		//응답 데이터의 형식을 지정한다 ( HETML 형식 )
		resp.setContentType("text/html; charset=UTF-8");
		
		//응답용 출력 스트림
		PrintWriter out = resp.getWriter();
		
		//응답 내용 작성 및 출력 - HTML 형식으로 작성한다
		out.append("<h1>하이하이</h1>");
		out.append("<h3>잘되나여?</h3>");
		
	}
	
	
	
}
