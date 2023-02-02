package join.dto;

import java.util.Date;

public class Member {
	private int user_no;
	private String user_email;
	private String user_password;
	private int user_point;
	private String user_name;
	private String user_birth;
	private int user_check;
	private String user_nickname;
	
	
	
	@Override
	public String toString() {
		return "User_Info [user_no=" + user_no + ", user_email=" + user_email + ", user_password=" + user_password
				+ ", user_point=" + user_point + ", user_name=" + user_name + ", user_birth=" + user_birth
				+ ", user_check=" + user_check + ", user_nickname=" + user_nickname + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public int getUser_check() {
		return user_check;
	}
	public void setUser_check(int user_check) {
		this.user_check = user_check;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	



}
