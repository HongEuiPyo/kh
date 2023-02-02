package mypage.dto;

import java.util.Date;

public class Free_board {

	
	private int free_board_no;
	private int user_no;
	private String free_board_title;
	private String free_board_content;
	private Date free_board_date;
	private int free_board_hit;
	private int free_board_vote;
	
	
	@Override
	public String toString() {
		return "Free_board [free_board_no=" + free_board_no + ", user_no=" + user_no + ", free_board_title="
				+ free_board_title + ", free_board_content=" + free_board_content + ", free_board_date="
				+ free_board_date + ", free_board_hit=" + free_board_hit + ", free_board_vote=" + free_board_vote + "]";
	}


	public int getFree_board_no() {
		return free_board_no;
	}


	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public String getFree_board_title() {
		return free_board_title;
	}


	public void setFree_board_title(String free_board_title) {
		this.free_board_title = free_board_title;
	}


	public String getFree_board_content() {
		return free_board_content;
	}


	public void setFree_board_content(String free_board_content) {
		this.free_board_content = free_board_content;
	}


	public Date getFree_board_date() {
		return free_board_date;
	}


	public void setFree_board_date(Date free_board_date) {
		this.free_board_date = free_board_date;
	}


	public int getFree_board_hit() {
		return free_board_hit;
	}


	public void setFree_board_hit(int free_board_hit) {
		this.free_board_hit = free_board_hit;
	}


	public int getFree_board_vote() {
		return free_board_vote;
	}


	public void setFree_board_vote(int free_board_vote) {
		this.free_board_vote = free_board_vote;
	}
	
	
	 
}
