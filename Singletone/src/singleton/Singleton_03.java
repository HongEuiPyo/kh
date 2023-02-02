package singleton;

//단점 보완
// 1. 인스턴스를 사용하지 않아도 생성해놓게 된다
//	-> 지연된 초기화(Lazy Initialization)로 해결

// 2. 인스턴스를 생성할 때 추가 코드를 작성할 수 없다
//	-> 예외처리 불가능

public class Singleton_03 {
	
	public String data = "Apple"; // 데이터
	
	//private 생성자
	private Singleton_03() { }
	
	// 자기 클래스 변수
	private static Singleton_03 instance;
	
	public static Singleton_03 getInstance() {
		
		// 인스턴스를 생성한 적이 없을 때에만 객체 생성
		if( instance == null) {
			
			try {
				instance = new Singleton_03(); //싱글톤 객체 생성	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 싱글톤 객체 반환
		return instance;
	}
}
