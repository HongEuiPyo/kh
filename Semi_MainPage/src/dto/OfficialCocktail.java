package dto;

public class OfficialCocktail {
	
	private int official_cocktail_no; // 칵테일번호
    private String official_cocktail_name; //칵테일이름
    private String official_cocktail_detail; //칵테일설명
    private String official_cocktail_ingred; //칵테일재료
    private int official_cocktail_vote; //추천수
    private int attach_no; //칵테일 사진
    
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
