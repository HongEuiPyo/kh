package mypage.dto;

public class Officialcocktail {

	private int official_cocktail_no;
	private String official_cocktail_name;
	private String official_cocktail_detail;
	private String official_cocktail_ingred;
	private int official_cocktail_vote;

	@Override
	public String toString() {
		return "Officialcocktail [official_cocktail_no=" + official_cocktail_no + ", official_cocktail_name="
				+ official_cocktail_name + ", official_cocktail_detail=" + official_cocktail_detail
				+ ", official_cocktail_ingred=" + official_cocktail_ingred + ", official_cocktail_vote="
				+ official_cocktail_vote + "]";
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

}
