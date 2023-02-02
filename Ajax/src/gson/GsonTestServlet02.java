package gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Person;


@WebServlet("/gson/test02")
public class GsonTestServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/gson/test02 [GET]");
		
		//	테스트용 객체 생성
		Person p1 = new Person();
		System.out.println( p1 );
		
		//	Gson 객체
		Gson gson = new Gson();
		
		System.out.println("----------");
		
		//	p1객체 -> JSON텍스트 (마샬링)
		String jsonText = gson.toJson( p1 );
		System.out.println("p1 JSON텍스트 : " + jsonText);
		
		System.out.println("----------");
		
		//	JSON 텍스트 -> p2 객체 (언마샬링)
		Person p2 = gson.fromJson( jsonText , Person.class);
		System.out.println("p2 객체 : " + p2);
		
		System.out.println("----------");
		
		//	HashMap<String, Object>타입으로 DTO를 대체할 수 있다
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("name", "Bob");
		map.put("age", 30);
		map.put("addr","Busan");
		map.put("phone","01012345678");
		
		System.out.println("--- map ---");
		System.out.println( map );	//	JAVA의 Map타입
		
		System.out.println("--- JSON 텍스트 ---");
		System.out.println( gson.toJson( map ));
		
		
		
	}
	
	
	

}





























