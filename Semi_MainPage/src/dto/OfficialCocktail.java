package dto;

public class OfficialCocktail {
	
	private int official_cocktail_no; // Ĭ���Ϲ�ȣ
    private String official_cocktail_name; //Ĭ�����̸�
    private String official_cocktail_detail; //Ĭ���ϼ���
    private String official_cocktail_ingred; //Ĭ�������
    private int official_cocktail_vote; //��õ��
    private int attach_no; //Ĭ���� ����
    
	@Override
	public String toString() {
		return "OfficialCocktail [official_cocktail_no=" + official_cocktail_no + ", official_cocktail_name="
				+ official_cocktail_name + ", official_cocktail_detail=" + official_cocktail_detail
				+ ", official_cocktail_ingred=" + official_cocktail_ingred + ", official_cocktail_vote="
				+ official_cocktail_vote + ", attach_no=" + attach_no + "]";
	}

	public int getOfficial_cocktail_no() {
		return official_cocktail_no;
	}

	public void setOfficial_cocktail_no(int official_cocktail_no) {
		this.official_cocktail_no = official_cocktail_no;
	}

	public String getOfficial_cocktail_name() {
		return official_cocktail_name;
	}

	public void setOfficial_cocktail_name(String official_cocktail_name) {
		this.official_cocktail_name = official_cocktail_name;
	}

	public String getOfficial_cocktail_detail() {
		return official_cocktail_detail;
	}

	public void setOfficial_cocktail_detail(String official_cocktail_detail) {
		this.official_cocktail_detail = official_cocktail_detail;
	}

	public String getOfficial_cocktail_ingred() {
		return official_cocktail_ingred;
	}

	public void setOfficial_cocktail_ingred(String official_cocktail_ingred) {
		this.official_cocktail_ingred = official_cocktail_ingred;
	}

	public int getOfficial_cocktail_vote() {
		return official_cocktail_vote;
	}

	public void setOfficial_cocktail_vote(int official_cocktail_vote) {
		this.official_cocktail_vote = official_cocktail_vote;
	}

	public int getAttach_no() {
		return attach_no;
	}

	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}
    
	
    
    
    
}
