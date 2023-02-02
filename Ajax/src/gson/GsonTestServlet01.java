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
		
		//	Gson 객체
		Gson gson = new Gson();
		
//		gson.toJson(자바객체)
//			JAVA데이터 -> JSON텍스트 (마샬링)
		
		
//		gson.fromJson(JSON텍스트, 자바데이터타입)
//			JSON텍스트 -> JAVA데이터(언마샬링)
		
		//---------------------------------------------
		
		//	int형 데이터 -> JSON텍스트
		System.out.println( gson.toJson(123) );
		
		//	String형 데이터 -> JSON텍스트	("\"Apple\"")
		System.out.println( gson.toJson("Apple"));
		
		//	Long형 데이터 -> JSON텍스트 ("567")
		System.out.println( gson.toJson(new Long(567)) );
		
		//------------------------------------------------
		
		//	int[] 형 데이터
		int[] arr = {1,2,3,4,5};
		System.out.println("자바데이터 : " + arr );
		
		//	int[] -> JSON텍스트
		System.out.println("JSON텍스트 : " + gson.toJson(arr));
		
		//----------------------------------------------------
		
		//	JSON텍스트 -> int
		int n1 = gson.fromJson("123", int.class);
		System.out.println( n1 );
		
		//JSON텍스트 -> long
		long n2 = gson.fromJson("123", long.class);
		System.out.println( n2 );
		
		//JSON텍스트 -> double
		double n3 = gson.fromJson("123", double.class);
		System.out.println( n3 );
		
		
	}
	
}






























