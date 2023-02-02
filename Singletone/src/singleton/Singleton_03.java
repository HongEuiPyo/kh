package singleton;

//���� ����
// 1. �ν��Ͻ��� ������� �ʾƵ� �����س��� �ȴ�
//	-> ������ �ʱ�ȭ(Lazy Initialization)�� �ذ�

// 2. �ν��Ͻ��� ������ �� �߰� �ڵ带 �ۼ��� �� ����
//	-> ����ó�� �Ұ���

public class Singleton_03 {
	
	public String data = "Apple"; // ������
	
	//private ������
	private Singleton_03() { }
	
	// �ڱ� Ŭ���� ����
	private static Singleton_03 instance;
	
	public static Singleton_03 getInstance() {
		
		// �ν��Ͻ��� ������ ���� ���� ������ ��ü ����
		if( instance == null) {
			
			try {
				instance = new Singleton_03(); //�̱��� ��ü ����	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// �̱��� ��ü ��ȯ
		return instance;
	}
}
