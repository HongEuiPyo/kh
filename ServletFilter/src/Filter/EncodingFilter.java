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
		
		System.out.println("--- ��Ʈ�ѷ� ���� �� ---");
		
		//��û ������ ���� �ѱ� ���ڵ� ����
		request.setCharacterEncoding("UTF-8");
		
		//��û������ ��Ʈ�ѷ��� �����Ѵ�
		chain.doFilter(request, response);
		
		
		System.out.println("--- ��Ʈ�ѷ� ���� �� ---");
	}

}
