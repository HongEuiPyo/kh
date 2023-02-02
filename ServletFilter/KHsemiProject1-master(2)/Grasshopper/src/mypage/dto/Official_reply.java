package mypage.dto;

import java.util.Date;

public class Official_reply {

	private int official_reply_no;
	private int official_board_no;
	private int user_no;
	private String official_reply_content;
	private Date official_reply_date;

	@Override
	public String toString() {
		return "Official_reply [official_reply_no=" + official_reply_no + ", official_board_no=" + official_board_no
				+ ", user_no=" + user_no + ", official_reply_content=" + official_reply_content
				+ ", official_reply_date=" + official_reply_date + "]";
	}

	public int getOfficial_reply_no() {
		return official_reply_no;
	}

	public void setOfficial_reply_no(int official_reply_no) {
		this.official_reply_no = official_reply_no;
	}

	public int getOfficial_board_no() {
		return official_board_no;
	}

	public void setOfficial_board_no(int official_board_no) {
		this.official_board_no = official_board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getOfficial_reply_content() {
		return official_reply_content;
	}

	public void setOfficial_reply_content(String official_reply_content) {
		this.official_reply_content = official_reply_content;
	}

	public Date getOfficial_reply_date() {
		return official_reply_date;
	}

	public void setOfficial_reply_date(Date official_reply_date) {
		this.official_reply_date = official_reply_date;
	}

}
