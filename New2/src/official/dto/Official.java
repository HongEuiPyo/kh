package official.dto;

import official.dao.OfficialDaoImpl;

import java.util.Date;

public class Official extends OfficialDaoImpl {
	
	private int official_cocktail_no; //글번호
	private String official_cocktail_name; //칵테일이름
	private String official_cocktail_detail; //설명
	private String official_cocktail_ingred; //재료 String ,로 구분해서 처리해야함
	private int official_cocktail_hit; //조회수
	private Date official_write_date; //최초작성일
		
	@Override
	public String toString() {
		return "Official [official_cocktail_no=" + official_cocktail_no + ", official_cocktail_name="
				+ official_cocktail_name + ", official_cocktail_detail=" + official_cocktail_detail
				+ ", official_cocktail_ingred=" + official_cocktail_ingred + ", official_cocktail_hit="
				+ official_cocktail_hit + ", official_write_date=" + official_write_date + "]";
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
	public int getOfficial_cocktail_hit() {
		return official_cocktail_hit;
	}
	public void setOfficial_cocktail_hit(int official_cocktail_hit) {
		this.official_cocktail_hit = official_cocktail_hit;
	}
	public Date getOfficial_write_date() {
		return official_write_date;
	}
	public void setOfficial_write_date(Date official_write_date) {
		this.official_write_date = official_write_date;
	}
}
