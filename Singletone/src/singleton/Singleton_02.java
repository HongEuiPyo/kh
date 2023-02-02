package singleton;

// �߰� �۾�(���� ó��)�� �� �ֵ��� ���� ����

public class Singleton_02 {

	public String data = "Apple";
	
	//private ������ - Ŭ���� �ܺο��� ��ü ���� ����
	private Singleton_02() {}
	
	// �ڱ� Ŭ������ ���� ��ü���� ����
	private static Singleton_02 instance;
	
	//static ���, �ʱ�ȭ ��� - Ŭ���� ������ �ʱ�ȭ�� �� ����Ѵ�
	static {
		try {
			
			//�̱��� ��ü ����
			instance = new Singleton_02();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�̱��� ��ü ��ȯ �޼ҵ�
	public static Singleton_02 getInstance() {
		return instance;
	}
	
}
