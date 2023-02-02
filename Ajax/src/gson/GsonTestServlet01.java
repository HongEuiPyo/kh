package gson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/gson/test01")
public class GsonTestServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/gson/test01 [GET]");
		
		//	Gson ��ü
		Gson gson = new Gson();
		
//		gson.toJson(�ڹٰ�ü)
//			JAVA������ -> JSON�ؽ�Ʈ (������)
		
		
//		gson.fromJson(JSON�ؽ�Ʈ, �ڹٵ�����Ÿ��)
//			JSON�ؽ�Ʈ -> JAVA������(�𸶼���)
		
		//---------------------------------------------
		
		//	int�� ������ -> JSON�ؽ�Ʈ
		System.out.println( gson.toJson(123) );
		
		//	String�� ������ -> JSON�ؽ�Ʈ	("\"Apple\"")
		System.out.println( gson.toJson("Apple"));
		
		//	Long�� ������ -> JSON�ؽ�Ʈ ("567")
		System.out.println( gson.toJson(new Long(567)) );
		
		//------------------------------------------------
		
		//	int[] �� ������
		int[] arr = {1,2,3,4,5};
		System.out.println("�ڹٵ����� : " + arr );
		
		//	int[] -> JSON�ؽ�Ʈ
		System.out.println("JSON�ؽ�Ʈ : " + gson.toJson(arr));
		
		//----------------------------------------------------
		
		//	JSON�ؽ�Ʈ -> int
		int n1 = gson.fromJson("123", int.class);
		System.out.println( n1 );
		
		//JSON�ؽ�Ʈ -> long
		long n2 = gson.fromJson("123", long.class);
		System.out.println( n2 );
		
		//JSON�ؽ�Ʈ -> double
		double n3 = gson.fromJson("123", double.class);
		System.out.println( n3 );
		
		
	}
	
}






























