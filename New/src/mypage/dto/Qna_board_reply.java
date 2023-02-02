package mypage.dto;

import java.util.Date;

public class Qna_board_reply {

	
	private int qna_reply_no;
	private int qna_board_no;
	private int user_no;
	private String qna_reply_content;
	private Date qna_reply_date;
	@Override
	public String toString() {
		return "Qna_board_reply [qna_reply_no=" + qna_reply_no + ", qna_board_no=" + qna_board_no + ", user_no="
				+ user_no + ", qna_reply_content=" + qna_reply_content + ", qna_reply_date=" + qna_reply_date + "]";
	}
	public int getQna_reply_no() {
		return qna_reply_no;
	}
	public void setQna_reply_no(int qna_reply_no) {
		this.qna_reply_no = qna_reply_no;
	}
	public int getQna_board_no() {
		return qna_board_no;
	}
	public void setQna_board_no(int qna_board_no) {
		this.qna_board_no = qna_board_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getQna_reply_content() {
		return qna_reply_content;
	}
	public void setQna_reply_content(String qna_reply_content) {
		this.qna_reply_content = qna_reply_content;
	}
	public Date getQna_reply_date() {
		return qna_reply_date;
	}
	public void setQna_reply_date(Date qna_reply_date) {
		this.qna_reply_date = qna_reply_date;
	}
	
	
}
