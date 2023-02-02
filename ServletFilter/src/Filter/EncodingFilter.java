package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter - doFilter()");
		
		System.out.println("--- 컨트롤러 동작 전 ---");
		
		//요청 정보에 대한 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		//요청정보를 컨트롤러로 전달한다
		chain.doFilter(request, response);
		
		
		System.out.println("--- 컨트롤러 동작 후 ---");
	}

}
