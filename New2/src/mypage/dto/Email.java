package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

import java.util.Date;

public class Email extends MypageDaoImpl {

	
	private int email_no;
	private String admin_id;
	private String email_title;
	private String email_content;
	private Date email_date;
	@Override
	public String toString() {
		return "Email [email_no=" + email_no + ", admin_id=" + admin_id + ", email_title=" + email_title
				+ ", email_content=" + email_content + "]";
	}
	public int getEmail_no() {
		return email_no;
	}
	public void setEmail_no(int email_no) {
		this.email_no = email_no;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getEmail_title() {
		return email_title;
	}
	public void setEmail_title(String email_title) {
		this.email_title = email_title;
	}
	public String getEmail_content() {
		return email_content;
	}
	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}
	public Date getEmail_date() {
		return email_date;
	}
	public void setEmail_date(Date email_date) {
		this.email_date = email_date;
	}
	
	
	
	
}
