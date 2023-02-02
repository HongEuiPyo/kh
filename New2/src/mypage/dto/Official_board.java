package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

import java.util.Date;

public class Official_board extends MypageDaoImpl {

	
	private int official_board_no;
	private String official_board_title;
	private String official_board_content;
	private Date official_board_date;
	private int official_board_vote;
	@Override
	public String toString() {
		return "Official_board [official_board_no=" + official_board_no + ", official_board_title="
				+ official_board_title + ", official_board_content=" + official_board_content + ", official_board_date="
				+ official_board_date + ", official_board_vote=" + official_board_vote + "]";
	}
	public int getOfficial_board_no() {
		return official_board_no;
	}
	public void setOfficial_board_no(int official_board_no) {
		this.official_board_no = official_board_no;
	}
	public String getOfficial_board_title() {
		return official_board_title;
	}
	public void setOfficial_board_title(String official_board_title) {
		this.official_board_title = official_board_title;
	}
	public String getOfficial_board_content() {
		return official_board_content;
	}
	public void setOfficial_board_content(String official_board_content) {
		this.official_board_content = official_board_content;
	}
	public Date getOfficial_board_date() {
		return official_board_date;
	}
	public void setOfficial_board_date(Date official_board_date) {
		this.official_board_date = official_board_date;
	}
	public int getOfficial_board_vote() {
		return official_board_vote;
	}
	public void setOfficial_board_vote(int official_board_vote) {
		this.official_board_vote = official_board_vote;
	}
	
	
	
	
	
	
}
